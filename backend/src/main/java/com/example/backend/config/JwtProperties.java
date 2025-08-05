package com.example.backend.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "jwt")
public class JwtProperties {
    /** Tajni ključ za potpisivanje tokena */
    private String secret;
    /** Isticanje tokena u milisekundama */
    private long expirationMs;

    public String getSecret() {
        return secret;
    }
    public void setSecret(String secret) {
        this.secret = secret;
    }
    public long getExpirationMs() {
        return expirationMs;
    }
    public void setExpirationMs(long expirationMs) {
        this.expirationMs = expirationMs;
    }
}
