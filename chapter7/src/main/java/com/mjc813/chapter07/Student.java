package com.mjc813.chapter07;

import lombok.Getter;
import lombok.Setter;
import java.util.*;

@Getter
@Setter
public class Student {
    private String name;
    private String ssn;
    private ArrayList<ClassStudy> studySubject = new ArrayList<ClassStudy>();

    public Student(String name, String ssn) {
        this.setName(name);
        this.setSsn(ssn);
    }

    public void classRegistration(ClassStudy cls) {
        for (int i = 0; i < this.getStudySubject().toArray().length; i++) {
            if (this.getStudySubject().get(i) == cls) {
                System.out.println(cls.getClassName() + " 과목은 이미 수강신청하였습니다.");
                return;
            }
        }
        this.getStudySubject().add(cls);
        System.out.println(cls.getClassName() + "의 수강 신청이 완료되었습니다.");
    }

    public void getClasses() {
        System.out.println("-----현재 " + name + "이(가) 신청중인 과목들------");
        for (int i = 0; i < this.getStudySubject().toArray().length; i++) {
            System.out.println(this.getStudySubject().get(i).getClassName() + ": " + this.getStudySubject().get(i).getScore() + "점");
        }
        System.out.println("---------------------------------------");
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
                if (!(this.getStudySubject().get(i).isClose())) {
                    this.getStudySubject().get(i).setScore(this.getStudySubject().get(i).getScore() + 5);
                    System.out.println(this.getStudySubject().get(i).getClassName() + "에 출석하여 5점을 획득했습니다.");
                    System.out.println("현재 점수 : " + this.getStudySubject().get(i).getScore());
                    return;
                } else {
                    System.out.println(this.getStudySubject().get(i).getClassName() + " 과목은 이미 닫힌 상태입니다.");
                }
            }
        }
        System.out.println(cls.getClassName() + " 과목을 신청하고 있지 않습니다.");
    }

    public void mintermExamClass(ClassStudy cls, int score) {
        for (int i = 0; i < this.getStudySubject().toArray().length; i++) {
            if (this.getStudySubject().get(i) == cls) {
                if (!(this.getStudySubject().get(i).isMintermExam()) && !(this.getStudySubject().get(i).isClose())) {
                    this.getStudySubject().get(i).setMintermExam(true);
                    this.getStudySubject().get(i).setScore(this.getStudySubject().get(i).getScore() + score);
                    System.out.println(this.getStudySubject().get(i).getClassName() + "의 중간고사에서 " + score + "점을 획득했습니다.");
                    System.out.println("현재 점수 : " + this.getStudySubject().get(i).getScore());
                    return;
                }
                else {
                    System.out.println(this.getStudySubject().get(i).getClassName() + " 과목은 이미 중간고사를 마쳤거나 닫힌 상태입니다.");
                    return;
                }
            }
        }
        System.out.println(cls.getClassName() + " 과목을 신청하고 있지 않습니다.");
    }

    public void finalExamClass(ClassStudy cls, int score) {
        for (int i = 0; i < this.getStudySubject().toArray().length; i++) {
            if (this.getStudySubject().get(i) == cls) {
                if (!(this.getStudySubject().get(i).isFinalExam()) && !(this.getStudySubject().get(i).isClose())) {
                    this.getStudySubject().get(i).setFinalExam(true);
                    this.getStudySubject().get(i).setScore(this.getStudySubject().get(i).getScore() + score);
                    System.out.println(this.getStudySubject().get(i).getClassName() + "의 기말고사에서 " + score + "점을 획득했습니다.");
                    System.out.println("현재 점수 : " + this.getStudySubject().get(i).getScore());
                    return; }
                else {
                    System.out.println(this.getStudySubject().get(i).getClassName() + " 과목은 이미 기말고사를 마쳤거나 닫힌 상태입니다.");
                    return;
                }
            }
        }
        System.out.println(cls.getClassName() + " 과목을 신청하고 있지 않습니다.");
    }

    public void finishClass(ClassStudy cls) {
        for (int i = 0; i < this.getStudySubject().toArray().length; i++) {
            if (this.getStudySubject().get(i) == cls) {
                if (!(this.getStudySubject().get(i).isClose())) {
                    this.getStudySubject().get(i).setClose(true);
                    System.out.println(this.getStudySubject().get(i).getClassName() + " 과목이 마무리 되었습니다.");
                    System.out.println(this.getName() + "의 최종 점수 : " + this.getStudySubject().get(i).getScore());
                    return; }
                else {
                    System.out.println(this.getStudySubject().get(i).getClassName() + " 과목은 이미 닫혔습니다.");
                    System.out.println(this.getStudySubject().get(i).getClassName() + "의 점수 : " + this.getStudySubject().get(i).getScore());
                    return;
                }
            }
        }
        System.out.println(cls.getClassName() + " 과목을 신청하고 있지 않습니다.");
    }


}
