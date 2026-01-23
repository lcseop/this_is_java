package com.mjc813;

public class Galaxys25 {
    private double battery = 100.0;
    private double oneUI_Version = 7.0;
    private double storage = 5;
    private double maxStorage = 16;
    private boolean display = false;

    public Galaxys25(double maxStorage) {
        this.maxStorage = maxStorage;
    }

    public void displayToggle() {
        this.display = !this.display;
        System.out.println(display ? "화면이 켜졌습니다." : "화면이 꺼졌습니다.");
    }

    public void versionUpgrade(double version) {
        if (version > 7.0) {
            System.out.println("버전은 현재 7.0까지입니다.");
        } else {
            System.out.println(this.oneUI_Version > version ? "버전 다운그레이드 완료. 현재 버전 : " + version : "버전 업그레이드 완료. 현재 버전 : " + version);
            this.oneUI_Version = version;
        }
    }

    public void install(double ... apps) {
        for (double app : apps) {
            if (this.storage + app > this.maxStorage) {
                System.out.println("용량의 한계에 도달했습니다. 현재 용량 : " + this.storage + " / " + this.maxStorage);
                return;
            } else {
                this.storage += app;
                System.out.println("앱 설치 완료. 현재 용량 : " + this.storage + " / " + this.maxStorage);
            }
        }
    }

    public boolean isDisplay() {
        return display;
    }

    public double getBattery() {
        return battery;
    }

    public double getVersion() {
        return oneUI_Version;
    }

    public double getStorage() {
        return storage;
    }

    public double getMaxStorage() {
        return maxStorage;
    }
}
