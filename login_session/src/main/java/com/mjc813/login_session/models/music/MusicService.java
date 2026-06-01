package com.mjc813.login_session.models.music;

import com.mjc813.login_session.common.AuthorizedException;
import com.mjc813.login_session.common.Mjc813Exception;
import com.mjc813.login_session.common.ResponseCode;
import com.mjc813.login_session.models.member.IMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class MusicService {
	@Autowired
	private MusicJpaRepository musicJpaRepository;

	public MusicDto insert(IMember member, MusicDto insertDto) {
		MusicEntity musicEntity = (MusicEntity)new MusicEntity().copyMembers(insertDto, true);

		musicEntity.setCreateId(member.getSignId());
		musicEntity.setCreateDt(LocalDateTime.now());
		musicEntity.setId(null);
		MusicEntity saved = this.musicJpaRepository.save(musicEntity);
		MusicDto musicDto = (MusicDto)new MusicDto().copyMembers(saved, true);
		return musicDto;
	}

	public MusicDto update(IMember member, MusicDto insertDto) {
		MusicEntity musicEntity = musicJpaRepository.findById(insertDto.getId()).orElseThrow();
		MusicEntity update = (MusicEntity)new MusicEntity().copyMembers(insertDto, true);

		MusicEntity result = (MusicEntity) musicEntity.copyMembers(update, false);
		musicEntity.setUpdateId(member.getSignId());
		musicEntity.setUpdateDt(LocalDateTime.now());
		MusicEntity saved = this.musicJpaRepository.save(musicEntity);
		MusicDto musicDto = (MusicDto)new MusicDto().copyMembers(saved, false);
		return musicDto;
	}

	public MusicDto delete(IMember member, Long id) {
		MusicEntity musicEntity = musicJpaRepository.findById(id).orElseThrow();

		musicEntity.setDeleteDt(LocalDateTime.now());
		musicEntity.setDeleteId(member.getSignId());
		MusicEntity saved = this.musicJpaRepository.save(musicEntity);
		MusicDto musicDto = (MusicDto)new MusicDto().copyMembers(saved, false);
		return musicDto;
	}

	public MusicDto findById(Long id) throws Mjc813Exception {
		MusicEntity musicEntity = this.musicJpaRepository.findById(id).orElseThrow();
		MusicDto find = (MusicDto)new MusicDto().copyMembers(musicEntity, true);
		if (find == null || find.getDeleteId() != null) {
			throw new Mjc813Exception(ResponseCode.DATA_NOT_FOUND_ERROR, "data is not exists");
		}
		return find;
	}

	public List<MusicDto> findAll() {
		List<MusicEntity> musicEntities = this.musicJpaRepository.findAll();
		List<MusicDto> result = this.transfer(musicEntities);
		return result;
	}

	public String getCreateId(Long id) {
		MusicEntity musicEntity = this.musicJpaRepository.findById(id).orElseThrow();
		MusicDto find = (MusicDto)new MusicDto().copyMembers(musicEntity, true);
		return find.getCreateId();
	}

	private List<MusicDto> transfer(List<MusicEntity> entityList) {
        return entityList.stream().map(item -> (MusicDto)new MusicDto().copyMembers(item, true))
                .filter(item -> item.getDeleteId() == null)
                .toList();
	}
}
