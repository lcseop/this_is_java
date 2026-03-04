package com.mjc813.lamda3;

public class Person3 {
    public void action(Calcuable2 calcuable) {
        double result = calcuable.calc(10, 4);
        System.out.println("결과: " + result);
    }
}
