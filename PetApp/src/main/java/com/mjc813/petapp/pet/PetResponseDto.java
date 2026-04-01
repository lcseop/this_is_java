package com.mjc813.petapp.pet;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PetResponseDto {
    private Integer code;
    private String message;
    private Object data;
}
