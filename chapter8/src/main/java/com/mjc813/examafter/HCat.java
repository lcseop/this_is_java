package com.mjc813.examafter;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class HCat extends Mammalias {
    final private String type = "고양이";

    public HCat (String name, String id, HDoctor doctor, LocalDate inDate, LocalDate outDate, HHuman master) {
        this.setName(name);
        this.setId(id);
        this.setDoctor(doctor);
        this.setInDate(inDate);
        this.setOutDate(outDate);
        this.setMaster(master);
    }


    public void eat() {
        System.out.println("고양이 " + this.getName() + "이 츄르를 먹습니다.");
    }
}
