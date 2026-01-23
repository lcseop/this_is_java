package com.mjc813;

import java.time.LocalDate;

public class GameCharacter {
    private String name;
    private Cls cls;
    private Gender gender;
    private LocalDate birthDate;
    private int stat_hp;
    private int stat_mp;
    private int stat_str;
    private int stat_int;
    private int stat_dex;
    private int stat_lux;

    public GameCharacter(String name, Cls cls, Gender gender) {
        this(name, cls, gender, LocalDate.now(), 100, 50, 10, 10, 10, 10);
    }

    public GameCharacter(String name, Cls cls, Gender gender, LocalDate birthDate) {
        this(name, cls, gender, birthDate, 100, 50, 10, 10, 10, 10);
    }

    public GameCharacter(String name, Cls cls, Gender gender, LocalDate birthDate, int stat_hp, int stat_mp, int stat_str, int stat_int, int stat_dex, int stat_lux) {
        this.name = name;
        this.cls = cls;
        this.gender = gender;
        this.birthDate = birthDate;
        this.stat_hp = stat_hp;
        this.stat_mp = stat_mp;
        this.stat_str = stat_str;
        this.stat_int = stat_int;
        this.stat_dex = stat_dex;
        this.stat_lux = stat_lux;
    }

    public void edit(String name, Cls cls, Gender gender, LocalDate birthDate, int stat_hp, int stat_mp, int stat_str, int stat_int, int stat_dex, int stat_lux) {
        this.name = name;
        this.cls = cls;
        this.gender = gender;
        this.birthDate = birthDate;
        this.stat_hp = stat_hp;
        this.stat_mp = stat_mp;
        this.stat_str = stat_str;
        this.stat_int = stat_int;
        this.stat_dex = stat_dex;
        this.stat_lux = stat_lux;
    }

    public void damage(int damage) {
        this.stat_hp -= damage;
        if (stat_hp < 0) {
            this.stat_hp = 0;
        }
    }

    public void mpDamage(int damage) {
        this.stat_mp -= damage;
        if (stat_mp < 0) {
            this.stat_mp = 0;
        }
    }

    public String getName() {
        return name;
    }

    public Cls getCls() {
        return cls;
    }

    public Gender getGender() {
        return gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public int getStat_hp() {
        return stat_hp;
    }

    public int getStat_mp() {
        return stat_mp;
    }

    public int getStat_str() {
        return stat_str;
    }

    public int getStat_int() {
        return stat_int;
    }

    public int getStat_dex() {
        return stat_dex;
    }

    public int getStat_lux() {
        return stat_lux;
    }
}
