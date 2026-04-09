package com.mjc813.cafe_kiosk.models.product;

import com.mjc813.cafe_kiosk.models.category.CategoryDto;
import com.mjc813.cafe_kiosk.models.category.ICategory;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ProductDto implements IProduct {
    private Integer id;
    private String name;
    private Integer price;
    private CategoryDto category = new CategoryDto();
    private String picture;

    @Override
    public void setCategory(ICategory category) {
        this.category.copyMembers(category, true);
    }
}
