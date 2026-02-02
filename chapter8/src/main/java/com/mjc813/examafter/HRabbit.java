package com.mjc813.examafter;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class HRabbit extends HPatient {
    final private String type = "토끼";

    public HRabbit (String name, String id, HDoctor doctor, LocalDate inDate, LocalDate outDate, HHuman master) {
        this.setName(name);
        this.setId(id);
        this.setDoctor(doctor);
        this.setInDate(inDate);
        this.setOutDate(outDate);
        this.setMaster(master);
    }

    public void eat() {
        System.out.println("토끼 " + this.getName() + "이(가) 당근을 먹습니다.");
    }
}
