package com.mjc813.chapter07;

public class Main {
    public static void main(String[] args) {
        SmartPhone myPhone = new SmartPhone("갤럭시", "은색");

        System.out.println("모델: " + myPhone.getModel());
        System.out.println("색상: " + myPhone.getColor());

        System.out.println("와이파이 상태: " + myPhone.isWifi());

        myPhone.bell();
        myPhone.sendVoice("여보세요");
        myPhone.receiveVoice("안녕하세요! 저는 홍길동인데요.");
        myPhone.sendVoice("아~ 네, 반갑습니다.");
        myPhone.hangUp();

        myPhone.setWifi(true);
        myPhone.internet();

        System.out.println("------------------------- p.296 메소드 오버라이딩");
        int r = 10;

        Calculator calculator = new Calculator();
        System.out.println("원 면적: " + calculator.areaCircle(r));
        System.out.println();

        Computer computer = new Computer();
        System.out.println("원 면적: " + computer.areaCircle(r));

        System.out.println("------------------------- p.298 부모 메소드 호출");
        SupersonicAirplane sa = new SupersonicAirplane();
        sa.takeOff();
        sa.fly();
        sa.setFlyMode(SupersonicAirplane.SUPERSONIC);
        sa.fly();
        sa.setFlyMode(SupersonicAirplane.NORMAL);
        sa.fly();
        sa.land();

        System.out.println("------------------------- p.309 자동 타입 변환 (자식 -> 부모)");
        inherB b = new inherB();
        inherC c = new inherC();
        inherD d = new inherD();
        inherE e = new inherE();

        inherA a1 = b;
        inherA a2 = c;
        inherA a3 = d;
        inherA a4 = e;

        inherB b1 = d;
        inherC c1 = c;

//      todo) 컴파일 에러 (상속 관계 x)
//      inherB b3 = e;
//      inherC c2 = d;

        System.out.println("------------------------- p.311 자동 타입 변환 (자식 -> 부모)");
        Child child = new Child();

        Parent parent = child;

        parent.method1();
        parent.method2();
//      parent.method3(); (호출 불가능)
    }
}