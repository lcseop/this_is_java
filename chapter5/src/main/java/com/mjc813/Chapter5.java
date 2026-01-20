package com.mjc813;

public class Chapter5 {
    public void exam() {
        // ------------------- 5-3 예제
        int[] arr1;
        int[] arr2;
        int[] arr3;

        arr1 = new int[] { 1, 2, 3 };
        arr2 = new int[] { 1, 2, 3 };
        arr3 = arr2;

        System.out.println(arr1 == arr2);
        System.out.println(arr2 == arr3);

        // ------------------- 5-4 예제
        int[] intArray = null;
//        intArray[0] = 10;

        String str = null;
//        System.out.println("총 문자 수 : " + str.length());

        // ------------------- 5-5 예제
        String hobby = "여행";
        hobby = null;

        String kind1 = "자동차";
        String kind2 = kind1;
        kind1 = null;
        System.out.println("kind2: " + kind2);

        // ------------------- 5-3 예제
    }

    public void stringExam() {
        String strVar1 = "홍길동";
        String strVar2 = "홍길동";

        // ------------------- equals
        if (strVar1 == strVar2) {
            System.out.println("strVar1과 strVar2는 참조가 같음");
        } else {
            System.out.println("strVar1과 strVar2는 참조가 다름");
        }

        if (strVar1.equals(strVar2)) {
            System.out.println("strVar1과 strVar2는 문자열이 같음");
        }

        String strVar3 = new String("홍길동");
        String strVar4 = new String("홍길동");

        if (strVar3 == strVar4) {
            System.out.println("strVar3과 strVar4는 참조가 같음");
        } else {
            System.out.println("strVar3과 strVar4는 참조가 다름 [" + strVar3.hashCode() + ", " + strVar4.hashCode() + "]");
        }

        if (strVar3.equals(strVar4)) {
            System.out.println("strVar3과 strVar4는 문자열이 같음");
        }

        String hobby = "";
        if (hobby.equals("")) {
            System.out.println("hobby가 참조하는 String 객체는 빈 문자열");
        }

        // ------------------- charAt
        String ssn = "9506241230123";
        char sex = ssn.charAt(6);
        switch (sex) {
            case '1' :
            case '3' :
                System.out.println("남자입니다.");
                break;
            case '2' :
            case '4' :
                System.out.println("여자입니다.");
                break;
        }

        // ------------------- length
        int length = ssn.length();
        if (length == 13) {
            System.out.println("주민등록번호 자릿수가 맞습니다.");
        } else {
            System.out.println("주민등록번호 자릿수가 틀립니다.");
        }

        String oldStr = "자바 문자열은 불변입니다. 자바 문자열은 String입니다.";
        String newStr = oldStr.replace("자바", "JAVA");

        System.out.println("이전 문자열 : " + oldStr + "\n바뀐 문자열 : " + newStr);

        // ------------------- subString
        ssn = "880815-1234567";

        String firstNum = ssn.substring(0, 6);
        System.out.println(firstNum);

        String secondNum = ssn.substring(7);
        System.out.println(secondNum);

        // ------------------- indexOf
        String subject = "자바 프로그래밍";

        int location = subject.indexOf("프로그래밍");
        System.out.println(location);
        String substring = subject.substring(location);
        System.out.println(substring);

        location = subject.indexOf("자바");
        if (location != -1) {
            System.out.println("자바와 관련된 책이로군요.");
        } else {
            System.out.println("자바와 관련되지 않은 책이군요.");
        }

        boolean result = subject.contains("자바");
        if (result) {
            System.out.println("자바와 관련된 책이로군요.");
        } else {
            System.out.println("자바와 관련되지 않은 책이군요.");
        }

        // ------------------- split
        String board = "1,자바 학습,참조 타입 String을 학습합니다.,홍길동";

        String[] tokens = board.split(",");

        System.out.println("번호: " + tokens[0]);
        System.out.println("제목: " + tokens[1]);
        System.out.println("내용: " + tokens[2]);
        System.out.println("성명: " + tokens[3]);
        System.out.println();

        for (int i = 0; i<tokens.length; i++) {
            System.out.println(tokens[i]);
        }
    }

    public void arrayExam() {

    }
}
