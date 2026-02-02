package com.mjc813.examafter;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class HHedgehog extends Insectivora {
    final private String type = "고슴도치";

    public HHedgehog(String name, String id, HDoctor doctor, LocalDate inDate, LocalDate outDate, HHuman master) {
        this.setName(name);
        this.setId(id);
        this.setDoctor(doctor);
        this.setInDate(inDate);
        this.setOutDate(outDate);
        this.setMaster(master);
    }

    public void eat() {
        System.out.println("고슴도치 " + this.getName() + "이(가) 고슴도치 사료를 먹습니다.");
    }
}
