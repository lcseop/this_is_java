package com.mjc813.examafter;

import lombok.*;

import java.util.ArrayList;

@Getter
@Setter
public class Hospital {
    private ArrayList<HPatient> parents = new ArrayList<HPatient>();
    private ArrayList<HNurse> nurses = new ArrayList<HNurse>();
    private ArrayList<HDoctor> doctors = new ArrayList<HDoctor>();
    private int time;

}
