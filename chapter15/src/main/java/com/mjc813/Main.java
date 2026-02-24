package com.mjc813;

public class Main {
    public static void main(String[] args) {
        Example exam = new Example();

        System.out.println("-------------------- p644 ArrayList");
        exam.arrayListExample();
        System.out.println("-------------------- p650 LinkedList");
        exam.linkedListExample();
        System.out.println("-------------------- p653 HashSet");
        exam.hashSetExample();
        System.out.println("-------------------- p656 HashSet Iterator");
        exam.hashSetIteratorExample();
        System.out.println("-------------------- p660 HashMap");
        exam.hashMapExample();
    }
}