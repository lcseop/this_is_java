package com.mjc813.swimpool.models.teacher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;

    public TeacherDto insert(TeacherDto teacherDto) {
        TeacherEntity teacherEntity = (TeacherEntity) new TeacherEntity().copyMembers(teacherDto, true);
        teacherEntity.setId(null);
        TeacherEntity save = teacherRepository.save(teacherEntity);
        TeacherDto result = (TeacherDto) new TeacherDto().copyMembers(save, true);
        return result;
    }
    
    public TeacherDto update(TeacherDto teacherDto) {
        TeacherEntity find = teacherRepository.findById(teacherDto.getId()).orElseThrow();
        TeacherEntity target = (TeacherEntity) new TeacherEntity().copyMembers(find, false);
        target.copyMembers(teacherDto, false);
        TeacherEntity save = teacherRepository.save(target);
        TeacherDto result = (TeacherDto) new TeacherDto().copyMembers(save, true);
        return result;
    }

    public TeacherDto findById(Integer id) {
        TeacherEntity find = teacherRepository.findById(id).orElseThrow();
        TeacherEntity teacherEntity = (TeacherEntity) new TeacherEntity().copyMembers(find, true);
        TeacherDto result = (TeacherDto) new TeacherDto().copyMembers(teacherEntity, false);
        return result;
    }

    public TeacherDto deleteById(Integer id) {
        TeacherEntity find = teacherRepository.findById(id).orElseThrow();
        teacherRepository.deleteById(id);
        TeacherDto result = (TeacherDto) new TeacherDto().copyMembers(find, true);
        return result;
    }

    public List<TeacherDto> findByName(String name, Pageable pageable) {
        Slice<TeacherEntity> find = teacherRepository.findByNameContains(name, pageable);
        List<TeacherDto> result = find.stream().map(s -> {
            TeacherDto findDto = (TeacherDto) new TeacherDto().copyMembers(s, true);
            return findDto;
        }).toList();
        return result;
    }
}
