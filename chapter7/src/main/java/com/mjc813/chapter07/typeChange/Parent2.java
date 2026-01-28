package com.mjc813.chapter07.typeChange;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Parent2 {
    private String field1;

    public void method1() {
        System.out.println("Parent-method1()");

    }

    public void method2() {
        System.out.println("Parent-method2()");
    }
}
