package com.mjc813;

import java.util.*;
import java.util.stream.Stream;

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
}
