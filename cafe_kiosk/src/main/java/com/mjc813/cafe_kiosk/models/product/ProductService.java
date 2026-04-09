package com.mjc813.cafe_kiosk.models.product;

import com.mjc813.cafe_kiosk.models.category.CategoryDto;
import com.mjc813.cafe_kiosk.models.category.CategoryEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.SliceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    final private ProductRepository repository;

    public ProductDto insert(ProductDto newDto) {
        ProductEntity newEntity = (ProductEntity) new ProductEntity().copyMembers(newDto, false);
        newEntity.setId(null);

        ProductEntity save = this.repository.save(newEntity);

        ProductDto result = (ProductDto) new ProductDto().copyMembers(save, false);
        return result;
    }

    public ProductDto update(ProductDto newDto) {
        ProductEntity find = this.repository.findById(newDto.getId()).orElseThrow();

        ProductEntity data = (ProductEntity) new ProductEntity().copyMembers(find, true);
        data.copyMembers(newDto, false);

        ProductEntity save = this.repository.save(data);

        ProductDto result = (ProductDto) new ProductDto().copyMembers(save, true);

        return result;
    }

    public ProductDto delete(Integer id) {
        ProductEntity find = this.repository.findById(id).orElseThrow();

        this.repository.delete(find);

        ProductDto result = (ProductDto) new ProductDto().copyMembers(find, true);
        return result;
    }

    public ProductDto findById(Integer id) {
        ProductEntity find = this.repository.findById(id).orElseThrow();
        ProductDto result = (ProductDto) new ProductDto().copyMembers(find, true);
        return result;
    }

    public Slice<ProductDto> findByNameContains(String name, Pageable pageable) {
        Slice<ProductEntity> slice = this.repository.findByNameContains(name, pageable);
        List<ProductEntity> list =  slice.getContent();
        List<ProductDto> resultList = list.stream().map(productEntity -> (ProductDto) ProductDto.builder().category(new CategoryDto()).build().copyMembers(productEntity, false)).toList();
        Slice<ProductDto> result = new SliceImpl<>(resultList, pageable, slice.hasNext());
        return result;
    }
}
