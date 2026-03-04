package com.mjc813;

public class Main {
    public static void main(String[] args) {
        Example example = new Example();

        System.out.println("------------------procString");
        example.procStringExam();
        System.out.println("------------------p699 람다식");
        example.lamdaExmaple();
        System.out.println("------------------p701 매개변수가 없는 람다식");
        example.lamdaExample2();
        System.out.println("------------------p703 클래스 안의 인터페이스 람다식 지정");
        example.buttonExample();
        System.out.println("------------------p705 매개변수가 있는 람다식");
        example.lamdaExample3();
        System.out.println("------------------p707 리턴값이 있는 람다식");
        example.lamdaExample4();
        System.out.println("------------------p709 메소드 참조");
        example.methodReferenceExample();
        System.out.println("------------------p714 생성자 참조");
        example.constructorReferenceExample();
    }
}