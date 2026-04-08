package com.mjc813.cafe_kiosk.models.category;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Integer> {
    Page<CategoryEntity> findByNameContains(String name, Pageable pageable);
}
