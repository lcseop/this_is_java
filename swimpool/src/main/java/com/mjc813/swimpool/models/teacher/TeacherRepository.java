package com.mjc813.swimpool.models.teacher;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<TeacherEntity, Integer> {
    Slice<TeacherEntity> findByNameContains(String name, Pageable pageable);
}
