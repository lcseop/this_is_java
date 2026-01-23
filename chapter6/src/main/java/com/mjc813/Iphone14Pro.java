package com.mjc813;

public class Iphone14Pro {
    private double battery = 100.0;
    private double storage = 5;
    private double maxStorage = 16;
    private boolean display = false;

    public void displayToggle() {
        this.display = !this.display;
    }

    public void install(double ... apps) {
        for (double app : apps) {
            if (this.storage + app > this.maxStorage) {
                System.out.println("용량의 한계에 도달했습니다. 현재 용량 : " + this.storage + "/" + this.maxStorage);
                return;
            } else {
                this.storage += app;
                System.out.println("앱 설치 완료. 현재 용량 : " + this.storage + "/" + this.maxStorage);
            }
        }
    }

    public boolean isDisplay() {
        return display;
    }

    public double getBattery() {
        return battery;
    }

    public double getStorage() {
        return storage;
    }

    public double getMaxStorage() {
        return maxStorage;
    }
}
