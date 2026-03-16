package com.mjc813;

public class Report6 extends Thread {
    private int gugudan = 0;

    public Report6(int gugudan) {
        if (gugudan < 1) {
            this.gugudan = 1;
        } else {
            this.gugudan = Math.min(gugudan, 9);
        }
    }

    @Override
    public void run() {
        for (int i = 1; i <= 9; i++) {
            System.out.printf("%d * %d = %d\n", this.gugudan, i, this.gugudan*i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {}
        }
    }
}
