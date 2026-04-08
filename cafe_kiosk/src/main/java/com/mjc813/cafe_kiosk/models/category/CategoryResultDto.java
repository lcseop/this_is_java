package com.mjc813.cafe_kiosk.models.category;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryResultDto {
    private Integer rowCount;
    private String searchName;
}
