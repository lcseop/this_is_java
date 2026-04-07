package com.mjc813.cafe_kios.models.product;

import com.mjc813.cafe_kios.models.category.CategoryDto;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductDto implements IProduct {
    private Integer id;
    private String name;
    private Integer price;
    private Integer categoryId;
    private String picture;
}
