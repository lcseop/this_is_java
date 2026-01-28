package com.mjc813.chapter07.inst;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Person {
    private String name;

    public Person(String name) {
        this.setName(name);
    }

    public void walk() {
        System.out.println("걷습니다.");
    }
}
