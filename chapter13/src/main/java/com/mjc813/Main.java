package com.mjc813;

public class Main {
    public static void main(String[] args) {
        Example exam = new Example();
        System.out.println("-----------------------개인과제1. Object를 Generic으로");
        exam.objectToGeneric();
        System.out.println("-----------------------p575. 제네릭 타입");
        exam.genericExample();
        System.out.println("-----------------------p577. 제네릭 타입 인터페이스");
        exam.genericInterfaceExample();
        System.out.println("-----------------------p579. 제네릭 타입 equals");
        exam.genericEqualsExample();
        System.out.println("-----------------------개인과제4. 닌텐도 게임 홈페이지 리스트");
        exam.nintendoCRUDExample();
        System.out.println("-----------------------확인문제2. ContainerExample");
        exam.containerExample();
        System.out.println("-----------------------확인문제3. ContainerExample");
        exam.containerMultiExample();
        System.out.println("-----------------------확인문제4. UtilExample");
        exam.utilExample();
        System.out.println("-----------------------p582. 제네릭 메소드");
        exam.genericMethodExample();
        System.out.println("-----------------------p584. 제한된 타입 파라미터");
        exam.genericExtendsExample();
        System.out.println("-----------------------p586. 와일드카드 타입 파라미터");
        exam.genericWildCardExample();

    }
}