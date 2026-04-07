package com.mjc813.cafe_kios.models.sale;

import com.mjc813.cafe_kios.models.product.ProductEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity(name="sale")
public class SaleEntity implements ISale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JoinColumn(name="product_id", nullable=false)
    @ManyToOne()
    private ProductEntity productId;

    @Column(nullable=false)
    private Integer qty;

    @Column(nullable=false)
    private Integer price;

    @Column(name="sale_time", nullable=false)
    private LocalDate saleTime;
}
