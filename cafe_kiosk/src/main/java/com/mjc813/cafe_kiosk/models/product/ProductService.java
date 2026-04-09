package com.mjc813.cafe_kiosk.models.product;

import com.mjc813.cafe_kiosk.models.category.CategoryDto;
import com.mjc813.cafe_kiosk.models.category.CategoryEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {
    final private ProductRepository repository;

    public ProductDto insert(ProductDto newDto) {
        ProductEntity newEntity = ProductEntity.builder()
                .name(newDto.getName())
                .price(newDto.getPrice())
                .category(new CategoryEntity())
                .picture(newDto.getPicture())
                .build();
        newEntity.getCategory().setId(newDto.getCategory().getId());
//        newEntity.getCategory().setName(newDto.getCategory().getName());

        ProductEntity save = this.repository.save(newEntity);

        ProductDto result = ProductDto.builder()
                .id(save.getId())
                .name(save.getName())
                .price(save.getPrice())
                .category(new CategoryDto())
                .picture(save.getPicture())
                .build();

        result.getCategory().setId(save.getCategory().getId());
        result.getCategory().setName(save.getCategory().getName());
        return result;
    }

    public ProductDto update(ProductDto newDto) {
        ProductEntity find = this.repository.findById(newDto.getId()).orElseThrow();
        find.setName(newDto.getName());
        find.setPrice(newDto.getPrice());
        find.setPicture(newDto.getPicture());
        find.getCategory().setId(newDto.getCategory().getId());

        this.repository.save(find);

        ProductDto result = ProductDto.builder()
                .id(find.getId())
                .name(find.getName())
                .price(find.getPrice())
                .picture(find.getPicture())
                .category(new CategoryDto())
                .build();
        result.getCategory().setId(find.getCategory().getId());
        result.getCategory().setName(find.getCategory().getName());

        return result;


    }
}
