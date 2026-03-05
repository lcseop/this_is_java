package com.mjc813;

import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.*;

public class Example {
    public void streamExample() {
        Set<String> set = new HashSet<>();
        set.add("홍길동");
        set.add("신용권");
        set.add("김자바");

        Stream<String> stream = set.stream();
        stream.forEach(System.out::println);
    }

    public void parallelStreamExample() {
        List<String> list = new ArrayList<>();
        list.add("홍길동");
        list.add("신용권");
        list.add("김자바");
        list.add("람다식");
        list.add("박병렬");

        Stream<String> parallelStream = list.parallelStream();
        parallelStream.forEach(name -> System.out.println(name + ": " + Thread.currentThread().getName()));
    }

    public void streamPipeLineExample() {
        List<Student> list = Arrays.asList(
                new Student("홍길동", 10),
                new Student("신용권", 20),
                new Student("유미선", 30)
        );

//        Stream<Student> studentStream = list.stream();
//        IntStream scoreStream = studentStream.mapToInt(Student::getScore);
//        double avg = scoreStream.average().getAsDouble();

        double avg = list.stream()
                .mapToInt(Student::getScore)
                .average()
                .getAsDouble();

        System.out.println("평균 점수: " + avg);
    }

    public void collectionStreamExample() {
        List<Product> list = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            Product product = new Product(i, "상품"+i, "멋진 회사 ", (int) (10000*Math.random()));
            list.add(product);
        }

