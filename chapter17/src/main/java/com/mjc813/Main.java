package com.mjc813;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Example example = new Example();

        System.out.println("----------------p725 스트림");
        example.streamExample();
        System.out.println("----------------p727 병렬 처리 스트림");
        example.parallelStreamExample();
    }
}