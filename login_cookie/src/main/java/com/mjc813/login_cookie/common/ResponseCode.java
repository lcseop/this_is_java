package com.mjc813.login_cookie.common;

public enum ResponseCode {
    SUCCESS,
    INSERT_ERROR,
    UPDATE_ERROR,
    DELETE_ERROR,
    SELECT_ERROR,
    DATA_NOT_FOUND_ERROR,
    AUTHENTICATION_ERROR, // 로그인 인증 에러
    AUTHORIZATION_ERROR, // 자원을 사용하기 위한 권한 인가 에러
}
