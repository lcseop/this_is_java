package com.mjc813.cafe_kios.models.product;

import com.mjc813.cafe_kios.models.category.CategoryEntity;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity(name="product")
public class ProductEntity implements IProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length=50, nullable=false)
    private String name;

    @Column(nullable=false)
    private Integer price;

    @JoinColumn(name="category_id", nullable=false)
    @ManyToOne()
    private CategoryEntity categoryId;

    @Column(length=500, nullable=true)
    private String picture;
}
