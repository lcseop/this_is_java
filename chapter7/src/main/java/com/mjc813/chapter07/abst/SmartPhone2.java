package com.mjc813.chapter07.abst;

public class SmartPhone2 extends Phone2 {
    public SmartPhone2(String owner) {
        super(owner);
    }

    public void internetSearch() {
        System.out.println("인터넷 검색을 합니다.");
    }
}
