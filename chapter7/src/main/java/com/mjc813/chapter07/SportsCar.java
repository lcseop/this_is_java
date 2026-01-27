package com.mjc813.chapter07;

public class SportsCar extends Car {
    @Override
    public void speedUp() {
        this.setSpeed(this.getSpeed() + 10);
    }

//    todo) final 메소드는 상속 불가
//    @Override
//    public void stop() {
//        System.out.println("스포츠카를 멈춤");
//        this.setSpeed(0);
//    }

}
