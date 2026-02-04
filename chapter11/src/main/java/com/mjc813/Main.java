package com.mjc813;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Casher casher = new Casher();
        try {
            casher.calculMoney();
        } catch (ArrayIndexOutOfBoundsException ar) {
            System.err.println("ArrayIndexOutOfBoundsException : " + ar.getMessage());
        } catch (Exception e) {
            System.err.println("Exception : " + e.getMessage());
        }

        System.out.println("--------------------- p.469 예외처리 코드");
        System.out.println("[프로그램 시작]\n");
        printLength("ThisIsJava");
        printLength(null);
        System.out.println("[프로그램 종료]\n");


        System.out.println("--------------------- p.470 예외처리 코드");
        try {
            Class.forName("java.lang.String");
            System.out.println("java.lang.String 클래스가 존재합니다.");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println();

        try {
            Class.forName("java.lang.String2");
            System.out.println("java.lang.String2 클래스가 존재합니다.");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("--------------------- p.472, 474 예외 종류에 따른 처리");
        String array[] = { "100", "1oo", null, "200" };

        for (int i = 0; i <= array.length; i++) {
            try {
                int value = Integer.parseInt(array[i]);
                System.out.println("array[" + i + "]: " + value);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("배열 인덱스가 초과됨: " + e.getMessage());
//            } catch (NumberFormatException e) {
//                System.out.println("숫자로 변환할 수 없음: " + e.getMessage());
//            }
//            } catch (Exception e) {
//                System.out.println("실행에 문제가 있습니다.");
//            }
            } catch (NullPointerException | NumberFormatException e) {
                System.out.println("데이터에 문제가 있음: " + e.getMessage());
            }
        }

        System.out.println("--------------------- p.478 리소스 자동 닫기");
        try (MyResource res = new MyResource("A")) {
            String data = res.read1();
            int value = Integer.parseInt(data);
        } catch (Exception e) {
            System.out.println("예외 처리: " + e.getMessage());
        }

        System.out.println();

        try (MyResource res = new MyResource("A")) {
            String data = res.read2();
            int value = Integer.parseInt(data);
        } catch (Exception e) {
            System.out.println("예외 처리: " + e.getMessage());
        }

        System.out.println();

        MyResource res1 = new MyResource("A");
        MyResource res2 = new MyResource("B");
        try (res1; res2) {
            String data1 = res1.read1();
            String data2 = res2.read1();
        } catch (Exception e) {
            System.out.println("예외 처리: " + e.getMessage());
        }

        System.out.println("--------------------- p.480 예외 떠넘기기");
        try {
            findClass();
        } catch (ClassNotFoundException e) {
            System.out.println("예외 처리: " + e.toString());
        }

        // 예금하기
        System.out.println("--------------------- p.484 사용자 정의 예외");
        Account account = new Account();
        account.deposit(10000);
        System.out.println("예금액: " + account.getBalance());

        // 출금하기
        try {
            account.withdraw(30000);
        } catch (InsufficientException e) {
            String message = e.getMessage();
            System.out.println(message);
        }
    }

    public static void printLength(String data) {
        try {
            int result = data.length();
            System.out.println("문자 수: " + result);
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("[마무리 실행]\n");
        }
    }

    public static void findClass() throws ClassNotFoundException {
        Class.forName("java.lang.String2");
    }
}