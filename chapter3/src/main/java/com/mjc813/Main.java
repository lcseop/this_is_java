package com.mjc813;


public class Main {
    public static void main(String[] args) {
        Chapter3 ch3 = new Chapter3();
        System.out.println("2x + 8 = 0의 x는 " + ch3.equationFirst(2, 8) + "입니다.");
        System.out.println("5x - 30 = 0의 x는 " + ch3.equationFirst(5, -30) + "입니다.");
        System.out.println("7x + 49 = 0의 x는 " + ch3.equationFirst(7, 49) + "입니다.");

        ch3.compareOperator();
        ch3.logicalOperator();
        ch3.bitLogic();
        ch3.bitShift();
        ch3.asignmentOperator();
        ch3.conditionalOperation();
        ch3.checkWork();
    }
}