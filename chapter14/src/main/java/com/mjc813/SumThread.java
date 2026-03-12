package com.mjc813;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SumThread extends Thread {
    private long sum;

    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            sum += i;
        }
    }
}
