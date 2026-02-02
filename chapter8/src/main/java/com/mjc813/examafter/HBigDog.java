package com.mjc813.examafter;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class HBigDog extends HPatient {
    final private String type = "대형견";

    public HBigDog(String name, String id, HDoctor doctor, LocalDate inDate, LocalDate outDate, HHuman master) {
        super(name, id, doctor, inDate, outDate, master);
    }
}
