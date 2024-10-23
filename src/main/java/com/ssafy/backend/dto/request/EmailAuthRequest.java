package com.ssafy.backend.dto.request;

import lombok.Getter;

@Getter
public class EmailAuthRequest {
    private String email;
    private String authentication;
}
