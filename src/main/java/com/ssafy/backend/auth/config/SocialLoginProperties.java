package com.ssafy.backend.auth.config;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
@ConfigurationProperties(prefix = "auth.client.registration")
@Getter
public class SocialLoginProperties {
    private Map<String, SocialProvider> providers;
}
