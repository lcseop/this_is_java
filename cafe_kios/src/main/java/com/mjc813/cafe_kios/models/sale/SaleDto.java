package com.mjc813.cafe_kios.models.sale;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class SaleDto implements ISale {
    private Integer id;
    private Integer productId;
    private Integer qty;
    private Integer price;
    private LocalDate saleTime;
}
