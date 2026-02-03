package com.mjc813.examafter;

import lombok.*;

import java.util.ArrayList;

@Getter
@Setter
public class Hospital {
    private ArrayList<HPatient> patients = new ArrayList<HPatient>();
    private ArrayList<HNurse> nurses = new ArrayList<HNurse>();
    private ArrayList<HDoctor> doctors = new ArrayList<HDoctor>();
    public static int nowDay = 1;
    public static int time;

    public static void setTime(Hospital hospital, int time) {
        for (int i = 0; i < hospital.getPatients().toArray().length; i++) {
            hospital.getPatients().get(i).setFeed(0);
            hospital.getPatients().get(i).setVisit(0);
        }
        Hospital.time = time;
        System.out.println("-------------- 하루가 흘렀습니다. : " + ++Hospital.nowDay + "일차 " + Hospital.time + "시");
    }

    public void viewPatients() {
        ArrayList<HPatient> mammalias = new ArrayList<HPatient>();
        ArrayList<HPatient> insectivora = new ArrayList<HPatient>();
        ArrayList<HPatient> birds = new ArrayList<HPatient>();

        for (int i = 0; i < this.getPatients().toArray().length; i++) {
            switch(this.getPatients().get(i).getCategory()) {
                case "포유류" :
                    mammalias.add(this.getPatients().get(i));
                    break;
                case "조류" :
                    birds.add(this.getPatients().get(i));
                    break;
                case "식충목" :
                    insectivora.add(this.getPatients().get(i));
                    break;
            }
        }
        System.out.println("\n--------------- 병실 현황 ---------------");

        System.out.println("\n---------- 포유류 병실 ----------");
        for (int i = 0; i < mammalias.toArray().length; i++) {
            System.out.println(mammalias.get(i).getType() + " " + mammalias.get(i).getName());
        }

        System.out.println("---------- 조류 병실 ----------");
        for (int i = 0; i < birds.toArray().length; i++) {
            System.out.println(birds.get(i).getType() + " " + birds.get(i).getName());
        }

        System.out.println("---------- 식충목 병실 ----------");
        for (int i = 0; i < insectivora.toArray().length; i++) {
            System.out.println(insectivora.get(i).getType() + " " + insectivora.get(i).getName());
        }

        System.out.println("\n---------------------------------------");
    }
}
