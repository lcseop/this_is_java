package com.mjc813;

import lombok.*;

@Getter
@Setter
public class Car {
    private String model;
    private String owner;

    public Car() {
    }

    public Car(String model) {
        this.setModel(model);
    }
}
