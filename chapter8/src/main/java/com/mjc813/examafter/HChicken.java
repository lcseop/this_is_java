package com.mjc813.examafter;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class HChicken extends Birds {
    final private String type = "닭";

    public HChicken(String name, String id, HDoctor doctor, LocalDate inDate, LocalDate outDate, HHuman master) {
        this.setName(name);
        this.setId(id);
        this.setDoctor(doctor);
        this.setInDate(inDate);
        this.setOutDate(outDate);
        this.setMaster(master);
    }

    public void eat() {
        System.out.println("닭 " + this.getName() + "이(가) 모이를 먹습니다.");
    }
}
