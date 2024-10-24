package com.ssafy.backend.dto.response;

import lombok.Getter;

@Getter
public class EmailSendResponse {
    private boolean isOk;

    public EmailSendResponse(boolean isOk) {
        this.isOk = isOk;
    }

}
