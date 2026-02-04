package com.mjc813;

public class Casher {
    public void calculMoney(int ...arrs) throws ArrayIndexOutOfBoundsException {
        Calculator cal = new Calculator();
        double res = 0.0;
        res = cal.devide(arrs);
        System.out.println("res = " + res);

    }
}
