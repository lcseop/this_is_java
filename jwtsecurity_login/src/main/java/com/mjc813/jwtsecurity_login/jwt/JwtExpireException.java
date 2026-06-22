package com.mjc813.jwtsecurity_login.jwt;

public class JwtExpireException extends RuntimeException {
    // checked exception 예외를 try-catch, throws 등 예외를 처리하지 않으면 컴파일 에러 발생
    // 데이터베이스 트랜잭션을 처리를 하지 않고, 성공이든 실패든 commit을 해줌
    public JwtExpireException(String message){
        super(message);
    }
}
