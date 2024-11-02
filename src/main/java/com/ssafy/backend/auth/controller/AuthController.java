package com.ssafy.backend.auth.controller;

import com.ssafy.backend.auth.dto.TokenDto;
import com.ssafy.backend.auth.dto.request.TokenRequest;
import com.ssafy.backend.auth.dto.response.MemberResponse;
import com.ssafy.backend.auth.dto.response.TokenResponse;
import com.ssafy.backend.auth.service.AuthService;
import com.ssafy.backend.exception.error.UserErrorCode;
import com.ssafy.backend.exception.error.UserException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/oauth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/auth")
    public ResponseEntity<TokenResponse> getToken(@RequestBody(required = false) TokenRequest tokenRequest) {

        if(tokenRequest == null){
            throw new UserException(UserErrorCode.AUTH_CODE_NOT_FOUND);
        }

        TokenDto tokenDto = authService.socialLogin(tokenRequest.code());

        ResponseCookie cookie = ResponseCookie.from("refreshToken", tokenDto.getRefreshToken())
                .httpOnly(true)
                .secure(true)
                .sameSite("None")
                .build();

        return ResponseEntity.ok()
                .header(HttpHeaders.SET_COOKIE, cookie.toString())
                .body(new TokenResponse(tokenDto.getAccessToken()));
    }

    @GetMapping("/member")
    public ResponseEntity<MemberResponse> getNickname(@RequestHeader(value = "Authorization", required = false) String token) {

        if (token == null) {
            throw new UserException(UserErrorCode.ACCESS_TOKEN_NOT_FOUND);
        }

        return ResponseEntity.ok().body(authService.getNickname(token));
    }

}
