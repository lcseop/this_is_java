package com.mjc813.examafter;

import java.time.LocalDate;

public class AnimalHospital {
    public void lifeOfHospital() {
        Hospital hospital = new Hospital();
        HDoctor doctor1 = new HDoctor("김의사");
        HNurse nurse1 = new HNurse(hospital, "김간호");
        HHuman human1 = new HHuman("김주인");
        HHuman human2 = new HHuman("이주인");
        HPatient rabbit1 = new HRabbit("김토끼", "1", doctor1, LocalDate.of(2026,1,1), LocalDate.of(1900, 1, 1), human1);
        HPatient dog1 = new HSmallDog("멍멍이", "2", doctor1, LocalDate.of(2026,1,2), LocalDate.of(1900, 1, 1), human2);
        HPatient parrot1 = new HParrot("앵무", "pa1", doctor1, LocalDate.of(2026,2,25), LocalDate.of(2026, 3, 1), human1);
        HPatient cat1 = new HCat("냥냥이", "3", doctor1, LocalDate.of(2025,12,25), LocalDate.of(2026, 2, 28), human2);
        hospital.getDoctors().add(doctor1);
        hospital.getNurses().add(nurse1);
        hospital.getPatients().add(rabbit1);
        hospital.getPatients().add(dog1);
        hospital.getPatients().add(parrot1);
        hospital.getPatients().add(cat1);

        Hospital.setTime(hospital, 15);

        nurse1.feedDrug("김토끼", "1");
        nurse1.feedDrug("멍멍이", "1");
        nurse1.feedDrug("멍멍이", "2");

        human1.visitPet(hospital, "멍멍이", "2");
        human1.visitPet(hospital, "김토끼", "1");
        human2.visitPet(hospital ,"멍멍이", "2");

        Hospital.setTime(hospital, 21);
        human2.visitPet(hospital ,"멍멍이", "2");
        human1.visitPet(hospital, "김토끼", "1");
        nurse1.feedDrug("김토끼", "1");
        nurse1.feedDrug("김토끼", "1");
        nurse1.feedDrug("김토끼", "1");

        nurse1.feedFood("김토끼", "1", 50);
        nurse1.feedFood("멍멍이", "2", 75);

        Hospital.setTime(hospital, 15);

        nurse1.feedFood("김토끼", "1", 65);

        rabbit1.viewFeedData();

        Hospital.setTime(hospital, 21);

        HDoctor doctor2 = new HDoctor("김닥터");
        HHuman human3 = new HHuman("박주인");
        HPatient hedge1 = new HHedgehog("도치", "4", doctor2, LocalDate.of(2026,2,1), LocalDate.of(1900, 1, 1), human3);
        HPatient chicken1 = new HChicken("치킨", "5", doctor2, LocalDate.of(2026,2,2), LocalDate.of(2026, 2, 10), human3);

        hospital.getDoctors().add(doctor2);
        hospital.getPatients().add(hedge1);
        hospital.getPatients().add(chicken1);


        nurse1.feedFood("도치", "4", 10);
        nurse1.feedFood("치킨", "5", 20);

        nurse1.feedDrug("도치", "4");
        nurse1.feedDrug("도치", "4");

        Hospital.setTime(hospital, 16);

        human3.visitPet(hospital, "도치", "4");
        human3.visitPet(hospital, "치킨", "5");
        human3.visitPet(hospital, "도치", "4");

        nurse1.feedFood("도치", "4", 20);
        nurse1.feedFood("치킨", "5", 30);

        nurse1.feedDrug("도치", "4");

        hedge1.viewFeedData();
        chicken1.viewFeedData();

        nurse1.feedFood("김토끼", "1", 50);
        nurse1.feedFood("멍멍이", "2", 75);

        rabbit1.viewFeedData();
        dog1.viewFeedData();

        hospital.viewPatients();
    }
}
