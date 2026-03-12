package com.mjc813;

public class Thread1 extends Thread {
    private int num;

    public Thread1(int n) {
        this.num = n;
        this.setName("Thread1");
    }

    @Override
    public void run() {
        for (int i = 0; i < this.num; i++) {
            System.out.printf("%s, i = %d\n", Thread.currentThread().getName(), i);
        }
    }
}
