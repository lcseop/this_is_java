package com.mjc813.jwtsecurity_login.jwt;

public class JwtIllegalException extends RuntimeException {
    // 이 예외를 처리하지 않아도 컴파일 에러가 발생하지 않는다.
    // 데이터베이스 트랜잭션을 처리할 수 있게 해주고, 성공 시 모든 쿼리를 실행해줌
    // 실패하며 쿼리를 rollback 해줌
    public JwtIllegalException(String message){
        super(message);
    }
}
