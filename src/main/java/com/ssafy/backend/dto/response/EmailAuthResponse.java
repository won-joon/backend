package com.ssafy.backend.dto.response;

import lombok.Getter;

@Getter
public class EmailAuthResponse {
    private boolean isSuccess;

    public EmailAuthResponse(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }
}
