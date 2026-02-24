package com.mjc813;

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
}
