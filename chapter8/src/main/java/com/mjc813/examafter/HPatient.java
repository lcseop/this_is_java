package com.mjc813.examafter;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
public class HPatient {
    private String name;
    private String id = "0";
    private HDoctor doctor;
    private LocalDate inDate;
    private LocalDate outDate;
    private HHuman master;
    private int feed;
    private int visit;
    private String type;

    public HPatient (String name, String id, HDoctor doctor, LocalDate inDate, LocalDate outDate, HHuman master) {
        this.setName(name);
        this.setId(id);
        this.setDoctor(doctor);
        this.setInDate(inDate);
        this.setOutDate(outDate);
        this.setMaster(master);
    }


}
