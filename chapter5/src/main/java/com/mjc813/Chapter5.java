package com.mjc813;

import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.Scanner;

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

    public void arrayExam1() {
        String[] season = { "Spring", "Summer", "Fall", "Winter" };

        System.out.println("season[0]: " + season[0]);
        System.out.println("season[1]: " + season[1]);
        System.out.println("season[2]: " + season[2]);
        System.out.println("season[3]: " + season[3]);

        season[1] = "여름";
        System.out.println("season[1]: " + season[1]);
        System.out.println();

        int[] scores = { 83, 90, 87 };
        int sum = 0;
        for (int i = 0; i < 3; i++) {
            sum += scores[i];
        }
        System.out.println("총합 : " + sum);
        double avg = (double) sum/3;
        System.out.println("평균 : " + avg);
    }

    public void arrayExam2() {
        int[] scores;
        scores = new int[] { 83, 90, 87 };
        int sum1 = 0;
        for (int i = 0; i < 3; i++) {
            sum1 += scores[i];
        }
        System.out.println("총합 : " + sum1);

        printItem(new int[] { 83, 90, 87 });
    }

    public void arrayCreateExam() {
        int[] arr1 = new int[3];
        for (int i = 0; i < 3; i++) {
            System.out.print("arr1[" + i + "] : " + arr1[i] + ", ");
        }
        System.out.println();
        arr1[0] = 10;
        arr1[1] = 20;
        arr1[2] = 30;

        for (int i = 0; i < 3; i++) {
            System.out.print("arr1[" + i + "] : " + arr1[i] + ", ");
        }
        System.out.println();

        double[] arr2 = new double[3];
        for (int i = 0; i < 3; i++) {
            System.out.print("arr2[" + i + "] : " + arr2[i] + ", ");
        }
        System.out.println();

        arr2[0] = 0.1;
        arr2[1] = 0.2;
        arr2[2] = 0.3;
        for (int i = 0; i < 3; i++) {
            System.out.print("arr2[" + i + "] : " + arr2[i] + ", ");
        }
        System.out.println();

        String[] arr3 = new String[3];
        for (int i = 0; i < 3; i++) {
            System.out.print("arr3[" + i + "] : " + arr3[i] + ", ");
        }
        System.out.println();

        arr3[0] = "1월";
        arr3[1] = "2월";
        arr3[2] = "3월";
        for (int i = 0; i < 3; i++) {
            System.out.print("arr3[" + i + "] : " + arr3[i] + ", ");
        }

    }

    public void arrayLengthExam() {
        int[] scores = { 84, 90, 96 };

        int sum = 0;
        for (int i = 0; i < scores.length; i++) {
            sum += scores[i];
        }
        System.out.println("총합 : " + sum);

        double avg = (double) sum / scores.length;
        System.out.println("평균 : " + avg);
    }

    public void multiDimensionalArrayExam() {
        int[][] scores = { { 80, 90, 96 }, { 76, 88 } };

        System.out.println("1차원 배열 길이(반의 수): " + scores.length);
        System.out.println("2차원 배열 길이(첫 번째 반의 학생 수): " + scores[0].length);
        System.out.println("2차원 배열 길이(두 번째 반의 학생 수): " + scores[1].length);

        System.out.println("scores[0][2]: " + scores[0][2]);
        System.out.println("scores[1][1]: " + scores[1][1]);

        int class1Sum = 0;
        for (int i = 0; i < scores[0].length; i++) {
            class1Sum += scores[0][i];
        }
        double class1Avg = (double) class1Sum / scores[0].length;
        System.out.println("첫 번째 반의 평균 점수: " + class1Avg);

        int class2Sum = 0;
        for (int i = 0; i < scores[1].length; i++) {
            class2Sum += scores[1][i];
        }
        double class2Avg = (double) class2Sum / scores[1].length;
        System.out.println("두 번째 반의 평균 점수: " + class2Avg);

        int totalStudent = 0;
        int totalSum = 0;
        for (int i = 0; i < scores.length; i++) {
            totalStudent += scores[i].length;
            for (int k = 0; k < scores[i].length; k++) {
                totalSum += scores[i][k];
            }
        }
        double totalAvg = (double) totalSum / totalStudent;
        System.out.println("전체 학생의 평균 점수: " + totalAvg);

    }

    public void multiDimensionalArrayByNewExam() {
        int[][] mathScores = new int[2][3];
        for (int i = 0; i < mathScores.length; i++) {
            for (int j = 0; j < mathScores[i].length; j++) {
                System.out.println("mathScores[" + i + "][" + j + "]: " + mathScores[i][j]);
            }
        }
        System.out.println();

        mathScores[0][0] = 80;
        mathScores[0][1] = 83;
        mathScores[0][2] = 85;
        mathScores[1][0] = 86;
        mathScores[1][1] = 90;
        mathScores[1][2] = 92;

        int totalStudent = 0;
        int totalMathSum = 0;
        for (int i = 0; i < mathScores.length; i++) {
            totalStudent += mathScores[i].length;
            for (int k = 0; k < mathScores[i].length; k++) {
                totalMathSum += mathScores[i][k];
            }
        }
        double totalMathAvg = (double) totalMathSum / totalStudent;
        System.out.println("전체 학생의 수학 평균 점수: " + totalMathAvg);
        System.out.println();

        int[][] englishScores = new int[2][];
        englishScores[0] = new int[2];
        englishScores[1] = new int[3];
        for (int i = 0; i < englishScores.length; i++) {
            for (int k = 0; k < englishScores[i].length; k++) {
                    System.out.println("englishScores[" + i + "][" + k + "]: " + englishScores[i][k]);
            }
        }
        System.out.println();

        englishScores[0][0] = 90;
        englishScores[0][1] = 91;
        englishScores[1][0] = 92;
        englishScores[1][1] = 93;
        englishScores[1][2] = 94;

        totalStudent = 0;
        int totalEnglishSum = 0;
        for (int i = 0; i < englishScores.length; i++) {
            totalStudent += englishScores[i].length;
            for (int k = 0; k < englishScores[i].length; k++) {
                totalEnglishSum += englishScores[i][k];
            }
        }
        double totalEnglishAvg = (double) totalEnglishSum / totalStudent;
        System.out.println("전체 학생의 영어 평균 점수: " + totalEnglishAvg);
    }

    public void arrayTest() {
        char[][] lines = new char[5][];
        for (int i = 0; i < lines.length; i++) {
            lines[i] = new char[i+1];
            for (int j = 0; j < lines[i].length; j++) {
                lines[i][j] = '*';
            }
        }

        for (int i = 0; i < lines.length; i++) {
            for (int j = 0; j < lines[i].length; j++) {
                System.out.printf("%c", lines[i][j]);
            }
            System.out.println();
        }


    }

    private int[] findMinMax(int[] array) {
        int[] result = { Integer.MAX_VALUE, Integer.MIN_VALUE };
        for (int num : array) {
            result[0] = (result[0] > num) ? num : result[0];
            result[1] = (result[1] < num) ? num : result[1];
        }
        return result;
    }

    public void acmicpcNet_problem_10818() {
        Scanner scanner = new Scanner(System.in);
        int count = inputInteger(scanner);
        if (count <= 0) {
            return;
        }

        int[] intArray = new int[count];
        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = scanner.nextInt();
        }

        int[] resArray = findMinMax(intArray);
        System.out.println("acmicpcNet_problem_10818 = " + resArray[0] + ", " + resArray[1]);

    }

    public static void printItem(int[] scores) {
        for (int i = 0; i < 3; i++) {
            System.out.println("score[" + i + "]: " + scores[i]);
        }
    }

    private int inputInteger(Scanner s) {
        int count = 0;
        try {
            count = s.nextInt();
        } catch (InputMismatchException i) {
            System.err.println("올바른 정수 값을 입력하세요.");
            count = -1;
        }
        catch (Exception e) {
            System.err.println("Error : " + e);
            count = -1;
        }

        return count;
    }

    public void arrayProblem() {
        System.out.println("과제 1번 --------------------");
        boolean[] boolArray = new boolean[10];
        for (int i = 0; i < boolArray.length; i++) {
            boolArray[i] = i % 2 == 0;
            System.out.print((i != boolArray.length - 1) ? boolArray[i] + ", " : boolArray[i]);
        }

        System.out.println("\n과제 1-1번 --------------------");
        int[] intArray = new int[30];
        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = i;
            System.out.print((i != intArray.length - 1) ? intArray[i] + ", " : intArray[i]);
        }

        System.out.println("\n과제 1-2번 --------------------");
        char[] charArray = new char[20];
        for (char ch : charArray) {
            System.out.print(ch + " ");
        }

        System.out.println("\n과제 1-3번 --------------------");
        boolean[][] multiBooleanArray = new boolean[3][4];
        for (int i = 0; i < multiBooleanArray.length; i++) {
            for (int j = 0; j < multiBooleanArray[i].length; j++) {
                multiBooleanArray[i][j] = true;
                System.out.print(multiBooleanArray[i][j] + " ");
            }
        }

        System.out.println("\n과제 1-4번 --------------------");
        String[] stringArray = new String[50];
        for (int i = 0; i < stringArray.length; i++) {
            stringArray[i] = "empty";
            System.out.print(stringArray[i] + " ");
        }

        System.out.println("\n\n과제 2번 --------------------");
