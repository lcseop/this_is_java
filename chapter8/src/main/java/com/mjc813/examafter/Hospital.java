package com.mjc813.examafter;

import lombok.*;

import java.util.ArrayList;

@Getter
@Setter
public class Hospital {
    private ArrayList<HPatient> parents = new ArrayList<HPatient>();
    private ArrayList<HNurse> nurses = new ArrayList<HNurse>();
    private ArrayList<HDoctor> doctors = new ArrayList<HDoctor>();
    public static int time;

    public static void setTime(Hospital hospital, int time) {
        for (int i = 0; i < hospital.getParents().toArray().length; i++) {
            hospital.getParents().get(i).setFeed(0);
            hospital.getParents().get(i).setVisit(0);
        }
        Hospital.time = time;
        System.out.println("-------------- 하루가 흘렀습니다. 현재 시각 : " + Hospital.time + "시");
    }
}
