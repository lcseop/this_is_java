package com.mjc813.login_cookie.models.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    @Autowired
    private MemberRepository memberRepository;

    public MemberDto insert(MemberDto memberDto) {
        MemberEntity memberEntity = (MemberEntity) new MemberEntity().clone(memberDto, true);
        memberEntity.setId(null);
        MemberEntity result = this.memberRepository.save(memberEntity);
        return (MemberDto) new MemberDto().clone(result, true);
    }
}
