package com.mjc813.examafter;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class HSmallDog extends HPatient {
    final private String type = "소형견";


    public HSmallDog(String name, String id, HDoctor doctor, LocalDate inDate, LocalDate outDate, HHuman master) {
        super(name, id, doctor, inDate, outDate, master);
    }
}
