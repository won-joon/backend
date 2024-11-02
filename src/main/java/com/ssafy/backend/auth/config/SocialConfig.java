package com.ssafy.backend.auth.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "auth.client.registration.kakao")
@Getter
@Setter
public class SocialConfig{
    private String clientId;
    private String redirectUri;
    private String tokenUri;
    private String resourceUri;
    private String authorizationGrantType;
    private String tokenInfoUri;
}
