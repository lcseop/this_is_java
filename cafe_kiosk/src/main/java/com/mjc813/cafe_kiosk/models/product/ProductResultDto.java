package com.mjc813.cafe_kiosk.models.product;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductResultDto {
    private Integer rowCount;
    private String searchName;
}
