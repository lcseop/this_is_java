package com.mjc813;

import java.lang.reflect.*;
import java.text.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.regex.Pattern;

public class Example {
    public void stringTokenExam() {
        String data1 = "홍길동&이수홍,박연수";
        String[] arr = data1.split("&|,");
        for (String token : arr) {
            System.out.println(token);
        }
        System.out.println();

        String data2 = "홍길동/이수홍/박연수";
        StringTokenizer st = new StringTokenizer(data2, "/");
        while (st.hasMoreTokens()) {
            String token = st.nextToken();
            System.out.println(token);
        }
    }

    public void boxingUnBoxingExam() {
        // Boxing
        Integer obj = 100;
        System.out.println("value: " + obj.intValue());

        // Unboxing
        int value = obj;
        System.out.println("value: " + value);

        // 연산 시 Unboxing
        int result = obj + 100;
        System.out.println("result: " + result);
    }

    public void valueCompareExam() {
        // -128~127 초과값일 경우
        Integer obj1 = 300;
        Integer obj2 = 300;
        System.out.println("==: " + (obj1 == obj2));
        System.out.println("equals(): " + obj1.equals(obj2));
        System.out.println();

        // -128~127 범위값일 경우
        Integer obj3 = 10;
        Integer obj4 = 10;
        System.out.println("==: " + (obj3 == obj4));
        System.out.println("equals(): " + obj3.equals(obj4));
    }

    public void mathExam() {
        // 큰 정수 또는 작은 정수 얻기
        double v1 = Math.ceil(5.3);
        double v2 = Math.floor(5.3);
        System.out.println("v1=" + v1);
        System.out.println("v2=" + v2);

        // 큰 값 또는 작은 값 얻기
        long v3 = Math.max(3, 7);
        long v4 = Math.min(3, 7);
        System.out.println("v3=" + v3);
        System.out.println("v4=" + v4);

        // 소수 이하 두 자리 얻기
        double value = 12.3456;
        double temp1 = value * 100;
        long temp2 = Math.round(temp1);
        double v5 = temp2 / 100.0;
        System.out.println("v5=" + v5);
    }

    public void randomExam() {
        // 선택번호
        int[] selectNumber = new int[6];
        Random random = new Random(3);
        System.out.print("선택번호: ");
        for (int i = 0; i < 6; i++) {
            selectNumber[i] = random.nextInt(45) + 1;
            System.out.print(selectNumber[i] + " ");
        }
        System.out.println();

        // 당첨번호
        int[] winningNumber = new int[6];
        random = new Random(5);
        System.out.print("당첨번호: ");
        for (int i = 0; i < 6; i++) {
            winningNumber[i] = random.nextInt(45) + 1;
            System.out.print(winningNumber[i] + " ");
        }
        System.out.println();

        // 당첨여부
        Arrays.sort(selectNumber);
        Arrays.sort(winningNumber);
        boolean result = Arrays.equals(selectNumber, winningNumber);
        System.out.print("당첨여부: ");
        if (result) {
            System.out.println("1등에 당첨되셨습니다.");
        } else {
            System.out.println("당첨되지 않았습니다.");
        }
    }

    public void dateExam() {
        Date now = new Date();
        String strNow1 = now.toString();
        System.out.println(strNow1);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH.mm.ss");
        String strNow2 = sdf.format(now);
        System.out.println(strNow2);
    }

    public void calendarExam() {
        Calendar now = Calendar.getInstance();

        int year = now.get(Calendar.YEAR);
        int month = now.get(Calendar.MONTH) + 1;
        int day = now.get(Calendar.DAY_OF_MONTH);
        int week = now.get(Calendar.DAY_OF_WEEK);
        String strWeek = null;
        switch(week) {
            case Calendar.MONDAY: strWeek = "월"; break;
            case Calendar.TUESDAY: strWeek = "화"; break;
            case Calendar.WEDNESDAY: strWeek = "수"; break;
            case Calendar.THURSDAY: strWeek = "목"; break;
            case Calendar.FRIDAY: strWeek = "금"; break;
            case Calendar.SATURDAY: strWeek = "토"; break;
            case Calendar.SUNDAY: strWeek = "일";
        }

        int amPm = now.get(Calendar.AM_PM);
        String strAmPm = null;
        if (amPm == Calendar.AM) {
            strAmPm = "오전";
        } else {
            strAmPm = "오후";
        }

        int hour = now.get(Calendar.HOUR);
        int minute = now.get(Calendar.MINUTE);
        int second = now.get(Calendar.SECOND);

        System.out.println(year + "년 " + month + "월 " + day + "일 " + strWeek + "요일 " + strAmPm + " " + hour + "시 " + minute + "분 " + second + "초 ");
    }

