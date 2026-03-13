package com.mjc813;

import java.awt.*;
import java.util.Scanner;

public class Example {
    public void report01() {
        try {
            for (int i = 2; i <= 9; i++) {
                for (int j = 1; j <= 9; j++) {
                    System.out.printf("%d * %d = %d\n", i, j, i*j);
                    Thread.sleep(100);
                }
            }
        } catch (InterruptedException e) {}
    }

    public void report02() {
        Report2Class rc = new Report2Class();
        rc.start();
        try {
            for (int i = 2; i <= 4; i++) {
                for (int j = 1; j <= 9; j++) {
                    System.out.printf("%d * %d = %d\n", i, j, i*j);
                    Thread.sleep(50);
                }
            }
        } catch (InterruptedException e) {}
    }

    public void report03() {
        Thread rc1 = new Thread(new Report3Class1());
        Report3Class2 rc2 = new Report3Class2();
        rc1.start();
        rc2.start();
        try {
            for (int i = 2; i <= 3; i++) {
                for (int j = 1; j <= 9; j++) {
                    System.out.printf("%d * %d = %d\n", i, j, i*j);
                    Thread.sleep(50);
                }
            }
        } catch (InterruptedException e) {}
    }

    public void report04() {
        Scanner s = new Scanner(System.in);
        System.out.print("무한반복할 글자를 입력하세요 -> ");
        Report4Class rc = new Report4Class(s.nextLine());
        rc.start();
        while (true) {
            rc.setWord(s.nextLine());
        }
    }

    public void beepPrintExample() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        for (int i = 0; i < 5; i++) {
            toolkit.beep();
            try {
                Thread.sleep(500);
            } catch (Exception e) {}
        }

        for (int i = 0; i < 5; i++) {
            System.out.println("띵");
            try {
                Thread.sleep(500);
            } catch (Exception e) {}
        }
    }

    public void beepPrintExample2() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Toolkit toolkit = Toolkit.getDefaultToolkit();
                for (int i = 0; i < 5; i++) {
                    toolkit.beep();
                    try {
                        Thread.sleep(500);
                    } catch (Exception e) {}
                }
            }
        });

        thread.start();

        for (int i = 0; i < 5; i++) {
            System.out.println("띵");
            try {
                Thread.sleep(500);
            } catch (Exception e) {}
        }
    }

    public void threadNameExample() {
        Thread mainThread = Thread.currentThread();
        System.out.println(mainThread.getName() + " 실행");

        for (int i = 0; i < 3; i++) {
            Thread threadA = new Thread() {
                @Override
                public void run() {
                    System.out.println(getName() + " 실행");
                }
            };
            threadA.start();
        }

        Thread chatThread = new Thread() {
            @Override
            public void run() {
                System.out.println(getName() + " 실행");
            }
        };
        chatThread.setName("chat-thread");
        chatThread.start();
    }

    public void sleepExample() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        for (int i = 0; i < 10; i++) {
            toolkit.beep();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {}
        }
    }

    public void joinExample() {
        SumThread sumThread = new SumThread();
        sumThread.start();
        try {
            // join() 메소드로 메인 스레드가 일시 정지 상태에 있다가 SumThread가 종료되면 계산값 산출
            sumThread.join();
        } catch (InterruptedException e) {}

        System.out.println("1~100의 합: " + sumThread.getSum());
    }

    public void yieldExample() {
        WorkThread workThreadA = new WorkThread("workThreadA");
        WorkThread workThreadB = new WorkThread("workThreadB");
        workThreadA.start();
        workThreadB.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {}
        workThreadA.work = false;

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {}
        workThreadA.work = true;
    }

    public void synchronizedExample() {
        Calculator calculator = new Calculator();

        User1Thread user1Thread = new User1Thread();
        user1Thread.setCalculator(calculator);
        user1Thread.start();

        User2Thread user2Thread = new User2Thread();
        user2Thread.setCalculator(calculator);
        user2Thread.start();
    }

    public void waitNotifyExample() {
        WorkObject workObject = new WorkObject();

        ThreadA threadA = new ThreadA(workObject);
        ThreadB threadB = new ThreadB(workObject);

        threadA.start();
        threadB.start();
    }

}
