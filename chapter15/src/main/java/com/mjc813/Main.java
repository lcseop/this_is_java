package com.mjc813;

public class Main {
    public static void main(String[] args) throws Exception {
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
        System.out.println("-------------------- p663 HashTable");
        exam.hashTableExample();
        System.out.println("-------------------- p665 Properties");
        exam.propertiesExample();
        System.out.println("-------------------- p668 TreeSet");
        exam.treeSetExample();
        System.out.println("-------------------- p672 TreeMap");
        exam.treeMapExample();
        System.out.println("-------------------- p675 Comparable");
        exam.comparableExample();
        System.out.println("-------------------- p677 Comparator");
        exam.comparatorExample();
        System.out.println("-------------------- p679 Stack");
        exam.stackExample();
        System.out.println("-------------------- p681 Queue");
        exam.queueExample();
        System.out.println("-------------------- p684 동기화된 컬렉션");
        exam.synchronizedMapExample();
        System.out.println("-------------------- p687 수정할 수 없는 컬렉션");
        exam.immutableExample();
    }
}