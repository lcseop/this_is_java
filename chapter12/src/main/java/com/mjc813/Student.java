package com.mjc813;

import lombok.*;

@Getter
@Setter
public class Student {
    private String studentNum;

    public Student(String studentNum) {
        this.setStudentNum(studentNum);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Student stu) {
            return this.getStudentNum().equals(stu.getStudentNum());
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int hash;
        try {
            hash = Integer.parseInt(getStudentNum());
        } catch (Exception e) {
            hash = 0;
        }
        return hash;
    }
}
