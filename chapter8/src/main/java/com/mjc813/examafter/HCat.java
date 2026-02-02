package com.mjc813.examafter;

import java.time.LocalDate;

public class HCat extends HPatient {
    public HCat(String name, String id, HDoctor doctor, LocalDate inDate, LocalDate outDate, HHuman master) {
        super(name, id, doctor, inDate, outDate, master);
    }
}
