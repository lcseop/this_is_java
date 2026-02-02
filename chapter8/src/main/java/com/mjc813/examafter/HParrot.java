package com.mjc813.examafter;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class HParrot extends Birds {
    final private String type = "앵무새";

    public HParrot (String name, String id, HDoctor doctor, LocalDate inDate, LocalDate outDate, HHuman master) {
        this.setName(name);
        this.setId(id);
        this.setDoctor(doctor);
        this.setInDate(inDate);
        this.setOutDate(outDate);
        this.setMaster(master);
    }

    public void eat() {
        System.out.println("앵무새 " + this.getName() + "이(가) 해바라기씨를 먹습니다.");
    }
}
