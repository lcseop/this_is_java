package com.mjc813.chapter07;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Car {
    private int speed;

    public void speedUp() {
        speed += 1;
    }

    public final void stop() {
        System.out.println("차를 멈춤");
        speed = 0;
    }
}
