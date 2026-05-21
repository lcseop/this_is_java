package com.mjc813.login_cookie.models.member;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberDto {
    private Long id;
    private String signId;
    private String password;
    private String email;
    private Boolean isValidEmail;
    private LocalDateTime createDt;
    private LocalDateTime updateDt;
    private LocalDateTime deleteDt;
}
