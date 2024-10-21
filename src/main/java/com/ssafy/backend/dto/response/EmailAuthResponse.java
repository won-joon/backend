package com.ssafy.backend.dto.response;

public class EmailAuthResponse {
    private boolean isSuccess;

    public EmailAuthResponse(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }
}
