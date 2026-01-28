package com.mjc813.chapter07.poly;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TireCar {
    private Tire tire;

    public void run() {
        tire.roll();
    }
}
