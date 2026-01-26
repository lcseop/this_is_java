package com.mjc813;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Car {
    private int speed;
    private boolean stop;

    public void setSpeed(int speed) {
        if (speed < 0) {
            this.speed = 0;
        } else {
            this.speed = speed;
        }
    }

    public void setStop(boolean stop) {
        this.stop = stop;
        if (stop) this.speed = 0;
    }
}
