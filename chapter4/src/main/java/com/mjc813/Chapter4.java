package com.mjc813;

import java.util.*;

public class Chapter4 {
    void checkProblem() {
        // 1번 문제
        double dob = 5.0;
        /* switch(dob) {

        } */

        // 2번 문제
        String grade = "B";
        int score1 = switch(grade) {
            case "A" -> 100;
            case "B" -> {
                int result = 100 - 20;
                yield result;
            }
            default -> 60;
        };
        System.out.println(score1);

        // 3번 문제
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            if (i % 3 != 0) {
                continue;
            }
            sum += i;
        }
        System.out.println("1부터 100까지의 정수 중 3의 배수의 합 : " + sum);


        // 4번 문제
        int dice1 = 0, dice2 = 0;
        while (dice1+dice2 != 5) {
            dice1 = (int) (Math.random() * 6) + 1;
            dice2 = (int) (Math.random() * 6) + 1;
        }
        System.out.println("주사위1 : " + dice1 + ", 주사위2 : " + dice2);

        // 5번 문제
        for (int a = 1; a <= 10; a++) {
            for (int b = 1; b <= 10; b++) {
                if ((4*a+5*b) == 60) {
                    System.out.println("(" + a + ", " + b + ")");
                }
            }
        }

        // 6번 문제
        String lit = "";
        for (int i = 0; i < 5; i++) {
            lit += "*";
            System.out.println(lit);
        }

        // 7번 문제
        Scanner s = new Scanner(System.in);
        int amount = 0;
        Outter: while(true) {
            System.out.println("---------------------------");
            System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
            System.out.println("---------------------------");
            System.out.print("선택> ");

            switch(s.next()) {
                case "1" :
                    System.out.print("예금액>");
                    amount += s.nextInt();
                    break;
                case "2" :
                    System.out.print("출금액>");
                    amount -= s.nextInt();
                    break;
                case "3" :
                    System.out.print("잔고> " + amount);
                    break;
                case "4" :
                    System.out.println("프로그램 종료");
                    break Outter;
                default :
                    System.out.println("올바른 명령어를 입력하세요.");
            }

            System.out.println("");
        }
    }
    void changeProblem() {
        // 3번 문제 - while문 버전
        int result1 = 0, pro3 = 1;
        while (pro3 <= 100) {
            if (pro3 % 3 == 0) {
                result1 += pro3;
            }
            pro3++;
        }
        System.out.println(result1);

        // 3번 문제 - do-while문 버전
        result1 = 0;
        pro3 = 1;
        do {
            if (pro3 % 3 == 0) {
                result1 += pro3;
            }
            pro3++;
        } while (pro3 <= 100);
        System.out.println(result1);

        // 4번 문제 - for문 버전
        int dice1 = 0, dice2 = 0;
        for (;dice1 + dice2 != 5;) {
            dice1 = (int) (Math.random() * 6) + 1;
            dice2 = (int) (Math.random() * 6) + 1;
        }
        System.out.println("주사위1: " + dice1 + ", 주사위2: " + dice2);

        // 4번 문제 - do-while문 버전
        dice1 = 0;
        dice2 = 0;
        do {
            dice1 = (int) (Math.random() * 6) + 1;
            dice2 = (int) (Math.random() * 6) + 1;
        } while (dice1 + dice2 != 5);
        System.out.println("주사위1: " + dice1 + ", 주사위2: " + dice2);

        // 5번 문제 - 중첩 while문 버전
        int x = 1, y = 1;
        while (x <= 10) {
            while (y <= 10) {
                if ((4*x+5*y) == 60) {
                    System.out.println("(" + x + ", " + y + ")");
                }
                y++;
            }
            x++;
            y = 1;
        }

        // 5번 문제 - 중첩 do-while문 버전
        x = 1; y = 1;
        do {
            do {
                if (4*x+5*y == 60) {
                    System.out.println("(" + x + ", " + y + ")");
                }
                y++;
            } while(y <= 10);
            x++;
            y = 1;
        } while(x <= 10);

        // 6번 문제 - while문 버전
        int num = 0;
        String star = "";
        while (num <= 4) {
            star += "*";
            System.out.println(star);
            num++;
        }

        // 6번 문제 - do-while문 버전
        num = 0;
        star = "";
        do {
            star += "*";
            System.out.println(star);
            num++;
        } while (num <= 4);
    }
}
