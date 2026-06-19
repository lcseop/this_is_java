package com.mjc813.sbsecurity_login.model.member;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component("memberAuth")
@RequiredArgsConstructor
public class MemberAuthService {
    private final MemberJpaRepository memberJpaRepository;

    public boolean isSelfOrAdmin(Long id, Authentication authentication) {
        boolean isAdmin = authentication.getAuthorities().stream()
                .anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"));
        if (isAdmin) {
            return true;
        }

        return memberJpaRepository.findById(id)
                .map(m -> m.getSignId().equals(authentication.getName()))
                .orElse(false);
    }
}
