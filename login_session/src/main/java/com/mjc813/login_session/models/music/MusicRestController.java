package com.mjc813.login_session.models.music;

import com.mjc813.login_session.common.ComResponseDto;
import com.mjc813.login_session.common.LoginException;
import com.mjc813.login_session.common.Mjc813Exception;
import com.mjc813.login_session.common.ResponseCode;
import com.mjc813.login_session.models.member.IMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/music")
public class MusicRestController {
	@Autowired
	private MusicService musicService;

	@PostMapping()
	public ResponseEntity<ComResponseDto<MusicDto>> insert(Model model, @RequestBody MusicDto insertDto) throws LoginException {
//		IMember signedMember = (IMember)model.getAttribute("signedMember");
		// Model 클래스에 "signedMember" 키에 해당하는 MemberDto 가 존재하는지 찾는다.
		IMember signedMember = this.IsUserOrAdmin(model);
		if ( signedMember == null ) {
			// 존재하지 않으면 인가 에러를 출력한다.
			return ResponseEntity.status(500).body(
				ComResponseDto.make(ResponseCode.AUTHORIZATION_ERROR, null)
			);
		}

		MusicDto result = this.musicService.insert(getIMember(model), insertDto);
		return ResponseEntity.status(201).body(
			ComResponseDto.make(ResponseCode.SUCCESS, result)
		);
	}

	@PatchMapping()
	public ResponseEntity<ComResponseDto<MusicDto>> update(Model model, @RequestBody MusicDto insertDto) {
		IMember signedMember = this.IsAdmin(model);
		if ( signedMember == null && !musicService.getCreateId(insertDto.getId()).equals(getIMember(model).getSignId()) ) {
			return ResponseEntity.status(500).body(
					ComResponseDto.make(ResponseCode.AUTHORIZATION_ERROR, null)
			);
		}

		MusicDto result = this.musicService.update(getIMember(model), insertDto);
		return ResponseEntity.status(200).body(
				ComResponseDto.make(ResponseCode.SUCCESS, result)
		);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ComResponseDto<MusicDto>> delete(Model model, @PathVariable Long id) {
		IMember signedMember = this.IsAdmin(model);
		if ( signedMember == null && !musicService.getCreateId(id).equals(getIMember(model).getSignId()) ) {
			return ResponseEntity.status(500).body(
					ComResponseDto.make(ResponseCode.AUTHORIZATION_ERROR, null)
			);
		}

		MusicDto result = this.musicService.delete(getIMember(model), id);
		return ResponseEntity.status(200).body(
				ComResponseDto.make(ResponseCode.SUCCESS, result)
		);
	}


	@GetMapping("/{id}")
	public ResponseEntity<ComResponseDto<MusicDto>> findById(@PathVariable Long id) {
		MusicDto result = this.musicService.findById(id);
		return ResponseEntity.status(200).body(
				ComResponseDto.make(ResponseCode.SUCCESS, result)
		);
	}

	@GetMapping("/all")
	public ResponseEntity<ComResponseDto<List<MusicDto>>> findAll(
//			HttpServletRequest request
			@SessionAttribute(name = "MJC_LOGIN", required = false) String signId
	) {
		try {
			if (signId != null) {
				// 로그인 되어 있음
				List<MusicDto> result = this.musicService.findAll();
				return ResponseEntity.status(200).body(
						ComResponseDto.make(ResponseCode.SUCCESS, result)
				);
			} else {
				// 로그인 안되어 있음
				return ResponseEntity.status(500).body(
						ComResponseDto.make(ResponseCode.AUTHORIZATION_ERROR, null)
				);
			}
		} catch (Exception e) {
			return ResponseEntity.status(500).body(
					ComResponseDto.make(ResponseCode.AUTHORIZATION_ERROR, null)
			);
		}
	}

	// role 이 USER 인지 체크
	private IMember IsUser(Model model) {
		IMember signedMember = (IMember)model.getAttribute("signedMember");
		if ( signedMember == null || !signedMember.getRole().equals("USER") ) {
			return null;
		}
		return signedMember;
	}

	private IMember IsUserOrAdmin(Model model) {
		IMember signedMember = (IMember)model.getAttribute("signedMember");
		if ( signedMember == null || signedMember.getRole().equals("GUEST") ) {
			return null;
		}
		return signedMember;

	}

	private IMember IsAdmin(Model model) {
		IMember signedMember = (IMember)model.getAttribute("signedMember");
		if ( signedMember == null || !signedMember.getRole().equals("ADMIN") ) {
			return null;
		}
		return signedMember;
	}

	private IMember getIMember(Model model) {
        return (IMember)model.getAttribute("signedMember");
	}
}
