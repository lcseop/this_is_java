package com.mjc813.cafe_kiosk.models.category;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder // 객체를 new 하는 것처럼 새로 만드는 한 방법
public class CategoryDto implements ICategory {
    private Integer id;
    private String name;
}
