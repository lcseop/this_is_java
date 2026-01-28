package com.mjc813.chapter07.seals;

public class Director extends Manager {
    @Override
    public void work() {
        System.out.println("제품을 기획합니다.");
    }
}
