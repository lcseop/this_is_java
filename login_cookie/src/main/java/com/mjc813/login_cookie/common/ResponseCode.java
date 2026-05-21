package com.mjc813.login_cookie.common;

import lombok.Getter;

@Getter
public enum ResponseCode {
    SUCCESS(10000),
    INSERT_ERROR(41000),
    UPDATE_ERROR(41000),
    DELETE_ERROR(41000),
    SELECT_ERROR(41000),
    DATA_NOT_FOUND_ERROR(41000),
    AUTHENTICATION_ERROR(41000), // 로그인 인증 에러
    AUTHORIZATION_ERROR(41000);// 자원을 사용하기 위한 권한 인가 에러

    private Integer code;

    ResponseCode(Integer code) {
        this.code = code;
    }
}
