package com.ssafy.backend.auth.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberResponse {
    private String nickname;

    public MemberResponse(String nickname) {
        this.nickname = nickname;
    }
}
