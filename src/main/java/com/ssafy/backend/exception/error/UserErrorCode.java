package com.ssafy.backend.exception.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum UserErrorCode implements ErrorCode {

    AUTH_CODE_NOT_FOUND(HttpStatus.BAD_REQUEST, "ERR_MISSING_AUTHORIZATION_CODE"),
    ACCESS_TOKEN_NOT_FOUND(HttpStatus.BAD_REQUEST, "ERR_MISSING_ACCESS_TOKEN"),
    ACCESS_TOKEN_EXPIRED(HttpStatus.UNAUTHORIZED, "ERR_ACCESS_TOKEN_EXPIRED"),
    MEMBER_NOT_FOUND(HttpStatus.NOT_FOUND, "ERR_NOT_FOUND_MEMBER"),
    REFRESH_TOKEN_NOT_FOUND(HttpStatus.BAD_REQUEST, "ERR_MISSING_REFRESH_TOKEN"),
    REFRESH_TOKEN_EXPIRED(HttpStatus.UNAUTHORIZED, "ERR_REFRESH_TOKEN_EXPIRED"),
    ;

    private final HttpStatus httpStatus;
    private final String code;

}
