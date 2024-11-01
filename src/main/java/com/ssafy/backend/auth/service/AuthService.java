package com.ssafy.backend.auth.service;

import com.ssafy.backend.auth.dto.TokenDto;
import com.ssafy.backend.auth.dto.response.MemberResponse;

public interface AuthService {

    TokenDto socialLogin(String code);

    MemberResponse getNickname(String accessToken);
}
