package com.mjc813;

import java.awt.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

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

    public void report05() {
        Scanner s = new Scanner(System.in);
        System.out.print("정수 리스트를 입력하세요. -> ");
        String[] array = s.nextLine().split(",");
        System.out.println(Arrays.toString(array));
        Integer[] arrayInt = new Integer[array.length];
        for (int i = 0; i< array.length; i++) {
            try {
                arrayInt[i] = Integer.parseInt(array[i].replace(" ", ""));
            } catch (Exception e) {}
        }
        Report5 rcSum = new Report5("sum", arrayInt);
        Report5 rcAvg = new Report5("avg", arrayInt);
        Report5 rcSort = new Report5("sort", arrayInt);
        Report5 rcOdd = new Report5("odd", arrayInt);
        Report5 rcEven = new Report5("even", arrayInt);

        rcSum.start();
        rcAvg.start();
        rcSort.start();
        rcOdd.start();
        rcEven.start();
    }

    public void report06() {
        Scanner s = new Scanner(System.in);
        System.out.print("출력할 구구단을 입력하세요 -> ");
        Report6 rc = new Report6(s.nextInt());
        rc.start();
        while(true) {
            rc = new Report6(s.nextInt());
            rc.start();
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

    public void safeStopExample() {
        PrintThread printThread = new PrintThread();
        printThread.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {}

        printThread.setStop(true);
    }

    public void interruptExample() {
        Thread thread = new PrintThread2();
        thread.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {}

        thread.interrupt();
    }

    public void daemonExample() {
        AutoSaveThread autoSaveThread = new AutoSaveThread();
        autoSaveThread.setDaemon(true);
        autoSaveThread.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {}

        System.out.println("메인 스레드 종료");
    }

    public void executorServiceExample() {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        executorService.shutdownNow();
    }

    public void runnableExecuteExample() {
        String[][] mails = new String[1000][3];
        for (int i = 0; i < mails.length; i++) {
            mails[i][0] = "admin@my.com";
            mails[i][1] = "member" + i + "@my.com";
            mails[i][2] = "신상품 입고";
        }

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 1000; i++) {
            final int idx = i;
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    Thread thread = Thread.currentThread();
                    String from = mails[idx][0];
                    String to = mails[idx][1];
                    String content = mails[idx][2];
                    System.out.printf("[%s] %s ==> %s: %s\n", thread.getName(), from, to, content);
                }
            });
        }

        executorService.close();
    }

    public void callableSubmitExample() {
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        for (int i = 1; i <= 100; i++) {
            final int idx = i;
            Future<Integer> future = executorService.submit(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    int sum = 0;
                    for (int i = 1; i <= idx; i++) {
                        sum += i;
                    }
                    Thread thread = Thread.currentThread();
                    System.out.printf("[%s] 1~%d 합 계산", thread.getName(), idx);
                    return sum;
                }
            });

            try {
                int result = future.get();
                System.out.println("\t리턴값: " + result);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        executorService.shutdown();
    }

}
