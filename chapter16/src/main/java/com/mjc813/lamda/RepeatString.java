package com.mjc813.lamda;

public class RepeatString implements Check {
    @Override
    public void procString(String str, int num) {
        System.out.println(str.repeat(num));
    }
}
