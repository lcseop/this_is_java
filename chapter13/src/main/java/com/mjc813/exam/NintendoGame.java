package com.mjc813.exam;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class NintendoGame {
    private String name;
    private Grade grade;
    private Integer price;
}