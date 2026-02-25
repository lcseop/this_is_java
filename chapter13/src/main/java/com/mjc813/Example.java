package com.mjc813;

import com.mjc813.exam.*;
import static com.mjc813.exam.Grade.*;

public class Example {
    public void objectToGeneric() {
        Human human1 = new Human();
        Human human2 = new Human();

        human1.setName("홍길동");
        human1.setAge(20);
        human2.setName("김길동");
        human2.setAge(25);

        Packaging packString = new Packaging();
        packString.add("pack 테스트1");
        packString.add("pack 테스트2");
        packString.add("pack 테스트3");
        System.out.println(packString.remove());
        System.out.println(packString.remove());
        System.out.println(packString.remove());

        Packaging packHuman = new Packaging();
        packHuman.add(human1);
        packHuman.add(human2);
        System.out.println(packHuman.remove());
        System.out.println(packHuman.remove());



        GenericPackaging<String> gPackString = new GenericPackaging<String>();
        gPackString.add("generic 테스트1");
        gPackString.add("generic 테스트2");
        gPackString.add("generic 테스트3");
        System.out.println(gPackString.remove());
        System.out.println(gPackString.remove());
        System.out.println(gPackString.remove());

        GenericPackaging<Human> gPackHuman = new GenericPackaging<Human>();
        gPackHuman.add(human1);
        gPackHuman.add(human2);
        System.out.println(gPackHuman.remove().getName());
        System.out.println(gPackHuman.remove().getAge());
    }

    public void genericExample() {
        Product<Tv, String> product1 = new Product<>();

        product1.setKind(new Tv());
        product1.setModel("스마트TV");

        Tv tv = product1.getKind();
        String tvModel = product1.getModel();

        Product<Car, String> product2 = new Product<>();

        product2.setKind(new Car());
        product2.setModel("SUV자동차");

        Car car = product2.getKind();
        String carModel = product2.getModel();

        System.out.println(tv + " : " + tvModel);
        System.out.println(car + " : " + carModel);
    }
    public void genericInterfaceExample() {
        HomeAgency homeAgency = new HomeAgency();
        Home home = homeAgency.rent();
        home.turnOnLight();

        CarAgency carAgency = new CarAgency();
        Car car = carAgency.rent();
        car.run();
    }
    public void genericEqualsExample() {
        Box<String> box1 = new Box<>();
        box1.content = "100";

        Box<String> box2 = new Box<>();
        box2.content = "100";

        boolean result = box1.compare(box2);
        System.out.println("result: " + result);
    }
    public void nintendoCRUDExample() {
        NintendoGame mk = new NintendoGame("마리오카트", ALL, 69000);
        NintendoGame zl = new NintendoGame("젤다의전설", AGE12_OVER, 89000);
        NintendoGame mg = new NintendoGame("마리오골프", AGE15_OVER, 29000);
        NintendoGame wg = new NintendoGame("수박게임", ALL, 7000);
        NintendoGame mr = new NintendoGame("마리오", AGE12_OVER, 89000);

        NintendoGameService<NintendoGame> ngs = new NintendoGameService<NintendoGame>();
        ngs.add(mk);
        ngs.add(zl);
        System.out.println("닌텐도 게임 목록 사이즈 : " + ngs.size());
        ngs.add(mg);
        System.out.println("닌텐도 게임 목록 사이즈 : " + ngs.size());

        System.out.println("수박게임을 인덱스 1에 넣음 : " + ngs.set(1, wg));
        System.out.println("마리오를 인덱스 0에 넣음 : " + ngs.set(0, mr));
        System.out.println("인덱스 2에 있는 수박게임을 제거함 : " + ngs.remove(2));
        System.out.println("인덱스 3에 있는 마리오골프를 가져옴 : " + ngs.get(3));

        System.out.println("-----2번 인덱스 JSON 추출 \n" + ngs.getJson(2));
        System.out.println("-----모든 게임 목록 JSON 추출 \n" + ngs.getJsonAllItems());

    }

    public void containerExample() {
        Container<String> container1 = new Container<String>();
        container1.set("홍길동");
        String str = container1.get();

        Container<Integer> container2 = new Container<Integer>();
        container2.set(6);
        int value = container2.get();

        System.out.println(str + ", " + value);
    }

    public void containerMultiExample() {
        Container2<String, String> container1 = new Container2<String, String>();
        container1.set("홍길동", "도적");
        String name1 = container1.getKey();
        String job = container1.getValue();

        Container2<String, Integer> container2 = new Container2<String, Integer>();
        container2.set("홍길동", 35);
        String name2 = container2.getKey();
        int age = container2.getValue();

        System.out.println(name1 + ": " + job);
        System.out.println(name2 + ": " + age);
    }

    public void utilExample() {
        Pair<String, Integer> pair = new Pair<>("홍길동", 35);
        Integer age = Util.getValue(pair, "홍길동");
        System.out.println(age);

        ChildPair<String, Integer> childPair = new ChildPair<>("홍삼원", 20);
        Integer childAge = Util.getValue(childPair, "홍삼순");
        System.out.println(childAge);

//        OtherPair<String, Integer> otherPair = new OtherPair<>("홍삼원", 20);
//        int otherAge = Util.getValue(otherPair, "홍삼원");
//        System.out.println(otherAge);

    }

    public void genericMethodExample() {
        BoxM<Integer> box1 = boxing(100);
        int intValue = box1.get();
        System.out.println(intValue);

        BoxM<String> box2 = boxing("홍길동");
        String strValue = box2.get();
        System.out.println(strValue);
    }

    public <T> BoxM<T> boxing(T t) {
        BoxM<T> box = new BoxM<T>();
        box.set(t);
        return box;
    }

    public <T extends Number> boolean compare(T t1, T t2) {
        System.out.println("compare(" + t1.getClass().getSimpleName() + ", " + t2.getClass().getSimpleName() + ")");
        double v1 = t1.doubleValue();
        double v2 = t2.doubleValue();

        return (v1 == v2);
    }

    public void genericExtendsExample() {
        boolean result1 = compare(10, 20);
        System.out.println(result1);
        System.out.println();

        boolean result2 = compare(4.5, 4.5);
        System.out.println(result2);
    }

    public void genericWildCardExample() {
        Course.registerCourse1(new Applicant<Person>(new Person()));
        Course.registerCourse1(new Applicant<Worker>(new Worker()));
        Course.registerCourse1(new Applicant<Student>(new Student()));
        Course.registerCourse1(new Applicant<HighStudent>(new HighStudent()));
        Course.registerCourse1(new Applicant<MiddleStudent>(new MiddleStudent()));
        System.out.println();


//        Course.registerCourse2(new Applicant<Person>(new Person()));
//        Course.registerCourse2(new Applicant<Worker>(new Worker()));
        Course.registerCourse2(new Applicant<Student>(new Student()));
        Course.registerCourse2(new Applicant<HighStudent>(new HighStudent()));
        Course.registerCourse2(new Applicant<MiddleStudent>(new MiddleStudent()));
        System.out.println();


        Course.registerCourse3(new Applicant<Person>(new Person()));
        Course.registerCourse3(new Applicant<Worker>(new Worker()));
//        Course.registerCourse3(new Applicant<Student>(new Student()));
//        Course.registerCourse3(new Applicant<HighStudent>(new HighStudent()));
//        Course.registerCourse3(new Applicant<MiddleStudent>(new MiddleStudent()));
        System.out.println();
    }
}
