package com.mjc813.chapter07;

import lombok.Data;
import java.util.*;

@Data
public class Student {
    private String name;
    private String ssn;
    private ArrayList<ClassStudy> studySubject = new ArrayList<ClassStudy>();

    public Student(String name, String ssn) {
        this.setName(name);
        this.setSsn(ssn);
    }

    // 수강신청
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

    // 과목 목록
    public void getClasses() {
        System.out.println("-----현재 " + name + "이(가) 신청중인 과목들------");
        for (int i = 0; i < this.getStudySubject().toArray().length; i++) {
            String print = this.getStudySubject().get(i).getClassName() + ": " + this.getStudySubject().get(i).getScore() + "점";
            if (this.getStudySubject().get(i).isClose()) {
                print += " [" + this.getStudySubject().get(i).getGrade() + "]";
            }
            System.out.println(print);
        }
        System.out.println("---------------------------------------");
    }

    // 과목 버리기
    public void classRemove(ClassStudy cls) {
        for (int i = 0; i < this.getStudySubject().toArray().length; i++) {
            if (this.getStudySubject().get(i) == cls) {
                if (!(this.getStudySubject().get(i).isClose())) {
                    System.out.println(this.getStudySubject().get(i).getClassName() + "의 과목을 버렸습니다.");
                    this.getStudySubject().remove(i);
                    return;
                }
                else {
                    System.out.println(this.getStudySubject().get(i).getClassName() + " 과목은 이미 닫혀 버릴 수 없습니다.");
                }
            }
        }
        System.out.println(cls.getClassName() + " 과목을 신청하고 있지 않습니다.");
    }

    // 출석 점수 부여
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

    // 중간고사 점수 부여
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

    // 기말고사 점수 부여
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

    // 학기 종료
    public void finishClass(ClassStudy cls) {
        for (int i = 0; i < this.getStudySubject().toArray().length; i++) {
            if (this.getStudySubject().get(i) == cls) {
                if (!(this.getStudySubject().get(i).isClose())) {
                    this.getStudySubject().get(i).closeClass();
                    System.out.println(this.getStudySubject().get(i).getClassName() + " 과목이 마무리 되었습니다.");
                    System.out.println(this.getName() + "의 최종 점수 : " + this.getStudySubject().get(i).getScore() + " [" + this.getStudySubject().get(i).getGrade() + "]");
                    return; }
                else {
                    System.out.println(this.getStudySubject().get(i).getClassName() + " 과목은 이미 닫혔습니다.");
                    System.out.println(this.getStudySubject().get(i).getClassName() + "의 점수 : " + this.getStudySubject().get(i).getScore() + " [" + this.getStudySubject().get(i).getGrade() + "]");
                    return;
                }
            }
        }
        System.out.println(cls.getClassName() + " 과목을 신청하고 있지 않습니다.");
    }


}
