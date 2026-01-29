package com.mjc813.chapter07.abstExam;

public class Swam extends Animals {

    public Swam() {
        super("지렁이");
    }

    @Override
    public Animals eat(Animals animal) {
        System.out.println("지렁이는 동물을 먹을 수 없습니다.");
        return this.getEatTarget();
    }

    @Override
    public void breathe() {
        System.out.println("지렁이가 흙 속에서 호흡을 합니다.");
    }
}
