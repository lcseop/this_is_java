package com.mjc813;

public class Castings {
    void promotionExample() {
        byte byteValue = 10;
        int intValue = byteValue;
        System.out.println("intValue: " + intValue);

        char charValue = '가';
        intValue = charValue;
        System.out.println("가의 유니코드: " + intValue);

        intValue = 50;
        long longValue = intValue;
        System.out.println("longValue: " + longValue);

        longValue = 100;
        float floatValue = longValue;
        System.out.println("floatValue: " + floatValue);

        floatValue = 100.5F;
        double doubleValue = floatValue;
        System.out.println("doubleValue: " + doubleValue);
    }

    void castingExample() {
        int var1 = 10;
        byte var2 = (byte) var1;
        System.out.println(var2);

        long var3 = 300;
        int var4 = (int) var3;
        System.out.println(var4);

        int var5 = 65;
        char var6 = (char) var5;
        System.out.println(var6);

        double var7 = 3.14;
        int var8 = (int) var7;
        System.out.println(var8);
    }

    void operationPromotionExample() {
        byte result1 = 10 + 20;
        System.out.println(result1);

        byte v1 = 10;
        byte v2 = 20;
        int result2 = v1 + v2;
        System.out.println(result2);

        byte v3 = 10;
        int v4 = 100;
        long v5 = 100L;
        long result3 = v3 + v4 + v5;
        System.out.println(result3);

        char v6 = 'A';
        char v7 = 1;
        int result4 = v6 + v7;
        System.out.println(result4);

        int v8 = 10;
        int result5 = v8 / 4;
        System.out.println(result5);

        int v9 = 10;
        double result6 = v9 / 4.0;
        System.out.println(result6);

        int v10 = 1;
        int v11 = 2;
        double result7 = (double) v10 / v11;
        System.out.println(result7);

    }
}
