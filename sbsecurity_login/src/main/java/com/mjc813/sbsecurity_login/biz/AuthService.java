package com.mjc813.sbsecurity_login.biz;

import com.mjc813.sbsecurity_login.common.LoginException;
import com.mjc813.sbsecurity_login.model.auth.SignInDto;
import com.mjc813.sbsecurity_login.model.member.MemberEntity;
import com.mjc813.sbsecurity_login.model.member.MemberJpaRepository;
import com.mjc813.sbsecurity_login.model.member.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
	@Autowired
	private MemberJpaRepository memberJpaRepository;

	public Boolean signMember(SignInDto signInDto) throws LoginException {
		MemberEntity find = this.memberJpaRepository.findBySignId(signInDto.getSignId()).orElseThrow();
		if ( !find.getIsValidEmail() ) {
			throw new LoginException("not valid email");
		}
		if ( find.getRole().equals(Role.GUEST.toString()) ) {
			throw new LoginException("doesn't need login");
		}
		if ( signInDto.getPassword().equals(find.getPassword()) ) {
			return true;
		}
		return false;
	}
}
