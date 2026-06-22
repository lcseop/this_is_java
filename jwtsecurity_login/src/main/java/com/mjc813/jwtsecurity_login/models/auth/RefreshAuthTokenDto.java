package com.mjc813.jwtsecurity_login.models.auth;

import lombok.Getter;

@Getter
public class RefreshAuthTokenDto extends AuthTokenDto {
    private final String signId;

    public RefreshAuthTokenDto(String signId, String accessToken, String refreshToken) {
        super(accessToken, refreshToken);
        this.signId = signId;
    }
}
