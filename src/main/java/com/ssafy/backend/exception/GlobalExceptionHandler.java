package com.ssafy.backend.exception;

import com.ssafy.backend.exception.error.ErrorCode;
import com.ssafy.backend.exception.error.ErrorResponse;
import com.ssafy.backend.exception.error.UserException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserException.class)
    public ResponseEntity<ErrorResponse> handleUserException(UserException ex) {
        ErrorCode errorCode = ex.getErrorCode();
        return ResponseEntity.status(errorCode.getHttpStatus()).body(ErrorResponse.of(errorCode));
    }
}
