package com.mjc813.login_session.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Mjc813Exception extends RuntimeException {
    private ResponseCode code;
    private String message;
}