    public void losAngelesExam() {
        TimeZone timeZone = TimeZone.getTimeZone("America/Los_Angeles");
        Calendar now = Calendar.getInstance(timeZone);

        int amPm = now.get(Calendar.AM_PM);
        String strAmPm = null;
        if (amPm == Calendar.AM) {
            strAmPm = "오전";
        } else {
            strAmPm = "오후";
        }

        int hour = now.get(Calendar.HOUR);
        int minute = now.get(Calendar.MINUTE);
        int second = now.get(Calendar.SECOND);

        System.out.print(strAmPm + " ");
        System.out.print(hour + "시 ");
        System.out.print(minute + "분 ");
        System.out.println(second + "초 ");
    }

    public void printTimeZoneId() {
        String[] availableIDs = TimeZone.getAvailableIDs();
        for (String id : availableIDs) {
            System.out.println(id);
        }
    }

    public void dateTimeOperationExam() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy.MM.dd a HH:mm:ss");
        System.out.println("현재 시간: " + now.format(dtf));

        LocalDateTime result1 = now.plusYears(1);
        System.out.println("1년 덧셈: " + result1.format(dtf));

        LocalDateTime result2 = now.minusMonths(2);
        System.out.println("2월 뺄셈: " + result2.format(dtf));

        LocalDateTime result3 = now.plusDays(7);
        System.out.println("7일 덧셈: " + result3.format(dtf));
    }

    public void dateTimeCompareExam() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy.MM.dd a HH:mm:ss");

        LocalDateTime startDateTime = LocalDateTime.of(2021, 1, 1, 0, 0, 0);
        System.out.println("시작일: " + startDateTime.format(dtf));

        LocalDateTime endDateTime = LocalDateTime.of(2021, 12, 31, 0, 0, 0);
        System.out.println("종료일: " + endDateTime.format(dtf));

        if (startDateTime.isBefore(endDateTime)) {
            System.out.println("진행 중입니다.");
        } else if (startDateTime.isEqual(endDateTime)) {
            System.out.println("종료합니다.");
        } else if (startDateTime.isAfter(endDateTime)) {
            System.out.println("종료했습니다.");
        }

        long remainYear = startDateTime.until(endDateTime, ChronoUnit.YEARS);
        long remainMonth = startDateTime.until(endDateTime, ChronoUnit.MONTHS);
        long remainDay = startDateTime.until(endDateTime, ChronoUnit.DAYS);
        long remainHour = startDateTime.until(endDateTime, ChronoUnit.HOURS);
        long remainMinute = startDateTime.until(endDateTime, ChronoUnit.MINUTES);
        long remainSecond = startDateTime.until(endDateTime, ChronoUnit.SECONDS);
        System.out.println("남은 해: " + remainYear);
        System.out.println("남은 월: " + remainMonth);
        System.out.println("남은 일: " + remainDay);
        System.out.println("남은 시간: " + remainHour);
        System.out.println("남은 분: " + remainMinute);
        System.out.println("남은 초: " + remainSecond);
    }

    public void decimalFormatExam() {
        double num = 1234567.89;

        DecimalFormat df;

        df = new DecimalFormat("#,###");
        System.out.println(df.format(num));

        df = new DecimalFormat("#,###.0");
        System.out.println(df.format(num));
    }

    public void simpleDateFormatExam() {
        Date now = new Date();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(sdf.format(now));

        sdf = new SimpleDateFormat("yyyy년 MM월 dd일");
        System.out.println(sdf.format(now));

        sdf = new SimpleDateFormat("yyyy.MM.dd a HH:mm:ss");
        System.out.println(sdf.format(now));

        sdf = new SimpleDateFormat("오늘은 E요일");
        System.out.println(sdf.format(now));

        sdf = new SimpleDateFormat("올해의 D번째 날");
        System.out.println(sdf.format(now));

        sdf = new SimpleDateFormat("이달의 d번째 날");
        System.out.println(sdf.format(now));
    }

    public void patternExam() {
        String regExp = "(02|010)-\\d{3,4}-\\d{4}";
        String data = "010-123-4567";
        boolean result = Pattern.matches(regExp, data);
        if (result) {
            System.out.println("정규식과 일치합니다.");
        } else {
            System.out.println("정규식과 일치하지 않습니다.");
        }

        regExp = "\\w+@\\w+\\.\\w+(\\.\\w+)?";
        data = "angel@mycompanycom";
        result = Pattern.matches(regExp, data);
        if (result) {
            System.out.println("정규식과 일치합니다.");
        } else {
            System.out.println("정규식과 일치하지 않습니다.");
        }
    }

    public void getClassExam() {
        // how1
        Class clazz = Car.class;

        // how2
        // Class clazz = Class.forName("com.mjc813.Car");

        // how3
        // Class clazz = car.getClass();

        System.out.println("패키지: " + clazz.getPackage().getName());
        System.out.println("클래스 간단 이름: " + clazz.getSimpleName());
        System.out.println("클래스 전체 이름: " + clazz.getName());
    }

    public void reflectionExam() {
        Class clazz = Car.class;

        System.out.println("[생성자 정보]");
        Constructor[] constructors = clazz.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            System.out.print(constructor.getName() + "(");
            Class[] parameters = constructor.getParameterTypes();
            printParameters(parameters);
            System.out.println(")");
        }
        System.out.println();

        System.out.println("[필드 정보]");
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.getType().getName() + " " + field.getName());
        }
        System.out.println();

        System.out.println("[메소드 정보]");
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            System.out.print(method.getName() + "(");
            Class[] parameters = method.getParameterTypes();
            printParameters(parameters);
            System.out.println(")");
        }
    }

    private void printParameters(Class[] parameters) {
        for (int i = 0; i < parameters.length; i++) {
            System.out.println(parameters[i].getName());
            if (i < parameters.length-1) {
                System.out.println(",");
            }
        }
    }

    public void printAnnotationExam() throws InvocationTargetException, IllegalAccessException {
        Method[] declaredMethods = Service.class.getDeclaredMethods();
        for (Method method : declaredMethods) {
            PrintAnnotation printAnnotation = method.getAnnotation(PrintAnnotation.class);

            printLine(printAnnotation);

            method.invoke(new Service());

            printLine(printAnnotation);
        }
    }

    private void printLine(PrintAnnotation printAnnotation) {
        int number = printAnnotation.number();
        for (int i = 0; i < number; i++) {
            String value = printAnnotation.value();
            System.out.print(value);
        }
        System.out.println();
    }

    public void studentExam() {
        HashSet<Student> hashSet = new HashSet<Student>();

        hashSet.add(new Student("1"));
        hashSet.add(new Student("1"));
        hashSet.add(new Student("2"));

        System.out.println("저장된 Student 수: " + hashSet.size());
    }

    public void memberExam() {
        Member member = new Member("blue", "이파란");
        System.out.println(member);
    }

    public void exam8() {
        long time1 = System.nanoTime();
        int[] scores = new int[1000];
        for (int i = 0; i < scores.length; i++) {
            scores[i] = i;
        }

        int sum = 0;
        for (int score : scores) {
            sum += score;
        }

        double avg = sum / scores.length;
        System.out.println(avg);
        long time2 = System.nanoTime();
        System.out.println("걸린 나노초: " + (time2 - time1));
    }

    public void decodingExam() {
        byte[] bytes = { -20, -107, -120, -21, -123, -107 };
        String str = new String(bytes);
        System.out.println("str: " + str);
    }

    public void stringBuilderExam() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 100; i++) {
            sb.append(String.valueOf(i));
        }
        System.out.println(sb);
    }

    public void exam11() {
        StringTokenizer st = new StringTokenizer("아이디,이름,패스워드", ",");
        while (st.hasMoreTokens()) {
            System.out.println(st.nextToken());
        }
    }

    public void integerCompareExam() {
        Integer obj1 = 100;
        Integer obj2 = 100;
        Integer obj3 = 300;
        Integer obj4 = 300;

        System.out.println(obj1 == obj2);
        System.out.println(obj3.equals(obj4));
    }

    public void exam15() {
        LocalDateTime ldt = LocalDateTime.now();
        LocalDateTime ldtEnd = LocalDateTime.of(2026, 12, 31, 0, 0, 0);
        System.out.println("올해 12월 31일까지 남은 일 수 : " + ldt.until(ldtEnd, ChronoUnit.DAYS));
    }

    public void exam16() {
        Date ldt = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 E요일 HH시 mm분");
        System.out.println(sdf.format(ldt));
    }

    public void exam17() {
        String id = "5Angel1004";
        String regExp = "[a-zA-Z]+\\w{8,12}";
        boolean isMatch = Pattern.matches(regExp, id);
        if(isMatch) {
            System.out.println("ID로 사용할 수 있습니다.");
        } else {
            System.out.println("ID로 사용할 수 없습니다.");
        }
    }


}
