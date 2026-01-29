package com.mjc813;

import com.mjc813.exam1.*;
import com.mjc813.fieldpoly.*;
import com.mjc813.implinhe.*;
import com.mjc813.multiimpl.*;
import com.mjc813.promotion.*;
import com.mjc813.argspoly.*;
import com.mjc813.instance.*;
import com.mjc813.seal.*;

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
    }
    public static void ride(IVehicle vehicle) {
        if (vehicle instanceof IBus bus) {
            bus.checkFare();
        }
        vehicle.run();
    }
}