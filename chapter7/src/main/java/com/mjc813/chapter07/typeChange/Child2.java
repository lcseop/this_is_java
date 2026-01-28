package com.mjc813.chapter07.typeChange;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Child2 extends Parent2 {
    private String field2;

    public void method3() {
        System.out.println("Child-method3()");
    }
}
