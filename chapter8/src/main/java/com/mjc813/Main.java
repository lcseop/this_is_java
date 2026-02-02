package com.mjc813;

import com.mjc813.exam1.*;
import com.mjc813.fieldpoly.*;
import com.mjc813.implinhe.*;
import com.mjc813.multiimpl.*;
import com.mjc813.promotion.*;
import com.mjc813.argspoly.*;
import com.mjc813.instance.*;
import com.mjc813.seal.*;
import com.mjc813.exam5.*;
import com.mjc813.exam6.*;
import com.mjc813.exam7.*;
import com.mjc813.exam8.*;
import com.mjc813.examafter.*;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        ClassA clsA = new ClassA();
        Human m813 = new Mjc813Student();
        m813.study();

        System.out.println("------------------------p.346 변수 선언과 구현 객체 대입");
        RemoteControl rc;
        rc = new Television();
        rc.turnOn();

        rc = new Audio();
        rc.turnOn();

        System.out.println("------------------------p.349 상수 필드");
        System.out.println("리모콘 최대 볼륨 : " + RemoteControl.MAX_VOLUME);
        System.out.println("리모콘 최소 볼륨 : " + RemoteControl.MIN_VOLUME);

        System.out.println("------------------------p.354 추상 메소드");
        rc = new Television();
        rc.turnOn();
        rc.setVolume(5);
        rc.turnOff();

        rc = new Audio();
        rc.turnOn();
        rc.setVolume(5);
        rc.turnOff();

        System.out.println("------------------------p.356 default 메소드, p.360 정적 메소드");
        rc = new Television();
        rc.turnOn();
        rc.setVolume(5);

        rc.setMute(true);
        rc.setMute(false);

        System.out.println();

        rc = new Audio();
        rc.turnOn();
        rc.setVolume(5);

        rc.setMute(true);
        rc.setMute(false);

        System.out.println();

        RemoteControl.changeBattery();

        System.out.println("------------------------p.363 private 메소드");
        Service service = new ServiceImpl();

        service.defaultMethod1();
        System.out.println();
        service.defaultMethod2();
        System.out.println();

        Service.staticMethod1();
        System.out.println();
        Service.staticMethod2();
        System.out.println();

        System.out.println("------------------------p.366 다중 인터페이스 구현");
        RemoteControls rs = new SmartTelevision();
        rs.turnOn();
        rs.turnOff();
        Searchable searchable = new SmartTelevision();
        searchable.search("https://www.youtube.com");

        System.out.println("------------------------p.369 인터페이스 상속");
        InterfaceCImpl impl = new InterfaceCImpl();

        InterfaceA ia = impl;
        ia.methodA();
        // ia.methodB();
        System.out.println();

        InterfaceB ib = impl;
        // ib.methodA();
        ib.methodB();
        System.out.println();

        InterfaceC ic = impl;
        ic.methodA();
        ic.methodB();
        ic.methodC();

        System.out.println("------------------------p.372 자동 타입 변환");
        ProB b = new ProB();
        ProC c = new ProC();
        ProD d = new ProD();
        ProE e = new ProE();

        ProA a;

        a = b;
        a = c;
        a = d;
        a = e;

        System.out.println("------------------------p.375 강제 타입 변환");
        Vehicle vehicle = new Bus();

        vehicle.run();
        // vehicle.checkFare();

        Bus bus = (Bus) vehicle;
        bus.run();
        bus.checkFare();

        System.out.println("------------------------p.379 필드의 다형성");
        Car myCar = new Car();

        myCar.run();

        myCar.setTire1(new KumhoTire());
        myCar.setTire2(new KumhoTire());

        myCar.run();

        System.out.println("------------------------p.383 매개변수의 다형성");
        ArgsDriver driver = new ArgsDriver();

        ArgsBus bus2 = new ArgsBus();
        ArgsTaxi taxi2 = new ArgsTaxi();

        driver.drive(bus2);
        driver.drive(taxi2);

        System.out.println("------------------------p.385 객체 타입 확인");
        ITaxi taxi3 = new ITaxi();
        IBus bus3 = new IBus();

        ride(taxi3);
        System.out.println();
        ride(bus3);

        System.out.println("------------------------p.388 봉인된 인터페이스");
        ImplClass implC = new ImplClass();
        SInterfaceA ia2 = implC;
        ia2.methodA();

        System.out.println();

        SInterfaceB ib2 = implC;
        ib2.methodA();
        ib2.methodB();

        System.out.println();

        SInterfaceC ic2 = implC;
        ic2.methodA();
        ic2.methodB();
        ic2.methodC();

        System.out.println("------------------------p.391 5번 문제");
        Remocon r = new TV();
        r.powerOn();

        System.out.println("------------------------p.391 6번 문제");
        printSound(new SCat());
        printSound(new SDog());

        System.out.println("------------------------p.392 7번 문제");
        dbWork(new OracleDao());
        dbWork(new MySqlDao());

        System.out.println("------------------------p.392 8번 문제");
        action(new ExamB());
        action(new ExamC());

        System.out.println("------------------------오후 과제 동물 병원");
        Hospital hospital = new Hospital();
        HDoctor doctor1 = new HDoctor("김의사");
        HNurse nurse1 = new HNurse(hospital, "김간호");
        HHuman human1 = new HHuman("김주인");
        HHuman human2 = new HHuman("이주인");
        HPatient rabbit1 = new HPatient("김토끼", "1", doctor1, LocalDate.of(2026,2,2), LocalDate.of(1900, 1, 1), human1, HAnimalType.토끼);
        HPatient dog1 = new HPatient("멍멍이", "2", doctor1, LocalDate.of(2026,1,2), LocalDate.of(1900, 1, 1), human2, HAnimalType.소형견);
        hospital.getDoctors().add(doctor1);
        hospital.getNurses().add(nurse1);
        hospital.getParents().add(rabbit1);
        hospital.getParents().add(dog1);

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

    }

    public static void ride(IVehicle vehicle) {
        if (vehicle instanceof IBus bus) {
            bus.checkFare();
        }
        vehicle.run();
    }

    public static void printSound(Soundable soundable) {
        System.out.println(soundable.sound());
    }

    public static void dbWork(DataAccessObject dao) {
        dao.select();
        dao.insert();
        dao.update();
        dao.delete();
    }

    public static void action(ExamA a) {
        a.method1();
        if (a instanceof ExamC c) {
            c.method2();
        }
    }
}