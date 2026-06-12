package com.mjc813.login_spbsec_cookie.models.member;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberDto implements IMember {
	private Long id;
	private String signId;
	private String password;
	private String email;
	private String role;
	private Boolean isValidEmail;
	private String validText;
	private LocalDateTime createDt;
	private LocalDateTime updateDt;
	private LocalDateTime deleteDt;

}
