package com.mjc813.cafe_kios.models.product;

import com.mjc813.cafe_kios.models.category.CategoryDto;
import com.mjc813.cafe_kios.models.category.CategoryEntity;
import com.mjc813.cafe_kios.models.category.ICategory;
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
    private CategoryDto categoryObj;
    private String picture;

    public Integer getCategoryId() {
        if (this.categoryId != null) {
            return this.categoryObj.getId();
        }
        return this.categoryId;
    }

    @Override
    public void setCategoryObj(ICategory categoryObj) {
        if (categoryObj == null) {
            return;
        }
        if (this.categoryObj == null) {
            this.categoryObj = new CategoryDto();
        }
        this.categoryObj.copyMembers(categoryObj);
    }
}
