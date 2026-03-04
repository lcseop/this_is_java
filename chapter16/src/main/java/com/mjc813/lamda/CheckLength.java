package com.mjc813.lamda;

public class CheckLength implements Check {
    @Override
    public void procString(String str, int num) {
        System.out.println(str + "의 길이가 " + num + "와 일치 여부: " + (str.length()==num));
    }
}
