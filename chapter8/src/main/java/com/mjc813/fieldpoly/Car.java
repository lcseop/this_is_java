package com.mjc813.fieldpoly;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Car {
    private Tire tire1 = new HankookTire();
    private Tire tire2 = new HankookTire();

    public void run() {
        tire1.roll();
        tire2.roll();
    }
}
