package com.mjc813.cafe_kiosk.models.category;


import jdk.jfr.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.SliceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository repository;

    public CategoryDto insert(CategoryDto dto) {
        CategoryEntity newData = new CategoryEntity();
        newData.setName(dto.getName());
        newData.setId(dto.getId());

        CategoryEntity rs = this.repository.save(newData);

        CategoryDto result = new CategoryDto();
        result.setId(rs.getId());
        result.setName(dto.getName());
        return result;
    }

    public CategoryDto update(CategoryDto dto) {
        CategoryEntity categoryEntity = this.repository.findById(dto.getId()).orElseThrow();
        categoryEntity.setName(dto.getName());

        this.repository.save(categoryEntity);

        CategoryDto result = CategoryDto.builder().id(categoryEntity.getId()).name(categoryEntity.getName()).build();
        return result;
    }

    public CategoryDto delete(Integer id) {
        CategoryEntity categoryEntity = this.repository.findById(id).orElseThrow();
        this.repository.deleteById(id);

        CategoryDto result = CategoryDto.builder().id(categoryEntity.getId()).name(categoryEntity.getName()).build();
        return result;
    }

    public CategoryDto findById(Integer id) {
        CategoryEntity categoryEntity = this.repository.findById(id).orElseThrow();
        CategoryDto result = CategoryDto.builder().id(categoryEntity.getId()).name(categoryEntity.getName()).build();
        return result;
    }

    public Slice<CategoryDto> findByNameContains(CategoryResultDto crd, Pageable pageable) {
        Slice<CategoryEntity> slice = this.repository.findByNameContains(crd.getSearchName(), pageable);
        List<CategoryEntity> list = slice.getContent();
        List<CategoryDto> resultList = list.stream().
                map(categoryEntity -> CategoryDto.builder().id(categoryEntity.getId()).name(categoryEntity.getName()).build())
                .toList();
        Slice<CategoryDto> result = new SliceImpl<>(resultList, pageable, slice.hasNext());
        return result;
    }

}
