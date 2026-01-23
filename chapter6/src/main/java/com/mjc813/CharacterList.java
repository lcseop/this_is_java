package com.mjc813;
import java.time.LocalDate;
import java.util.*;

public class CharacterList {
    ArrayList<GameCharacter> characters;

    public CharacterList() {
        this.characters = new ArrayList<GameCharacter>();
    }

    public CharacterList(GameCharacter ... characterList) {
        this.characters = new ArrayList<GameCharacter>(List.of(characterList));
    }

    public void addCharacter(GameCharacter character) {
        characters.add(character);
    }

    public void editCharacter(GameCharacter character, String name, Cls cls, Gender gender, LocalDate birthDate, int stat_hp, int stat_mp, int stat_str, int stat_int, int stat_dex, int stat_lux) {
        if (characters.contains(character)) {
            character.edit(name, cls, gender, birthDate, stat_hp, stat_mp, stat_str, stat_int, stat_dex, stat_lux);
        } else {
            System.out.println("해당 캐릭터는 정보에 등록되지 않았습니다.");
        }
    }

    public void deleteCharacter(GameCharacter character, String name, Cls cls, Gender gender, LocalDate birthDate, int stat_hp, int stat_mp, int stat_str, int stat_int, int stat_dex, int stat_lux) {
        if (characters.contains(character)) {
            characters.remove(character);
        } else {
            System.out.println("해당 캐릭터는 정보에 등록되지 않았습니다.");
        }
    }

    public void viewCharacter(GameCharacter character) {
        if (this.characters.contains(character)) {
            System.out.println("------------------------------------");
            if (character.getStat_hp() == 0) {;
                System.out.printf("[ 쓰러짐 ]\n"); }
            System.out.printf("이름 : %s\n", character.getName());
            System.out.printf("직업 : %s\n", character.getCls());
            System.out.printf("성별 : %s\n", character.getGender());
            System.out.printf("생일 : %s\n", character.getBirthDate());
            System.out.printf("HP : %s\n", character.getStat_hp());
            System.out.printf("MP : %s\n", character.getStat_mp());
            System.out.printf("STR : %s\n", character.getStat_str());
            System.out.printf("INT : %s\n", character.getStat_int());
            System.out.printf("DEX : %s\n", character.getStat_dex());
            System.out.printf("LUX : %s\n", character.getStat_lux());
            System.out.println("------------------------------------");
        } else {
            System.out.println("해당하는 게임을 찾을 수 없습니다.");
        }
    }

    public void strAttack(GameCharacter attacker, GameCharacter target) {
        if (characters.contains(attacker) && characters.contains(target)) {
            if (target.getStat_hp() > 0) {
                System.out.println(attacker.getName() + "이(가) " + target.getName() + "에게 " + attacker.getStat_str() + "만큼 피해를 입혔습니다.");
                target.damage(attacker.getStat_str());
                System.out.println(target.getName() + "의 남은 체력 : " + target.getStat_hp() + " (-" + attacker.getStat_str() + ")");

            } else {
                System.out.println("대상이 이미 쓰러졌습니다.");
            }
        } else {
            System.out.println("공격자나 대상이 정보에 등록되지 않았습니다.");
        }
    }

    public void intAttack(GameCharacter attacker, GameCharacter target) {
        if (characters.contains(attacker) && characters.contains(target)) {
            if (attacker.getStat_mp() >= 30) {
                if (target.getStat_hp() > 0) {
                    System.out.println(attacker.getName() + "이(가) " + target.getName() + "에게 30의 마나를 소모해 " + attacker.getStat_int() * 2 + "만큼 피해를 입혔습니다.");
                    target.damage(attacker.getStat_int() * 2);
                    attacker.mpDamage(30);
                    System.out.println(target.getName() + "의 남은 체력 : " + target.getStat_hp() + " (-" + attacker.getStat_int() * 2 + ")");
                    System.out.println(attacker.getName() + "의 남은 마나 : " + attacker.getStat_mp() + " (-30)");

                } else {
                    System.out.println("대상이 이미 쓰러졌습니다.");
                }
            } else {
                System.out.println(attacker.getName() + "에게 30 이상의 마나가 필요합니다.");
            }
        } else {
            System.out.println("공격자나 대상이 정보에 등록되지 않았습니다.");
        }
    }
}
