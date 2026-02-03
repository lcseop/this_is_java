package com.mjc813;

import com.mjc813.machine.Calculator;

public class Main {
    public static void main(String[] args) {
        Calculator cal = new Calculator();
        System.out.println(cal.add(1, 2, 3, 4, 5));
    }
}