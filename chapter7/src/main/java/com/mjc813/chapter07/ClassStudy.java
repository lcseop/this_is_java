package com.mjc813.chapter07;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class ClassStudy {
    private String className;
    private int score = 0;
    private boolean mintermExam = false;
    private boolean finalExam = false;
    private boolean close = false;

    public ClassStudy(String className) {
        this.setClassName(className);
    }

    public void isScoreRange() {
        if (this.getScore() < 0) {
            this.setScore(0);
        } else if (this.getScore() > 100) {
            this.setScore(100);
        }
    }
}
