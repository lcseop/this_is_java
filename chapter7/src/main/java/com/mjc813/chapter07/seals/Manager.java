package com.mjc813.chapter07.seals;

public non-sealed class Manager extends Person2 {
    @Override
    public void work() {
        System.out.println("생산 관리를 합니다.");
    }
}
