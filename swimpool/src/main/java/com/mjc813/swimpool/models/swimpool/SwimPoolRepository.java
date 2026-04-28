package com.mjc813.swimpool.models.swimpool;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SwimPoolRepository extends JpaRepository<SwimPoolEntity, Integer> {
    Slice<SwimPoolEntity> findByNameContains(String name, Pageable pageable);
}
