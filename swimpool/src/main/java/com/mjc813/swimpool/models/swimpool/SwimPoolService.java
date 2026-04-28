package com.mjc813.swimpool.models.swimpool;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.SliceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SwimPoolService {
    @Autowired
    SwimPoolRepository swimPoolRepository;

    public SwimPoolDto insert(SwimPoolDto insertDto) {
        SwimPoolEntity swimPoolEntity = (SwimPoolEntity) new SwimPoolEntity().copyMembers(insertDto, true);
        swimPoolEntity.setId(null);
        SwimPoolEntity save = swimPoolRepository.save(swimPoolEntity);
        SwimPoolDto result = (SwimPoolDto) new SwimPoolDto().copyMembers(save, true);
        return result;
    }

    public SwimPoolDto update(SwimPoolDto updateDto) {
        SwimPoolEntity find = swimPoolRepository.findById(updateDto.getId()).orElseThrow();
        SwimPoolEntity swimPoolEntity = (SwimPoolEntity) new SwimPoolEntity().copyMembers(find, false);
        swimPoolEntity.copyMembers(updateDto, false);
        SwimPoolEntity save = swimPoolRepository.save(swimPoolEntity);
        SwimPoolDto result = (SwimPoolDto) new SwimPoolDto().copyMembers(save, true);
        return result;
    }

    public SwimPoolDto findById(Integer id) {
        SwimPoolEntity find = swimPoolRepository.findById(id).orElseThrow();
        SwimPoolDto result = (SwimPoolDto) new SwimPoolDto().copyMembers(find, true);
        return result;
    }

    public Slice<SwimPoolDto> findByNameContains(String name, Pageable pageable) {
        Slice<SwimPoolEntity> slc = swimPoolRepository.findByNameContains(name, pageable);
        List<SwimPoolDto> list = slc.getContent().stream()
                .map(t -> (SwimPoolDto)new SwimPoolDto().copyMembers(t, true))
                .toList();
        Slice<SwimPoolDto> result = new SliceImpl<>(list, slc.getPageable(), slc.hasNext());
        return result;
    }

    public SwimPoolDto delete(Integer id) {
        SwimPoolDto find = this.findById(id);
        swimPoolRepository.deleteById(id);
        return find;
    }

}