        Stream<Product> stream = list.stream();
        stream.forEach(System.out::println);
    }

    public void arrayStreamExample() {
        String[] strArray = { "홍길동", "신용권", "김미나" };
        Stream<String> strStream = Arrays.stream(strArray);
        strStream.forEach(item -> System.out.print(item + ", "));
        System.out.println();

        int[] intArray = { 1, 2, 3, 4, 5 };
        IntStream intStream = Arrays.stream(intArray);
        intStream.forEach(item -> System.out.print(item + ", "));
        System.out.println();
    }

    public static int sumStream;
    public void rangeStreamExample() {
        IntStream stream = IntStream.rangeClosed(1, 100);
        stream.forEach(a -> sumStream += a);
        System.out.println("총합: " + sumStream);
    }

    public void fileStreamExample() throws Exception {
        Path path = Path.of(Example.class.getResource("data.txt").toURI());
        Stream<String> stream = Files.lines(path);
        stream.forEach(System.out::println);
        stream.close();
    }

    public void filteringExample() {
        List<String> list = new ArrayList<>();
        list.add("홍길동"); list.add("신용권");
        list.add("김자바"); list.add("신용권"); list.add("신민철");

        list.stream()
                .distinct()
                .forEach(System.out::println);
        System.out.println();

        list.stream()
                .filter(n -> n.startsWith("신"))
                .forEach(System.out::println);
        System.out.println();

        list.stream()
                .distinct()
                .filter(n -> n.startsWith("신"))
                .forEach(System.out::println);
        System.out.println();
    }

    public void mapExample() {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("홍길동", 85));
        studentList.add(new Student("홍길동", 92));
        studentList.add(new Student("홍길동", 87));

        studentList.stream()
                .mapToInt(Student::getScore)
                .forEach(System.out::println);
    }

    public void mapExample2() {
        int[] intArray = { 1, 2, 3, 4, 5 };

        IntStream intStream = Arrays.stream(intArray);
        intStream
                .asDoubleStream()
                .forEach(System.out::println);

        System.out.println();

        intStream = Arrays.stream(intArray);
        intStream
                .boxed()
                .forEach(obj -> System.out.println(obj.intValue()));
    }

    public void flatMappingExample() {
        List<String> list1 = new ArrayList<>();
        list1.add("this is java");
        list1.add("i am a best developer");
        list1.stream()
                .flatMap(data -> Arrays.stream(data.split(" ")))
                .forEach(System.out::println);
        System.out.println();

        List<String> list2 = Arrays.asList("10, 20, 30", "40, 50");
        list2.stream()
                .flatMapToInt(data -> {
                    String[] strArr = data.split(",");
                    int[] intArr = new int[strArr.length];
                    for (int i = 0; i < strArr.length; i++) {
                        intArr[i] = Integer.parseInt(strArr[i].trim());
                    }
                    return Arrays.stream(intArr);
                })
                .forEach(System.out::println);
    }

    public void sortingExample() {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("홍길동", 30));
        studentList.add(new Student("신용권", 10));
        studentList.add(new Student("유미선", 20));

        studentList.stream()
                .sorted()
                .forEach(s -> System.out.println(s.getName() + ": " + s.getScore()));
        System.out.println();

        studentList.stream()
                .sorted(Comparator.reverseOrder())
                .forEach(s -> System.out.println(s.getName() + ": " + s.getScore()));
        System.out.println();
    }

    public void sortingExample2() {
        List<Student2> studentList = new ArrayList<>();
        studentList.add(new Student2("홍길동", 30));
        studentList.add(new Student2("신용권", 10));
        studentList.add(new Student2("유미선", 20));

        studentList.stream()
                .sorted((s1, s2) -> Integer.compare(s1.getScore(), s2.getScore()))
                .forEach(s -> System.out.println(s.getName() + ": " + s.getScore()));
        System.out.println();

        studentList.stream()
                .sorted((s1, s2) -> Integer.compare(s2.getScore(), s1.getScore()))
                .forEach(s -> System.out.println(s.getName() + ": " + s.getScore()));
        System.out.println();
    }

    public void loopingExample() {
        int[] intArr = { 1, 2, 3, 4, 5 };

        Arrays.stream(intArr)
                .filter(a -> a%2 == 0)
                .peek(System.out::println); // 최종 처리가 없으므로 동작하지 않음

        // peek : 중간 처리 메소드
        int total = Arrays.stream(intArr)
                .filter(a -> a%2 == 0)
                .peek(System.out::println)
                .sum();
        System.out.println("총합: " + total + "\n");

        // forEach : 최종 처리 메소드
        Arrays.stream(intArr)
                .filter(a -> a % 2 == 0)
                .forEach(System.out::println);
    }

    public void matchingExample() {
        int[] intArr ={ 2, 4, 6 };

        boolean result = Arrays.stream(intArr)
                .allMatch(a -> a%2 == 0) ;
        System.out.println("모두 2의 배수인가? " + result);

        result = Arrays.stream(intArr)
                .anyMatch(a -> a%3 == 0);
        System.out.println("하나라도 3의 배수가 있는가? " + result);

        result = Arrays.stream(intArr)
                .noneMatch(a -> a%3 == 0);
        System.out.println("3의 배수가 없는가? " + result);
    }

    public void aggregateExample() {
        int[] arr = { 1, 2, 3, 4, 5 };

        long count = Arrays.stream(arr)
                .filter(n -> n%2 == 0)
                .count();
        System.out.println("2의 배수 개수: " + count);

        long sum = Arrays.stream(arr)
                .filter(n -> n%2 == 0)
                .sum();
        System.out.println("2의 배수의 합: " + sum);

        double avg = Arrays.stream(arr)
                .filter(n -> n%2 == 0)
                .average()
                .getAsDouble();
        System.out.println("2의 배수의 평균: " + avg);

        int max = Arrays.stream(arr)
                .filter(n -> n%2 == 0)
                .max()
                .getAsInt();
        System.out.println("최대값: " + max);

        int min = Arrays.stream(arr)
                .filter(n -> n%2 == 0)
                .min()
                .getAsInt();
        System.out.println("최소값: " + min);

        int first = Arrays.stream(arr)
                .filter(n -> n%3 == 0)
                .findFirst()
                .getAsInt();
        System.out.println("첫 번째 3의 배수: " + first);
    }

    public void optionalExample() {
        List<Integer> list = new ArrayList<>();

//        예외 발생 (java.util.NoSuchElementException)
//        double avg = list.stream()
//                .mapToInt(Integer::intValue)
//                .average()
//                .getAsDouble();

        // 방법1
        OptionalDouble optional = list.stream()
                .mapToInt(Integer::intValue)
                .average();
        if (optional.isPresent()) {
            System.out.println("방법1_평균: " + optional.getAsDouble());
        } else {
            System.out.println("방법1_평균: 0.0");
        }

        // 방법2
        double avg = list.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
        System.out.println("방법2_평균: " + avg);

        // 방법3
        list.stream()
                .mapToInt(Integer::intValue)
                .average()
                .ifPresent(a -> System.out.println("방법3_평균: " + a));
    }

    public void reductionExample() {
        List<Student> studentList = Arrays.asList(
                new Student("홍길동", 92),
                new Student("신용권", 95),
                new Student("김자바", 88)
        );

        // 방법1
        int sum1 = studentList.stream()
                .mapToInt(Student::getScore)
                .sum();

        // 방법2
        int sum2 = studentList.stream()
                .map(Student::getScore)
                .reduce(0, Integer::sum);

        System.out.println("sum1: " + sum1);
        System.out.println("sum2: " + sum2);
    }

    public void collectExample() {
        List<Student3> totalList = new ArrayList<>();
        totalList.add(new Student3("홍길동", "남", 92));
        totalList.add(new Student3("김수영", "여", 87));
        totalList.add(new Student3("감자바", "남", 95));
        totalList.add(new Student3("오해영", "여", 93));

        // 남학생만 묶어 List 생성
//        List<Student3> maleList = totalList.stream()
//                .filter(s -> s.getSex().equals("남"))
//                .collect(Collectors.toList());

        List<Student3> maleList = totalList.stream()
                .filter(s->s.getSex().equals("남"))
                .toList();

        maleList.stream()
                .forEach(s -> System.out.println(s.getName()));

        System.out.println();

        Map<String,Integer> map = totalList.stream()
                .collect(
                        Collectors.toMap(
                                Student3::getName,
                                Student3::getScore
                        )
                );

        System.out.println(map);
        System.out.println();

        Map<String, List<Student3>> maps = totalList.stream()
                .collect(
                        Collectors.groupingBy(Student3::getSex)
                );

        List<Student3> malesList = maps.get("남");
        malesList.stream().forEach(s -> System.out.println(s.getName()));
        System.out.println();

        List<Student3> femaleList = maps.get("여");
        femaleList.stream().forEach(s -> System.out.println(s.getName()));
        System.out.println();

        Map<String,Double> map2 = totalList.stream()
                .collect(
                        Collectors.groupingBy(
                                Student3::getSex,
                                Collectors.averagingDouble(Student3::getScore)
                        )
                );

        System.out.println(map2);
    }

    public void parallelExample() {
        Random random = new Random();

        List<Integer> scores = new ArrayList<>();
        for (int i = 0; i < 100000000; i++) {
            scores.add(random.nextInt(101));
        }

        double avg = 0;
        long startTime = 0;
        long endTime = 0;
        long time = 0;

        Stream<Integer> stream = scores.stream();
        startTime = System.nanoTime();
        avg = stream
                .mapToInt(Integer::intValue)
                .average()
                .getAsDouble();
        endTime = System.nanoTime();
        time = endTime - startTime;
        System.out.println("avg: " + avg + ", 일반 스트림 처리 시간: " + time + "ns");

        Stream<Integer> parallelStream = scores.parallelStream();
        startTime = System.nanoTime();
        avg = parallelStream
                .mapToInt(Integer::intValue)
                .average()
                .getAsDouble();
        endTime = System.nanoTime();
        time = endTime - startTime;
        System.out.println("avg: " + avg + ", 병렬 스트림 처리 시간: " + time + "ns");
    }

    public void exam05() {
        List<String> list = Arrays.asList(
                "This is a java book",
                "Lamda Expressions",
                "Java8 supports lamda expressions"
        );
        list.stream()
                .filter(s -> s.toLowerCase().contains("java"))
                .forEach(System.out::println);
    }

    public void exam06() {
        List<Member> list = Arrays.asList(
                new Member("홍길동", 30),
                new Member("신용권", 40),
                new Member("감자바", 26)
        );

        double avg = list.stream()
                .mapToInt(Member::getAge)
                .average()
                .orElse(0.0);
        System.out.println("평균 나이: " + avg);
    }

    public void exam07() {
        List<Member2> list = Arrays.asList(
                new Member2("홍길동", "개발자"),
                new Member2("김나리", "디자이너"),
                new Member2("신용권", "개발자")
        );

        List<Member2> developers = list.stream()
                .filter(data -> data.getJob().equals("개발자"))
                .toList();
        developers.stream()
                .forEach(m -> System.out.println(m.getName()));
    }

    public void exam08() {
        List<Member2> list = Arrays.asList(
                new Member2("홍길동", "개발자"),
                new Member2("김나리", "디자이너"),
                new Member2("신용권", "개발자")
        );

        Map<String, List<Member2>> groupingMap = list.stream()
                .collect(Collectors.groupingBy(Member2::getJob));

        System.out.println("[개발자]");
        groupingMap.get("개발자").stream()
                .forEach(System.out::println);
        System.out.println();

        System.out.println("[디자이너]");
        groupingMap.get("디자이너").stream()
                .forEach(System.out::println);
    }

}
