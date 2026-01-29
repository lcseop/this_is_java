package com.mjc813.chapter07.abstExam;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Animals {
    private Animals eatTarget = null;
    private String species = "동물";
    private boolean death = false;

    public Animals(String species) {
        this.setSpecies(species);
    }

    public abstract Object eat(Animals animal);
    public abstract void breathe();
    public void poo() {
        if (this.getEatTarget() != null) {
            System.out.println(this.getSpecies() + "이(가) 대변을 누어 " + this.getEatTarget().getSpecies() + "이(가) 완전히 사라집니다.");
            this.setEatTarget(null);
        } else {
            System.out.println(this.getSpecies() + "의 위에는 아무것도 없습니다.");
        }
    }
}
