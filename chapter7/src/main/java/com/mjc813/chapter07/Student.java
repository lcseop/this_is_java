package com.mjc813.chapter07;

import lombok.Getter;
import lombok.Setter;
import java.util.*;

@Getter
@Setter
public class Student {
    private String name;
    private String ssn;
    private ArrayList<ClassStudy> studySubject;

    public Student(String name, String ssn) {
        this.setName(name);
        this.setSsn(ssn);
    }

    public void classRegistration(ClassStudy cls) {
        this.getStudySubject().add(cls);
        System.out.println(cls.getClassName() + "의 수강 신청이 완료되었습니다.");
    }

    public void getClasses() {
        System.out.println("-----현재 " + name + "이(가) 신청중인 과목들------");
        for (int i = 0; i < this.getStudySubject().toArray().length; i++) {
            System.out.println(this.getStudySubject().get(i) + ": " + this.getStudySubject().get(i).getScore() + "점");
        }
    }

    public void classRemove(ClassStudy cls) {
        for (int i = 0; i < this.getStudySubject().toArray().length; i++) {
            if (this.getStudySubject().get(i) == cls) {
                System.out.println(this.getStudySubject().get(i).getClassName() + "의 과목을 버렸습니다.");
                this.getStudySubject().remove(i);
                return;
            }
        }
        System.out.println("해당 과목을 신청하고 있지 않습니다.");
    }

    public void attendanceClass(ClassStudy cls) {
        for (int i = 0; i < this.getStudySubject().toArray().length; i++) {
            if (this.getStudySubject().get(i) == cls) {
                this.getStudySubject().get(i).setScore(this.getStudySubject().get(i).getScore() + 5);
                System.out.println(this.getStudySubject().get(i).getClassName() + "에 출석하여 5점을 획득했습니다.");
                System.out.println("현재 점수 : " + this.getStudySubject().get(i).getScore());
                return;
            }
        }
        System.out.println("해당 과목을 신청하고 있지 않습니다.");
    }

    public void mintermExamClass(ClassStudy cls, int score) {
        for (int i = 0; i < this.getStudySubject().toArray().length; i++) {
            if (this.getStudySubject().get(i) == cls) {
                this.getStudySubject().get(i).setScore(this.getStudySubject().get(i).getScore() + 5);
                System.out.println(this.getStudySubject().get(i).getClassName() + "에 출석하여 5점을 획득했습니다.");
                System.out.println("현재 점수 : " + this.getStudySubject().get(i).getScore());
                return;
            }
        }
        System.out.println("해당 과목을 신청하고 있지 않습니다.");
    }


}
