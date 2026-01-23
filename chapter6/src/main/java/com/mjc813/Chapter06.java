package com.mjc813;

class Korean {
    String nation = "대한민국";
    String name;
    String ssn;

    Korean(String name, String ssn) {
        this.name = name;
        this.ssn = ssn;
    }
}

public class Chapter06 {
    String model = "그랜져";
    String company = "현대자동차";
    String color = "검정";
    int speed;
    int maxSpeed = 350;
    int gas;
    boolean start;

    Chapter06() {}

    Chapter06(String model) {
        this(model, "은색", 250);
    }

    Chapter06(String model, String color) {
        this(model, color, 250);
    }

    Chapter06(String model, String color, int maxSpeed) {
        this.model = model;
        this.color = color;
        this.maxSpeed = maxSpeed;
    }

    void powerOn() {
        System.out.println("전원을 켭니다.");
    }

    void powerOff() {
        System.out.println("전원을 끕니다.");
    }

    int plus(int x, int y) {
        int result = x + y;
        return result;
    }

    double divide(int x, int y) {
        double result = (double) x / (double) y;
        return result;
    }

    int sum(int ... values) {
        int sum = 0;

        for (int value : values) {
            sum += value;
        }

        return sum;
    }

    void setGas(int gas) {
        this.gas = gas;
    }

    boolean isLeftGas() {
        if (gas == 0) {
            System.out.println("gas가 없습니다.");
            return false;
        }
        System.out.println("gas가 있습니다.");
        return true;
    }

    void run() {
        while (true) {
            if (gas > 0) {
                System.out.println("달립니다. (gas 잔량 : " + gas + ")");
                gas--;
            } else {
                System.out.println("멈춥니다. (gas 잔량 : " + gas + ")");
                return;
            }
        }
    }

    double areaRectangle(double width) {
        return width * width;
    }

    double areaRectangle(double width, double height) {
        return width * height;
    }
}
