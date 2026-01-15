package com.mjc813;

public class IntegerType {
    void useInteger() {
        int var1 = 0b1011; // 2진수
        int var2 = 0206; // 8진수
        int var3 = 365; // 10진수
        int var4 = 0xB3; // 16진수

        System.out.println("var1: " + var1);
        System.out.println("var2: " + var2);
        System.out.println("var3: " + var3);
        System.out.println("var4: " + var4);

        byte var5 = -128;
        byte var6 = -30;
        byte var7 = 0;
        byte var8 = 30;
        byte var9 = 127;
        // byte var10 = 128; // 크기 벗어남

        System.out.println(var5);
        System.out.println(var6);
        System.out.println(var7);
        System.out.println(var8);
        System.out.println(var9);

        long var11 = 10;
        long var12 = 20L;
        // long var13 = 1000000000000; // int로 간주함, 크기 벗어남
        long var14 = 1000000000000L;

        System.out.println(var11);
        System.out.println(var12);
        System.out.println(var14);
    }
}
