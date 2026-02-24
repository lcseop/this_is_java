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
    }
}