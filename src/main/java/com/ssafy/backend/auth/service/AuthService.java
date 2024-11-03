package com.ssafy.backend.auth.service;

import com.ssafy.backend.auth.dto.TokenDto;
import com.ssafy.backend.auth.dto.response.MemberResponse;
import com.ssafy.backend.auth.dto.response.TokenResponse;

public interface AuthService {

    TokenDto socialLogin(String code);

    MemberResponse getNickname(String accessToken);

    TokenResponse reissueToken(String refreshToken);
}
