package com.mjc813.examafter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class HNurse {
    private Hospital hospital;
    private String name;

    public void feedDrug(String name, String id) {
        for (int i = 0; i < hospital.getPatients().toArray().length; i++) {
            if (name.equals(hospital.getPatients().get(i).getName()) && id.equals(hospital.getPatients().get(i).getId())) {
                if (hospital.getPatients().get(i).getFeed() < 3) {
                    hospital.getPatients().get(i).setFeed(hospital.getPatients().get(i).getFeed() + 1);
                    System.out.println("간호사 " + this.getName() + "이(가) " + hospital.getPatients().get(i).getType() + " " + hospital.getPatients().get(i).getName() + "에게 약을 먹였습니다.");
                    System.out.println("오늘 약 먹은 횟수 : " + hospital.getPatients().get(i).getFeed() + " / 3");
                    return;
                } else {
                    System.out.println(hospital.getPatients().get(i).getName() + "은 이미 오늘 약을 3번 먹었습니다.");
                    return;
                }
            }
        }
        System.out.println(name + " (" + id + ")은(는) 찾을 수 없는 환자입니다.");
    }

    public void feedFood(String name, String id, int gram) {
        for (int i = 0; i < hospital.getPatients().toArray().length; i++) {
            if (name.equals(hospital.getPatients().get(i).getName()) && id.equals(hospital.getPatients().get(i).getId())) {
                    System.out.println("간호사 " + this.getName() + "이(가) " + hospital.getPatients().get(i).getType() + " " + hospital.getPatients().get(i).getName() + "에게 사료를 " + gram + "g 먹였습니다.");
                    hospital.getPatients().get(i).eat();
                    hospital.getPatients().get(i).saveFeedData(gram);
                    return;
            }
        }
        System.out.println(name + " (" + id + ")은(는) 찾을 수 없는 환자입니다.");
    }
}
