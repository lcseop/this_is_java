package com.mjc813.chapter07.seals;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public sealed class Person2 permits Employee, Manager {
    private String name;

    public void work() {
        System.out.println("하는 일이 결정되지 않았습니다.");
    }
}
