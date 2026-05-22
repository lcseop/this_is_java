package com.mjc813.login_cookie.models.auth;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mjc813.login_cookie.models.member.IMember;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SignUpDto implements IMember {
    @JsonIgnore
    private Long id;

    private String signId;
    private String password;
    private String email;

    @JsonIgnore
    private String role;

    @JsonIgnore
    private String validText;

    @JsonIgnore
    private Boolean isValidEmail;

    @JsonIgnore
    private LocalDateTime createDt;

    @JsonIgnore
    private LocalDateTime updateDt;

    @JsonIgnore
    private LocalDateTime deleteDt;
}
