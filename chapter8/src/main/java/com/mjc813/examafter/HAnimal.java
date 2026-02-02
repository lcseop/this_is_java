package com.mjc813.examafter;

public interface HAnimal {
    String category = "동물";
    void eat();

    default void produce() {
        System.out.println(category + "입니다.");
    }
}
