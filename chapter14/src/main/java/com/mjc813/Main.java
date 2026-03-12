package com.mjc813;

public class Main {
    public static void main(String[] args) {
//        Thread1 th1 = new Thread1(29);
//        th1.start();
//        Thread th2 = new Thread(new Thread2());
//        th2.start();
//
//        Thread3 th3 = new Thread3();
//        for (int i = 0; i < 99; i++ ) {
//            System.out.printf("%s, i = %d\n", Thread.currentThread().getName(), i);
//            if (i % 10 == 0) th3.testThread3();
//        }
//        // 스레드 실행
//        th3.close();

        Example example = new Example();

        example.waitNotifyExample();
    }
}