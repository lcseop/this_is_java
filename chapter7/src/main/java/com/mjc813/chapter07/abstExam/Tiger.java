package com.mjc813.chapter07.abstExam;

public class Tiger extends Animals {

    public Tiger() {
        super("호랑이");
    }

    @Override
    public Animals eat(Animals animal) {
        if ( !(animal.isDeath()) && !(this.isDeath()) ) {
            if (animal instanceof Rabbit) {
                System.out.println(this.getSpecies() + "이(가) " + animal.getSpecies() + "을(를) 잡아먹었습니다.");
                return animal;
            } else {
                System.out.println(animal.getSpecies() + "은(는) " + this.getSpecies() + "의 주식이 아닙니다.");
                return this.getEatTarget();
            }
        } else {
            System.out.println( (animal.isDeath()) ? animal.getSpecies() + "은(는) 이미 죽었습니다." : this.getSpecies() + "은(는) 죽어있는 상태입니다." );
            return this.getEatTarget();
        }
    }

    @Override
    public void breathe() {
        System.out.println("호랑이가 숨을 쉽니다.");
    }
}
