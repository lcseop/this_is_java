package com.mjc813.sbsecurity_login.conf;

import com.mjc813.sbsecurity_login.model.member.MemberDto;
import com.mjc813.sbsecurity_login.model.member.MemberService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class LCSAuthenticationFilter extends OncePerRequestFilter {
    @Autowired
    private MemberService memberService;

    @Override
    protected void doFilterInternal(HttpServletRequest request
            , HttpServletResponse response
            , FilterChain filterChain) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Object signObject = session.getAttribute("MJC_LOGIN");
        if ( signObject instanceof String signId ) {
            MemberDto find = this.memberService.findBySignId(signId);
            UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
                    find, null, find.getAuthorities()
            );
            SecurityContextHolder.getContext().setAuthentication(auth);
        }
        filterChain.doFilter(request, response);
    }
}
