package com.mjc813.cafe_kios.models.product;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository repository;

    public ProductDto insert(ProductDto newProduct) {
        ProductEntity newEntity = new ProductEntity();
        newEntity.copyMembers(newProduct);
        newEntity.setId(null);
        this.repository.save(newEntity);

        ProductDto result = new ProductDto();
        result.copyMembers(newEntity);
        return result;
    }
}
