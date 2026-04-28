package com.mjc813.swimpool.models.teacher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
