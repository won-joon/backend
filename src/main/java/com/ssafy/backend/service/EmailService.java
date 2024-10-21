package com.ssafy.backend.service;

import com.ssafy.backend.dto.response.EmailAuthResponse;
import com.ssafy.backend.dto.response.EmailSendResponse;
import jakarta.servlet.http.HttpServletRequest;

public interface EmailService {

    EmailSendResponse sendEmail(String email, HttpServletRequest request);
    EmailAuthResponse checkCode(String code, HttpServletRequest request);
}
