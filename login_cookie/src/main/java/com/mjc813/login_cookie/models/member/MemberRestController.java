package com.mjc813.login_cookie.models.member;

import com.mjc813.login_cookie.common.ComResponseDto;
import com.mjc813.login_cookie.common.ResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/member")
public class MemberRestController {
    @Autowired
    private MemberService memberService;

    public ResponseEntity<ComResponseDto<MemberDto>> insert(@RequestBody MemberDto memberDto) {
        MemberDto result = this.memberService.insert(memberDto);
        return ResponseEntity.status(201).body(
                ComResponseDto.make(ResponseCode.SUCCESS, result)
        );
    }
}
