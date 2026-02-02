package com.mjc813.examafter;

import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;

@Getter
@Setter
public abstract class HPatient implements HAnimal {
    private String name;
    private String id = "0";
    private HDoctor doctor;
    private LocalDate inDate;
    private LocalDate outDate;
    private HHuman master;
    private int feed;
    private int visit;
    private String type;
    private String category = "동물";
    private ArrayList<String> feedHistory = new ArrayList<String>();

    public void saveFeedData(int feedGram) {
        feedHistory.add(Hospital.nowDay + "일차 " + Hospital.time + "시 사료 " + feedGram + "g 섭취");
    }

    public void viewFeedData() {
        if (this.getFeedHistory().toArray().length != 0) {
            System.out.println("-----------" + this.getType() + " " + this.getName() + "의 사료 섭취 기록" + "-----------");
            for (int i = 0; i < this.getFeedHistory().toArray().length; i++) {
                System.out.println(this.getFeedHistory().get(i));
            }
            System.out.println("---------------------------------------------");
        } else {
            System.out.println(this.getType() + " " + this.getName() + "은 사료를 먹은 적이 없습니다.");
        }
    }
}
