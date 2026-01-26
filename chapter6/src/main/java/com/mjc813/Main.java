package com.mjc813;

public class Main {
//    int speed;
//
//    void run() {
//        System.out.println(speed + "으로 달립니다.");
//    }
//
//    static void simulate() {
//        Main myCar = new Main();
//        myCar.speed = 200;
//        myCar.run();
//    }

    public static void main(String[] args) {

        double result1 = 10 * 10 * Calculator.pi;
        int result2 = Calculator.plus(10, 5);
        int result3 = Calculator.minus(10, 5);
        System.out.println("result1: " + result1);
        System.out.println("result2: " + result2);
        System.out.println("result3: " + result3);

        System.out.println(Television.info);

//        simulate();
//
//        Main myCar = new Main();
//        myCar.speed = 60;
//        myCar.run();

        Korean2 k1 = new Korean2("123456-1234567", "김자바");

        System.out.println(k1.nation);
        System.out.println(k1.ssn);
        System.out.println(k1.name);

        k1.name = "김자바";

        System.out.println("지구의 반지름 : " + Earth.EARTH_RADIUS + "km");
        System.out.println("지구의 표면적 : " + Earth.EARTH_SURFACE_AREA + "km^2");

        Car myCar_1 = new Car();

        myCar_1.setSpeed(-50);
        System.out.println("현재 속도: " + myCar_1.getSpeed());

        myCar_1.setSpeed(60);
        System.out.println("현재 속도: " + myCar_1.getSpeed());

        if (!myCar_1.isStop()) {
            myCar_1.setStop(true);
        }
        System.out.println("현재 속도: " + myCar_1.getSpeed());

        Singleton obj1 = Singleton.getInstance();
        Singleton obj2 = Singleton.getInstance();

        if (obj1 == obj2) {
            System.out.println("같은 Singleton 객체입니다.");
        } else {
            System.out.println("다른 Singleton 객체입니다.");
        }

//        Chapter06 s1 = new Chapter06("그랜저", "검정", 250);
//        System.out.println("s1 변수가 Chapter06 객체를 참조합니다.");
//
//        Chapter06 s2 = new Chapter06();
//        System.out.println("s2 변수가 또 다른 Chapter06 객체를 참조합니다.");
//
//        System.out.println("제작회사 : " + s1.company);
//        System.out.println("모델명 : " + s1.model);
//        System.out.println("색깔 : " + s1.color);
//        System.out.println("최고속도 : " + s1.maxSpeed);
//        System.out.println("현재속도 : " + s1.speed);
//
//        s1.speed = 60;
//        System.out.println("수정된 속도 : " + s1.speed);
//
//        Korean k1 = new Korean("박자바", "011225-1234567");
//        System.out.println("k1.nation: " + k1.nation);
//        System.out.println("k1.name: " + k1.name);
//        System.out.println("k1.ssn: " + k1.ssn);
//        System.out.println();
//
//        Korean k2 = new Korean("김자바", "930525-0654321");
//        System.out.println("k2.nation: " + k2.nation);
//        System.out.println("k2.name: " + k2.name);
//        System.out.println("k2.ssn: " + k2.ssn);
//        System.out.println();
//
//        Chapter06 car1 = new Chapter06();
//        System.out.println("car1.company: " + car1.company);
//        System.out.println();
//
//        Chapter06 car2 = new Chapter06("자가용");
//        System.out.println("car2.company: " + car2.company);
//        System.out.println("car2.model: " + car2.model);
//        System.out.println();
//
//        Chapter06 car3 = new Chapter06("자가용", "빨강");
//        System.out.println("car3.company: " + car3.company);
//        System.out.println("car3.model: " + car3.model);
//        System.out.println("car3.color: " + car3.color);
//        System.out.println();
//
//        Chapter06 car4 = new Chapter06("택시", "검정", 200);
//        System.out.println("car4.company: " + car4.company);
//        System.out.println("car4.model: " + car4.model);
//        System.out.println("car4.color: " + car4.color);
//        System.out.println("car4.maxSpeed: " + car4.maxSpeed);
//
//        Chapter06 myCalc = new Chapter06();
//        myCalc.powerOn();
//
//        int result1 = myCalc.plus(5, 6);
//        System.out.println("result1: " + result1);
//
//        int x = 10;
//        int y = 4;
//        double result2 = myCalc.divide(x, y);
//        System.out.println("result2: " + result2);
//
//        myCalc.powerOff();
//
//        int result3 = myCalc.sum(1, 2, 3);
//        System.out.println("result3: " + result3);
//
//        int result4 = myCalc.sum(1, 2, 3, 4, 5);
//        System.out.println("result4: " + result4);
//
//        int[] values = { 1, 2, 3, 4, 5 };
//        int result5 = myCalc.sum(values);
//        System.out.println("result5: " + result5);
//
//        int result6 = myCalc.sum(new int[] { 1, 2, 3, 4, 5 });
//        System.out.println("result6: " + result6);
//
//        car1.setGas(5);
//
//        if (car1.isLeftGas()) {
//            System.out.println("출발합니다.");
//
//            car1.run();
//        }
//
//        System.out.println("gas를 주입하세요.");
//
//        double result7 = myCalc.areaRectangle(10);
//
//        double result8 = myCalc.areaRectangle(10, 20);
//
//        System.out.println("정사각형 넓이= " + result7);
//        System.out.println("직사각형 넓이= " + result8);
//
//        Galaxys25 myPhone = new Galaxys25(16);
//        myPhone.displayToggle();
//        myPhone.displayToggle();
//        myPhone.install(1.2, 0.5, 1.8, 2.3, 5.5, 9.3);
//        myPhone.versionUpgrade(8.5);
//        myPhone.versionUpgrade(6.0);
//        myPhone.versionUpgrade(6.5);
//
//        Nintendo marioGolf = new Nintendo("마리오 골프", "스포츠", "전체이용", 20000, "https://pimg.mk.co.kr/news/cms/202504/06/news-p.v1.20250404.ad221f845db2489a86c2ff50f32c53fa_P1.png");
//        Nintendo zelda = new Nintendo("젤다의 전설", "RPG ", "전체이용", 30000, "https://store.nintendo.co.kr/media/catalog/product/cache/3be328691086628caca32d01ffcc430a/f/i/file.jpg");
//
//        NintendoGames games = new NintendoGames(marioGolf);
//
//        games.getGameList();
//        games.addGame(zelda);
//        games.getGameList();
//
//        games.editGame(marioGolf, "마리오골프", "액션", "15세이용", 20000);
//
//        games.viewGame(marioGolf);
//        games.getGameList();
//        games.removeGame(marioGolf);
//        games.viewGame(marioGolf);
//        games.getGameList();
//
//
//        GameCharacter char1 = new GameCharacter("신사임걸", Cls.마법사, Gender.여자, LocalDate.of(2010, 1, 1), 500, 600, 10, 80, 5, 5);
//        GameCharacter char2 = new GameCharacter("흑색전사", Cls.전사, Gender.여자, LocalDate.of(2003, 7, 13), 800, 200, 60, 20, 15, 8);
//        GameCharacter char3 = new GameCharacter("도적고양이", Cls.도적, Gender.여자, LocalDate.of(2007, 12, 6), 310, 150, 30, 40, 35, 45);
//        GameCharacter char4 = new GameCharacter("못난이궁수", Cls.궁수, Gender.남자, LocalDate.of(2001, 3, 18), 330, 120, 40, 50, 85, 25);
//
//        CharacterList charList = new CharacterList(char1, char2, char3, char4);
//
//        charList.strAttack(char2, char3);
//        charList.viewCharacter(char3);
//
//        charList.strAttack(char2, char3);
//        charList.strAttack(char2, char3);
//        charList.strAttack(char2, char3);
//        charList.strAttack(char2, char3);
//        charList.strAttack(char2, char3);
//        charList.strAttack(char2, char3);
//        charList.viewCharacter(char3);
//
//        charList.intAttack(char1, char2);
//        charList.intAttack(char1, char2);
//        charList.intAttack(char1, char2);
//        charList.viewCharacter(char2);
//
//        charList.intAttack(char2, char1);
//        charList.intAttack(char2, char1);
//        charList.intAttack(char2, char1);
//        charList.intAttack(char2, char1);
//        charList.viewCharacter(char1);

    }
}