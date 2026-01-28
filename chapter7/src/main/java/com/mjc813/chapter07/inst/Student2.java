package com.mjc813.chapter07.inst;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Student2 extends Person {
    private int studentNo;

    public Student2(String name, int studentNo) {
        super(name);
        this.setStudentNo(studentNo);
    }

    public void study() {
        System.out.println("공부를 합니다.");
    }
}
