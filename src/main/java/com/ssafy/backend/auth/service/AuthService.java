package com.ssafy.backend.auth.service;

import com.ssafy.backend.auth.config.SocialLoginProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

//@Service
//@RequiredArgsConstructor
//public class AuthService {
//
//    private final SocialLoginProperties socialLoginProperties;
//
//    public SocialMemberDto socialLogin(String code, String registrationId) {
//
//        // registartionId 에 맞는 설정값 가져옴
//        SocialProvider provider = socialLoginProperties.getProviders().get(registrationId);
//
//        // 토큰 발급
//        String accessToken = getAccessToken(code, provider);
//
//        // 토큰 이용해서 유저 정보 발급
//        JsonNode userResourceNode = getUserResource(accessToken, provider);
//
//        if (registrationId.equals("naver")) {
//            userResourceNode = userResourceNode.get("response");
//        }
//
//        String email = userResourceNode.get("email").asText();
//        String nickname = registrationId + "_" + userResourceNode.get("name").asText();
//
//        // JWT 토큰 반환
//        return socialUser(email);
//    }
//}
