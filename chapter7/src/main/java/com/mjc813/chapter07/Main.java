package com.mjc813.chapter07;

import com.mjc813.chapter07.abst.*;
import com.mjc813.chapter07.inst.*;
import com.mjc813.chapter07.poly.*;
import com.mjc813.chapter07.seals.*;
import com.mjc813.chapter07.typeChange.*;

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

        System.out.println("------------------------- 개인과제4");
        Student stu1 = new Student("성이름", "111-1111");

        ClassStudy clsMath = new ClassStudy("수학");
        ClassStudy clsEng = new ClassStudy("영어");
        ClassStudy clsKor = new ClassStudy("국어");

        stu1.classRegistration(clsMath);

        stu1.getClasses();

        stu1.classRegistration(clsEng);
        stu1.classRegistration(clsKor);

        stu1.getClasses();

        stu1.attendanceClass(clsMath);
        stu1.attendanceClass(clsMath);
        stu1.attendanceClass(clsMath);
        stu1.mintermExamClass(clsMath, 45);
        stu1.mintermExamClass(clsMath, 35);
        stu1.finalExamClass(clsMath, 15);
        stu1.finishClass(clsMath);

        stu1.getClasses();

        stu1.attendanceClass(clsEng);
        stu1.attendanceClass(clsEng);
        stu1.mintermExamClass(clsEng, 50);
        stu1.finalExamClass(clsEng, 50);
        stu1.finishClass(clsEng);

        stu1.getClasses();

        stu1.attendanceClass(clsKor);
        stu1.mintermExamClass(clsKor, 20);
        stu1.mintermExamClass(clsKor, 30);
        stu1.finishClass(clsKor);
        stu1.finalExamClass(clsKor, 40);

        stu1.getClasses();

        System.out.println("------------------------- p.313 강제 타입 변환");
        Parent2 parent2 = new Child2();

        parent2.setField1("data1");
        parent2.method1();
        parent2.method2();

        Child2 child2 = (Child2) parent2;

        child2.setField2("data2");
        child2.method3();

        System.out.println("------------------------- p.317 다형성");
        TireCar myCar = new TireCar();

        myCar.setTire(new Tire());
        myCar.run();

        myCar.setTire(new HankookTire());
        myCar.run();

        myCar.setTire(new KumhoTire());
        myCar.run();

        System.out.println("------------------------- p.320 매개변수 다형성");
        Driver driver = new Driver();

        Bus bus = new Bus();
        driver.drive(bus);

        Taxi taxi = new Taxi();
        driver.drive(taxi);

        System.out.println("------------------------- p.323 객체 타입 확인");
        Person p1 = new Person("홍길동");
        personInfo(p1);

        Person p2 = new Student2("김길동", 10);
        personInfo(p2);

        System.out.println("------------------------- p.327 추상 클래스 선언");
        SmartPhone2 smartPhone = new SmartPhone2("홍길동");

        smartPhone.turnOn();
        smartPhone.internetSearch();
        smartPhone.turnOff();

        Dog dog = new Dog();
        dog.sound();

        Cat cat = new Cat();
        cat.sound();

        animalSound(dog);
        animalSound(cat);

        System.out.println("------------------------- p.333 봉인된 클래스");
        Person2 p = new Person2();
        Employee em = new Employee();
        Manager m = new Manager();
        Director di = new Director();

        p.work();
        em.work();
        m.work();
        di.work();

    }

    public static void animalSound(Animal animal) {
        animal.sound();
    }

    public static void personInfo(Person person) {
        System.out.println("name: " + person.getName());
        person.walk();

        if (person instanceof Student2 stu) {
            System.out.println("studentNo: " + stu.getStudentNo());
            stu.study();
        }
    }
}