package com.mjc813;

public class Main {
    public static void main(String[] args) {
        Human human1 = new Human();
        Human human2 = new Human();

        human1.setName("홍길동");
        human1.setAge(20);
        human2.setName("김길동");
        human2.setAge(25);

        Packaging packString = new Packaging();
        packString.add("pack 테스트1");
        packString.add("pack 테스트2");
        packString.add("pack 테스트3");
        System.out.println(packString.remove());
        System.out.println(packString.remove());
        System.out.println(packString.remove());

        Packaging packHuman = new Packaging();
        packHuman.add(human1);
        packHuman.add(human2);
        System.out.println(packHuman.remove());
        System.out.println(packHuman.remove());



        GenericPackaging<String> gPackString = new GenericPackaging<String>();
        gPackString.add("generic 테스트1");
        gPackString.add("generic 테스트2");
        gPackString.add("generic 테스트3");
        System.out.println(gPackString.remove());
        System.out.println(gPackString.remove());
        System.out.println(gPackString.remove());

        GenericPackaging<Human> gPackHuman = new GenericPackaging<Human>();
        gPackHuman.add(human1);
        gPackHuman.add(human2);
        System.out.println(gPackHuman.remove().getName());
        System.out.println(gPackHuman.remove().getAge());
    }
}