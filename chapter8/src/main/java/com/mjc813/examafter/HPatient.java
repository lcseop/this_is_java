package com.mjc813.examafter;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class HPatient {
    private String id = "0";
    private HDoctor doctor;
    private LocalDate inDate;
    private LocalDate outDate;
    private String masterName;
    private HAnimalType type;
    private int feed;


}
