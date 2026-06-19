package com.mjc813.session_login.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Mjc813Exception extends Exception {
    private ResponseCode code;
    private String message;
}
