package com.mjc813.sbsecurity_login.model.member;

import com.mjc813.sbsecurity_login.common.ComResponseDto;
import com.mjc813.sbsecurity_login.common.ResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/member")
public class 	MemberRestController {
	@Autowired
	private MemberService memberService;

	@PostMapping("")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<ComResponseDto<MemberDto>> insert(@RequestBody MemberDto memberDto) {
		MemberDto result = this.memberService.insert(memberDto, true);
		return ResponseEntity.status(201).body(
			ComResponseDto.make(ResponseCode.SUCCESS, result)
		);
	}

	@PatchMapping("")
	@PreAuthorize("hasRole('ADMIN') or #memberDto.signId == authentication.name")
	public ResponseEntity<ComResponseDto<MemberDto>> update(@RequestBody MemberDto memberDto) {
		MemberDto result = this.memberService.update(memberDto);
		return ResponseEntity.status(201).body(
				ComResponseDto.make(ResponseCode.SUCCESS, result)
		);
	}

	@DeleteMapping("/{id}")
	@PreAuthorize("@memberAuth.isSelfOrAdmin(#id, authentication)")
	public ResponseEntity<ComResponseDto<MemberDto>> delete(@PathVariable Long id, Authentication authentication) {
		MemberDto result = this.memberService.deleteById(id);
		return ResponseEntity.status(201).body(
				ComResponseDto.make(ResponseCode.SUCCESS, result)
		);
	}

	@GetMapping("/{id}")
	@PreAuthorize("@memberAuth.isSelfOrAdmin(#id, authentication)")
	public ResponseEntity<ComResponseDto<MemberDto>> findById(@PathVariable Long id, Authentication authentication) {
		MemberDto result = this.memberService.findById(id);
		return ResponseEntity.status(201).body(
				ComResponseDto.make(ResponseCode.SUCCESS, result)
		);
	}

	@GetMapping("")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<ComResponseDto<List<MemberDto>>> findAll(Model model) {
		Object obj = model.getAttribute("signedMember");
		if (obj instanceof IMember signedMember && !Role.ADMIN.toString().equals(signedMember.getRole())) {
			return ResponseEntity.status(403).body(
					ComResponseDto.make(ResponseCode.AUTHORIZATION_ERROR, null)
			);
		}
		List<MemberDto> result = this.memberService.findAll();
		return ResponseEntity.status(200).body(
				ComResponseDto.make(ResponseCode.SUCCESS, result)
		);
	}
}
