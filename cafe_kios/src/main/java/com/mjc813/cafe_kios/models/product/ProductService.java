package com.mjc813.cafe_kios.models.product;

import com.mjc813.cafe_kios.models.category.CategoryEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository repository;

    public ProductDto insert(ProductDto newProduct) {
        ProductEntity newEntity = new ProductEntity();
        CategoryEntity category = CategoryEntity.builder().id(newProduct.getCategoryId()).build();
        newEntity.copyMembers(newProduct);
        newEntity.setId(null);
        newEntity.setCategoryObj(category);
        this.repository.save(newEntity);

        ProductDto result = new ProductDto();
        result.copyMembers(newEntity);
        return result;
    }
}
