package com.mjc813.petapp.pet.svc;

import com.mjc813.petapp.pet.dto.PetEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends JpaRepository<PetEntity, Integer> {
    // 더보기 제작 시 Slice 클래스 사용
    Page<PetEntity> findByNameContainsAndSpeciesContains(String searchName, String searchSpecies, Pageable pageable);
}
