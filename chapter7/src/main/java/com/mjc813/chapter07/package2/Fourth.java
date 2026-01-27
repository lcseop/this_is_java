package com.mjc813.chapter07.package2;

import com.mjc813.chapter07.package1.First;

public class Fourth extends First {
    public Fourth() {
        super();
    }

    public void method() {
        this.setField("value");
        this.method();
    }

    public void method2() {
//        todo) 직접 객체를 생성해서 사용하는 것은 불가능
//        First first = new First();
//        first.setField("value");
//        first.method();
    }
}
