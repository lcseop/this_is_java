package com.mjc813.chapter07;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClassStudy {
    private String className;
    private int score = 0;
    private String grade = "미수료";
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

    public void closeClass() {
        this.setClose(true);
        if (score >= 95) {
            this.setGrade("A+");
        } else if (score >= 90) {
            this.setGrade("A0");
        } else if (score >= 87) {
            this.setGrade("A-");
        } else if (score >= 85) {
            this.setGrade("B+");
        } else if (score >= 82) {
            this.setGrade("B0");
        } else if (score >= 80) {
            this.setGrade("B-");
        } else if (score >= 77) {
            this.setGrade("C+");
        } else if (score >= 75) {
            this.setGrade("C0");
        } else if (score >= 72) {
            this.setGrade("C-");
        } else if (score >= 70) {
            this.setGrade("D+");
        } else if (score >= 67) {
            this.setGrade("D0");
        } else if (score >= 65) {
            this.setGrade("D-");
        } else {
            this.setGrade("F");
        }
    }

    public void setScore(int score) {
        this.score = score;
        this.isScoreRange();
    }
}
