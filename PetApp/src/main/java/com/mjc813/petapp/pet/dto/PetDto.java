package com.mjc813.petapp.pet.dto;

import jakarta.persistence.Column;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PetDto {
    private Integer id;
    private String name;
    private String species;
    private String breed;
    private String gender;
    private LocalDate birth;
    private String imgFile;
}