//        int[][] intDemention2 = {
//                {0, 0, 1, 1, 0, 0}, {1, 0, 0, 1, 0, 0}
//                , {0, 1, 0, 1, 0, 0}, {0, 0, 1, 1, 0, 1}
//                , {1, 0, 0, 0, 1, 0}
//        };
        int[][] intDemention2 = {
                {1, 0, 1, 0, 0, 1}
                , {1, 0, 1, 1, 0, 1}
                , {0, 1, 0, 1, 0, 0}
                , {1, 0, 0, 1, 0, 1}
                , {1, 0, 1, 0, 0, 1}
        };

        int[] sumArray = new int[2];

        for (int i = 0; i < intDemention2.length; i++) {
            for (int j = 0; j < intDemention2[i].length; j++) {
                if (intDemention2[i][j] == 0) {
                    sumArray[0]++;
                } else if (intDemention2[i][j] == 1) {
                    sumArray[1]++;
                }
            }
        }
        System.out.println("0의 갯수: " + sumArray[0] + ", 1의 갯수: " + sumArray[1]);


        System.out.println("\n과제 3번 --------------------");
//        char[][] chInput = {
//                {'*', '*', '*', '*', ' '},
//                {'*', '*', ' ', ' ', ' '},
//                {'*', ' ', '*', '*', '*'}
//        };
        char[][] chInput = {
                {'*', ' ', '*', '*', ' '}
                , {'*', '*', ' ', ' ', ' '}
                , {'*', ' ', '*', ' ', '*'}
                , {' ', '*', '*', ' ', '*'}
                , {'*', ' ', '*', ' ', '*'}
                , {' ', ' ', '*', '*', '*'}
        };

        System.out.println("입력 값 : ");
        int sum = 0;
        for (int i = 0; i < chInput.length; i++) {
            for (int j = 0; j < chInput[i].length; j++) {
                System.out.print(chInput[i][j]);
                sum++;
            }
            System.out.println();
        }

        char[][] chOutput = new char[sum/chInput.length][chInput.length];
        for (int i = 0; i < chInput.length; i++) {
            for (int j = 0; j < chInput[i].length; j++) {
                chOutput[j][i] = chInput[i][j];
            }
        }

        System.out.println("출력 값 : ");
        for (int i = 0; i < chOutput.length; i++) {
            for (int j = 0; j < chOutput[i].length; j++) {
                System.out.print(chOutput[i][j]);
            }
            System.out.println();
        }
    }

    public void arrayProblem2() {
        System.out.println("1-1 -----------------");
        double[] dArray = new double[25];
        for (int i = 0; i < dArray.length; i++) {
            dArray[i] = Math.random()*100;
            System.out.print((i != dArray.length-1) ? dArray[i] + ", " : dArray[i]);
        }

        System.out.println("\n1-2 -----------------");
        int[] nArray = new int[25];
        for (int i = 0; i < nArray.length; i++) {
            nArray[i] = (int) dArray[i];
            System.out.print((i != nArray.length-1) ? nArray[i] + ", " : nArray[i]);
        }

        System.out.println("\n1-3 -----------------");
        String[] strArray = new String[25];
        for (int i = 0; i < strArray.length; i++) {
            strArray[i] = dArray[i] + " => " + nArray[i];
            System.out.print((i != strArray.length-1) ? strArray[i] + ", " : strArray[i]);
        }

        System.out.println("\n2-1 -----------------");
        System.out.print("enter: ");
        Scanner s = new Scanner(System.in);
        int count = s.nextInt();
        int[][] nArray2 = new int[count][count];
        for (int i = 0; i < nArray2.length; i++) {
            for (int j = 0; j < nArray2[i].length; j++) {
                nArray2[i][j] = i+j+1;
                System.out.print(nArray2[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("2-2 -----------------");
        System.out.print("enter: ");
        count = s.nextInt();
        char[][] square = new char[count][count];
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < count; j++) {
                if (i == 0) {
                    square[i][j] = (j == 0) ? '┌' : (j == count-1) ? '┐' : '─';
                } else if (i == count-1) {
                    square[i][j] = (j == 0) ? '└' : (j == count-1) ? '┘' : '─';
                } else {
                    square[i][j] = (j == 0 || j == count-1) ? '│' : ' ';
                }
                System.out.print(square[i][j]);
            }
            System.out.println();
        }

        System.out.println("\n2-3 -----------------");
        System.out.print("enter: ");
        count = s.nextInt();
        if (count % 2 == 0) {
            System.out.println("홀수로 입력하세요.");
            return;
        }
        char[][] chDiamond = new char[count][count];

        // 변수 초기화
        // star : 출력할 별의 위치, num : 출력할 별의 갯수, index : 현재 행
        int star = chDiamond.length/2, num = 1, index = 0;

        // 별 갯수 증가
        for (int i = 0; i < chDiamond.length/2; i++) {
            for (int j = 0; j < star; j++) {
                chDiamond[i][j] = ' ';
                System.out.print(chDiamond[i][j]);
            }
            for (int st = star; st < star + num; st++) {
                chDiamond[i][st] = '*';
                System.out.print(chDiamond[i][st]);
            }
            for (int j = chDiamond.length - (star + num); j < chDiamond.length; j++) {
                chDiamond[i][j] = ' ';
                System.out.print(chDiamond[i][j]);
            }
            star--;
            index++;
            num += 2;
            System.out.println();
        }

        // 별 갯수 최대
        for (int i = 0; i < num; i++) {
            chDiamond[index][i] = '*';
            System.out.print(chDiamond[index][i]);
        }
        star++; num -= 2;
        int nowIndex = index;

        System.out.println();

        // 별 갯수 감소
        for (int i = ++index; i < nowIndex+chDiamond.length/2+1; i++) {
            for (int j = 0; j < star; j++) {
                chDiamond[i][j] = ' ';
                System.out.print(chDiamond[i][j]);
            }
            for (int st = star; st < star + num; st++) {
                chDiamond[i][st] = '*';
                System.out.print(chDiamond[i][st]);
            }
            for (int j = chDiamond.length - (star + num); j < chDiamond.length; j++) {
                chDiamond[i][j] = ' ';
                System.out.print(chDiamond[i][j]);
            }
            star++;
            index++;
            num -= 2;
            System.out.println();
        }

         s.close();
    }

    public void testEnum() {
        Genre gen = Genre.ACTION;
        Genre[] genres = new Genre[3];

        for (Genre g : genres) {
            System.out.println(g);
        }
    }

    public void arrayExam3() {
        // 객체를 참조하는 배열
        String[] strArray = new String[3];
        strArray[0] = "Java";
        strArray[1] = "Java";
        strArray[2] = new String("Java");

        System.out.println(strArray[0] == strArray[1]);
        System.out.println(strArray[0] == strArray[2]);
        System.out.println(strArray[0].equals(strArray[2]));

        // 배열 복사
        int[] oldIntArray = { 1, 2, 3 };
        int[] newIntArray = new int[5];

        for (int i = 0; i < oldIntArray.length; i++) {
            newIntArray[i] = oldIntArray[i];
        }

        for (int i = 0; i < newIntArray.length; i++) {
            System.out.print(newIntArray[i] + ", ");
        }
        System.out.println();

        // 배열 복사 (arraycopy())
        String[] oldStrArray = { "java", "array", "copy" };
        String[] newStrArray = new String[5];

        System.arraycopy(oldStrArray, 0, newStrArray, 0, oldStrArray.length);

        for (int i = 0; i < newStrArray.length; i++) {
            System.out.print(newStrArray[i] + ", ");
        }
        System.out.println();

        // 향상된 for 문
        int[] scores = { 95, 71, 84, 93, 87 };
        int sum = 0;
        for (int score: scores) {
            sum = sum + score;
        }
        System.out.println("점수 총합 = " + sum);
        double avg = (double) sum / scores.length;
        System.out.println("점수 평균 = " + avg);

        // Enum
        Week today = null;

        Calendar cal = Calendar.getInstance();

        int week = cal.get(Calendar.DAY_OF_WEEK);

        switch(week) {
            case 1 : today = Week.SUNDAY; break;
            case 2 : today = Week.MONDAY; break;
            case 3 : today = Week.THUSDAY; break;
            case 4 : today = Week.WEDENSDAY; break;
            case 5 : today = Week.THURSDAY; break;
            case 6 : today = Week.FRIDAY; break;
            case 7 : today = Week.SATURDAY; break;
        }

        if (today == Week.SUNDAY) {
            System.out.println("일요일에는 축구를 합니다.");
        } else {
            System.out.println(today + "에는 열심히 자바를 공부합니다.");
        }
    }

    public void praticeCheck() {
        int[] array = {1, 5, 3, 8, 2};
        int max = Integer.MIN_VALUE;
        for (int num : array) {
            max = (num > max) ? num : max;
        }
        System.out.println(max);


        int[][] array2 = {
                {95, 86},
                {83, 92, 96},
                {78, 83, 93, 87, 88}
        };

        int arrayList[] = new int[3];
        for (int i = 0; i < array2.length; i++) {
            for (int j = 0; j < array2[i].length; j++) {
                arrayList[0] += array2[i][j];
                arrayList[2]++;
            }
        }
        arrayList[1] = arrayList[0] / arrayList[2];
        System.out.println("합계는 " + arrayList[0] + ", 평균은 " + arrayList[1]);

        Scanner s = new Scanner(System.in);
        int[] scoreList = new int[0];
        loop: while (true) {
            System.out.println("------------------------------------------------------");
            System.out.println("1. 학생수 | 2. 점수입력 | 3. 점수리스트 | 4. 분석 | 5. 종료");
            System.out.println("------------------------------------------------------");
            System.out.print("선택> ");

            switch (Integer.parseInt(s.nextLine())) {
                case 1 :
                    System.out.print("학생수> ");
                    scoreList = new int[Integer.parseInt(s.nextLine())];
                    break;
                case 2 :
                    for (int i = 0; i < scoreList.length; i++) {
                        do {
                            System.out.print("scores[" + i + "]> ");
                            scoreList[i] = Integer.parseInt(s.nextLine());
                            if (scoreList[i] >= 0 && scoreList[i] <= 100) {
                                break;
                            }
                            System.out.println("0~100점 사이의 정수만 입력");
                        } while(true);
                    }
                    break;
                case 3 :
                    for (int i = 0; i < scoreList.length; i++) {
                        System.out.print("scores[" + i + "]: " + scoreList[i] + "\n");
                    }
                    break;
                case 4 :
                    int maxScore = Integer.MIN_VALUE, sumScore = 0;
                    double avgScore = 0;
                    for (int i = 0; i < scoreList.length; i++) {
                        maxScore = (scoreList[i] > maxScore) ? scoreList[i] : maxScore;
                        sumScore += scoreList[i];
                    }
                    avgScore = (double) (sumScore / scoreList.length);
                    System.out.println("최고 점수: " + maxScore);
                    System.out.println("평균 점수: " + avgScore);
                    break;
                case 5 :
                    System.out.println("프로그램 종료");
                    break loop;
            }
        }
    }

    public void arrayAddExam() {
        // 1-1
        String[] mon = new String[12];
        mon = new String[] { "1월", "2월", "3월", "4월", "5월", "6월", "7월", "8월", "9월", "10월", "11월", "12월" };
    }
}
