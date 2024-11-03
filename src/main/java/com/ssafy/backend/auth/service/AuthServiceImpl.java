package com.ssafy.backend.auth.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.ssafy.backend.auth.config.SocialConfig;
import com.ssafy.backend.auth.dto.TokenDto;
import com.ssafy.backend.auth.dto.response.MemberResponse;
import com.ssafy.backend.auth.dto.response.TokenResponse;
import com.ssafy.backend.domain.Member;
import com.ssafy.backend.exception.error.UserErrorCode;
import com.ssafy.backend.exception.error.UserException;
import com.ssafy.backend.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{

    private final WebClient webClient = WebClient.builder().build();
    private final SocialConfig socialConfig;
    private final MemberRepository memberRepository;

    public TokenDto socialLogin(String code) {
        // 토큰 발급
        JsonNode node = getAccessToken(code);
        String accessToken = node.get("access_token").asText();
        String refreshToken = node.get("refresh_token").asText();

        // 사용자 정보 발급
        String nickname = getUserInfo("Bearer " + accessToken);

        if(!memberRepository.existsByAccessToken(accessToken)){
            memberRepository.save(Member.of(nickname, accessToken, refreshToken));
        }

        return new TokenDto(accessToken, refreshToken);
    }

    @Override
    public MemberResponse getNickname(String accessToken) {
        // 토큰 유효성 검증
        validateAccessToken(accessToken);

        // accessToken으로 nickname 조회 및 예외 처리
        String nickname = memberRepository.findNicknameByAccessToken(accessToken.substring(7))
                .orElseThrow(() -> new UserException(UserErrorCode.MEMBER_NOT_FOUND));

        return new MemberResponse(nickname);
    }

    @Override
    @Transactional
    public TokenResponse reissueToken(String refreshToken) {
        // 토큰 재발급
        String accessToken = reissueAccessToken(refreshToken);

        // refreshToken 으로 Member 조회 및 업데이트
        Member member = memberRepository.findByRefreshToken(refreshToken);

        member.setAccessToken(accessToken);

        return new TokenResponse(accessToken);
    }

    private JsonNode getAccessToken(String authCode) {
        return webClient.post()
                .uri(socialConfig.getTokenUri())  // token-uri 값 사용
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_FORM_URLENCODED_VALUE)
                .body(BodyInserters.fromFormData("code", authCode)
                        .with("client_id", socialConfig.getClientId())  // client-id 값 사용
                        .with("redirect_uri", socialConfig.getRedirectUri())  // redirect-uri 값 사용
                        .with("grant_type", socialConfig.getAuthorizationGrantType()))
                .retrieve()
                .bodyToMono(JsonNode.class)
                .block();
    }

    private String getUserInfo(String accessToken) {
        return webClient.get()
                .uri(socialConfig.getResourceUri())
                .header(HttpHeaders.AUTHORIZATION, accessToken)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_FORM_URLENCODED_VALUE)
                .retrieve()
                .bodyToMono(JsonNode.class)
                .map(responseNode -> responseNode.get("properties").get("nickname").asText())
                .block();
    }

    private void validateAccessToken(String accessToken) {
        try {
            webClient.get()
                    .uri(socialConfig.getTokenInfoUri())
                    .header(HttpHeaders.AUTHORIZATION, accessToken)
                    .retrieve()
                    .bodyToMono(Void.class) // 응답 내용을 사용하지 않으므로 void로 설정
                    .block();

        } catch (WebClientResponseException.Unauthorized e) {
            // 토큰이 유효하지 않음
            throw new UserException(UserErrorCode.ACCESS_TOKEN_EXPIRED);
        }
    }

    private String reissueAccessToken(String refreshToken) {
        try{
            return webClient.post()
                    .uri(socialConfig.getTokenUri())  // token-uri 값 사용
                    .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_FORM_URLENCODED_VALUE)
                    .body(BodyInserters.fromFormData("refresh_token", refreshToken)
                            .with("client_id", socialConfig.getClientId())
                            .with("grant_type", "refresh_token"))
                    .retrieve()
                    .bodyToMono(JsonNode.class)
                    .map(responseNode -> responseNode.get("access_token").asText())
                    .block();
        } catch (WebClientResponseException.Unauthorized e) {
            // 토큰이 유효하지 않음
            throw new UserException(UserErrorCode.REFRESH_TOKEN_EXPIRED);
        }
    }
}
