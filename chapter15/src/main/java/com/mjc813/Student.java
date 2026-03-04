package com.mjc813;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Student {
    private int studentNum;
    private String name;

    @Override
    public int hashCode() {
        return this.getStudentNum();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Student) {
            return (this.getStudentNum() == ((Student) obj).getStudentNum());
        }
        return false;
    }
}
