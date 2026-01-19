package com.mjc813;

public class Chapter3 {
    public int equationFirst(int a, int b) {
        return -b / a;
    }

    public void compareOperator() {
        int num1 = 10;
        int num2 = 10;
        boolean result1 = (num1 == num2);
        boolean result2 = (num1 != num2);
        boolean result3 = (num1 <= num2);
        System.out.println("result1: " + result1);
        System.out.println("result2: " + result2);
        System.out.println("result3: " + result3);

        char char1 = 'A';
        char char2 = 'B';
        boolean result4 = (char1 < char2);
        System.out.println("result4: " + result4);

        int num3 = 1;
        double num4 = 1.0;
        boolean result5 = (num3 == num4);
        System.out.println("result5: " + result5);

        float num5 = 0.1f;
        double num6 = 0.1;
        boolean result6 = (num5 == num6);
        boolean result7 = (num5 == (float)num6);
        System.out.println("result6: " + result6);
        System.out.println("result7: " + result7);

        String str1 = "자바";
        String str2 = "Java";
        boolean result8 = (str1.equals(str2));
        boolean result9 = ! (str1.equals(str2));
        System.out.println("result8: " + result8);
        System.out.println("result9: " + result9);
    }

    public void logicalOperator() {
        int charCode = 'A';
//         int charCode = 'a';
//         int charCode = '5';

        if ( (65<=charCode) & (charCode<=90)) {
            System.out.println("대문자이군요.");
        }
        if ( (97<=charCode) && (charCode<=122)) {
            System.out.println("소문자이군요.");
        }
        if ( (48<=charCode) && (charCode<=57)) {
            System.out.println("0~9 숫자군요.");
        }

        int value = 6;
        // int value = 7;

        if ( (value%2==0) | (value%3==0) ) {
            System.out.println("2 또는 3의 배수이군요.");
        }

        boolean result = (value%2==0) || (value%3==0);
        if (!result) {
            System.out.println("2 또는 3의 배수가 아니군요.");
        }

    }

    public void bitLogic() {
        System.out.println("45 & 25 = " + (45 & 25));
        System.out.println("45 | 25 = " + (45 | 25));
        System.out.println("45 ^ 25 = " + (45 ^ 25));
        System.out.println("~45 = " + (~45));
        System.out.println("-----------------------------");

        byte receiveData = -120;

        // 방법1 : 비트 논리곱 연산으로 Unsigned 정수 얻기
        int unsignedInt1 = receiveData & 255;
        System.out.println(unsignedInt1);

        // 방법2 : 자바 API를 이용해서 Unsigned 정수 얻기
        int unsignedInt2 = Byte.toUnsignedInt(receiveData);
        System.out.println(unsignedInt2);

        int test = 136;
        byte btest = (byte) test;
        System.out.println(btest);
    }

    public void bitShift() {
        System.out.println("------------비트 쉬프트-------------");
        int num1 = 1;
        int result1 = num1 << 3;
        int result2 = num1 * (int) Math.pow(2, 3);
        System.out.println("result1: " + result1);
        System.out.println("result2: " + result2);

        int num2 = -8;
        int result3 = num2 >> 3;
        int result4 = num2 / (int) Math.pow(2, 3);
        System.out.println("result3: " + result3);
        System.out.println("result4: " + result4);

        int value = 772; // [00000000] [00000000] [00000011] [00000100]

        // 우측으로 3byte(24bit) 이동하고 끝 1바이트만 읽음 : [00000000]
        byte byte1 = (byte) (value >>> 24);
        int int1 = byte1 & 255;
        System.out.println("첫 번째 바이트 부호 없는 값: " + int1);

        byte byte2 = (byte) (value >>> 16);
        int int2 = Byte.toUnsignedInt(byte2);
        System.out.println("두 번째 바이트 부호 없는 값: " + int2);

        byte byte3 = (byte) (value >>> 8);
        int int3 = byte3 & 255;
        System.out.println("세 번째 바이트 부호 없는 값: " + int3);

        byte byte4 = (byte) value;
        int int4 = Byte.toUnsignedInt(byte4);
        System.out.println("네 번째 바이트 부호 없는 값: " + int4);
    }

    void asignmentOperator() {
        int result = 0;
        result += 10;
        System.out.println("result=" + result);
        result -= 5;
        System.out.println("result=" + result);
        result *= 3;
        System.out.println("result=" + result);
        result /= 5;
        System.out.println("result=" + result);
        result %= 3;
        System.out.println("result=" + result);
    }

    void conditionalOperation() {
        int score = 85;
        char grade = (score > 90) ? 'A' : ( (score > 80) ? 'B' : 'C' );
        System.out.println(score + "점은 " + grade + "등급입니다.");
    }

    void checkWork() {
        System.out.println("--------확인문제1");
        int x = 10;
        int y = 20;
        int z = (++x) + (y--);
        System.out.println(z);

        System.out.println("--------확인문제2");
        int score = 85;
        String result = (!(score>90))? "가": "나";
        System.out.println(result);

        System.out.println("--------확인문제3");
        int pencils = 534;
        int students = 30;

        int pencilsPerStudent = (pencils/students);
        System.out.println(pencilsPerStudent);

        int pencilsLeft = (pencils%students);
        System.out.println(pencilsLeft);

        System.out.println("--------확인문제4");
        int value = 356;
        System.out.println(value/100);

        System.out.println("--------확인문제5");
        int lengthTop = 5;
        int lengthBottom = 10;
        int height = 7;
        double area = (lengthTop+lengthBottom) * height / 2.0;
        System.out.println(area);
        area = (lengthTop+lengthBottom) * height * 1.0 / 2;
        System.out.println(area);
        area = (double) (lengthTop+lengthBottom) * height / 2;
        System.out.println(area);
        area = (double) ((lengthTop+lengthBottom) * height / 2);
        System.out.println(area);

        System.out.println("--------확인문제6");
        x = 10;
        y = 5;

        System.out.println((x>7) && (y<=5));
        System.out.println((x%3 == 2) || (y%2 != 1));

        System.out.println("--------확인문제7");
        double x2 = 5.0;
        double y2 = 0.0;
        double z2 = 5 % y;
        if (Double.isNaN(z2)) {
            System.out.println("0.0으로 나눌 수 없습니다.");
        } else {
            double result2 = z2 + 10;
            System.out.println("결과: " + result2);
        }
    }
}
