package com.mjc813.examafter;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
public class HHuman {
    private String name;

    public void visitPet(Hospital hospital, String name, String id) {
        for (int i = 0; i < hospital.getParents().toArray().length; i++) {
            if (name.equals(hospital.getParents().get(i).getName()) && id.equals(hospital.getParents().get(i).getId())) {
                if (hospital.getParents().get(i).getMaster() != this) {
                    System.out.println(hospital.getParents().get(i).getName() + "의 주인은 " + this.getName() + "이 아니므로 만날 수 없습니다.");
                    return;
                }
                if (hospital.getParents().get(i).getVisit() >= 1) {
                    System.out.println(hospital.getParents().get(i).getName() + "은 이미 오늘 만났습니다.");
                    return;
                }
                if (Hospital.time < 15 || Hospital.time > 20) {
                    System.out.println("현재 15시 ~ 20시 사이가 아닙니다.");
                    return;
                }
                hospital.getParents().get(i).setVisit(hospital.getParents().get(i).getVisit() + 1);
                System.out.println(this.getName() + "의 애완동물 환자 " + hospital.getParents().get(i).getName() + "와 면회했습니다.");
                System.out.println("오늘 면회 횟수 : " + hospital.getParents().get(i).getFeed() + " / 1");
                return;
            }
        }
        System.out.println(name + " (" + id + ")은(는) 찾을 수 없는 환자입니다.");
    }
}
