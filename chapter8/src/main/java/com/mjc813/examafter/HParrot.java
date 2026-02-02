package com.mjc813.examafter;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class HParrot extends HPatient {
    final private String type = "앵무새";

    public HParrot(String name, String id, HDoctor doctor, LocalDate inDate, LocalDate outDate, HHuman master) {
        super(name, id, doctor, inDate, outDate, master);
    }
}
