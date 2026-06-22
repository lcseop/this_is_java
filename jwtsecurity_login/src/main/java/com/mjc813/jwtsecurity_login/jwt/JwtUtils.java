package com.mjc813.jwtsecurity_login.jwt;


import com.mjc813.jwtsecurity_login.models.member.IMember;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Slf4j
@Component
public class JwtUtils {
//    @Value("{myapp.jwt.secret}")
    private String secret = "thisismyjwtsecretkey!123456abcdef";
//    @Value("{myapp.jwt.expireAccessToken}")
    private Long expireAccessToken = 1800000L;
    private Long expireRefreshToken = 604800000L;

    private final SecretKey secretKey;

    public JwtUtils() {
        this.secretKey = Keys.hmacShaKeyFor(secret.getBytes());
    }

    public String generateAccessToken(String value) {
        return this.generateToken(value, this.expireAccessToken);
    }

    public String generateRefreshToken(String value) {
        return this.generateToken(value, this.expireRefreshToken);
    }

    public String generateToken(String value, Long milliSeconds) {
        String str = Jwts.builder()
                .subject(value)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + this.expireAccessToken))
                .signWith(this.secretKey)
                .compact();
        return str;
    }

    public String generateToken(IMember member, Long milliSeconds) {
        String str = Jwts.builder()
                .subject(member.getSignId())
                .claim("role", member.getRole()) // subject 뒤에 부가정보는 claim으로 추가할 수 있다.
                .claim("email", member.getEmail()) // jwt에 부가정보 중 개인정보를 넣으면 위험하다
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + this.expireAccessToken))
                .signWith(this.secretKey)
                .compact();
        return str;
    }

    public Claims parseToken(String token) {
        try {
            Claims cl = Jwts.parser()
                    .verifyWith(this.secretKey)
                    .build()
                    .parseSignedClaims(token)
                    .getPayload();
            return cl;
        } catch (ExpiredJwtException e) {
            log.error(e.getMessage());
            throw new JwtExpireException(e.getMessage());
        } catch (IllegalArgumentException e) {
            log.error(e.getMessage());
            throw e;
        } catch (JwtException e) {
            log.error(e.getMessage());
            throw e;
        }
    }

    public String getRole(String token) {
        Claims cl = this.parseToken(token);
        return cl.get("role",String.class);
    }


    public String getEmail(String token) {
        Claims cl = this.parseToken(token);
//        return cl.get("role",String.class);
        return this.getValueFromClaims(token, "email");
    }

    public String getValueFromClaims(String token, String key) {
        Claims cl = this.parseToken(token);
        return cl.get(key, String.class);
    }

    public String getSignId(String token) {
        Claims cl = this.parseToken(token);
        return cl.getSubject();
    }

    public Boolean validateToken(String token) throws JwtExpireException {
        this.parseToken(token);
        return true;
    }

    public String resolveTokenFromHeader(String bearerToken) {
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }
}
