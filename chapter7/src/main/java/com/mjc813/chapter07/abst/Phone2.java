package com.mjc813.chapter07.abst;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Phone2 {
    String owner;

    public Phone2(String owner) {
        this.setOwner(owner);
    }

    public void turnOn() {
        System.out.println("폰 전원을 켭니다.");
    }

    public void turnOff() {
        System.out.println("폰 전원을 끕니다.");
    }
}
