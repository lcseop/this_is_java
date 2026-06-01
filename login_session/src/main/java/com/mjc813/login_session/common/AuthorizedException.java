package com.mjc813.login_session.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class AuthorizedException extends RuntimeException {
    private String message;
}
