package com.ssafy.backend.controller;


import com.ssafy.backend.dto.request.EmailAuthRequest;
import com.ssafy.backend.dto.request.EmailRequest;
import com.ssafy.backend.dto.response.EmailAuthResponse;
import com.ssafy.backend.dto.response.EmailSendResponse;
import com.ssafy.backend.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class EmailController {

    private final EmailService emailService;

    @PostMapping("/email")
    public ResponseEntity<EmailSendResponse> sendEmail(@RequestBody EmailRequest emailRequest){

        return ResponseEntity.ok().body(emailService.sendEmail(emailRequest.getEmail()));
    }

    @PostMapping("/authentication")
    public ResponseEntity<EmailAuthResponse> checkCode(@RequestBody EmailAuthRequest authRequest){

        return ResponseEntity.ok().body(emailService.checkCode(authRequest.getEmail(), authRequest.getAuthentication()));
    }
}
