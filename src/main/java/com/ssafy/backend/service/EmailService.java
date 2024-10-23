package com.ssafy.backend.service;

import com.ssafy.backend.dto.response.EmailAuthResponse;
import com.ssafy.backend.dto.response.EmailSendResponse;

public interface EmailService {

    EmailSendResponse sendEmail(String email);
    EmailAuthResponse checkCode(String email, String code);
}
