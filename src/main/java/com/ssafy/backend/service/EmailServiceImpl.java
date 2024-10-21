package com.ssafy.backend.service;

import com.ssafy.backend.dto.response.EmailAuthResponse;
import com.ssafy.backend.dto.response.EmailSendResponse;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService{

    private final JavaMailSender javaMailSender;

    private String generateCode() {
        // 임시 코드 생성 로직 (6자리 랜덤 문자열)
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        SecureRandom random = new SecureRandom();
        StringBuilder tempCode = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            tempCode.append(characters.charAt(random.nextInt(characters.length())));
        }
        log.info("임시 코드 : " + tempCode.toString());

        return tempCode.toString();
    }

    @Override
    public EmailSendResponse sendEmail(String email, HttpServletRequest request) {

        String authCode = generateCode();

        MimeMessage message = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
            helper.setTo(email);
            helper.setSubject("이메일 인증 안내");
            helper.setText("<p>안녕하세요,</p><p>임시 코드는 다음과 같습니다: <strong>" + authCode + "</strong></p><p> 로 인증을 완료해주세요.</p>", true);
            javaMailSender.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

        // 인증 코드 세션 저장
        HttpSession httpSession = request.getSession();
        httpSession.setAttribute("authCode", authCode);

        return new EmailSendResponse(true);
    }

    @Override
    public EmailAuthResponse checkCode(String code, HttpServletRequest request) {
        HttpSession session = request.getSession();

        // 세션에서 인증 코드 조회
        String storedCode = (String) session.getAttribute("authCode");

        if(code.equals(storedCode)){
            return new EmailAuthResponse(true);
        }else{
            return new EmailAuthResponse(false);
        }
    }
}
