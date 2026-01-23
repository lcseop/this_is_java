package com.mjc813;
import java.util.*;

public class NintendoGames {
    ArrayList<Nintendo> gameList;

    public NintendoGames() {}

    public NintendoGames(Nintendo ... gameList) {
        this.gameList = new ArrayList<Nintendo>(List.of(gameList));
    }

    public void getGameList() {
        System.out.println("------------------------------------");
        System.out.println("장르\t\t\t등급\t\t\t제목");
        System.out.println("------------------------------------");
        for (Nintendo game : gameList) {
            System.out.printf( (game.getGenre().length() >= 3) ? "%s\t\t%s\t\t%s\n" : "%s\t\t\t%s\t\t%s\n"
                    , game.getGenre(), game.getGrade(), game.getTitle());
        }
        System.out.println("------------------------------------");
    }

    public void viewGame(Nintendo game) {
        if (this.gameList.contains(game)) {
            System.out.println("------------------------------------");
            System.out.printf("게임 제목 : %s\n", game.getTitle());
            System.out.printf("게임 장르 : %s\n", game.getGenre());
            System.out.printf("게임 등급 : %s\n", game.getGrade());
            System.out.printf("게임 가격 : %s\n", game.getPrice());
            System.out.printf("이미지 주소 : %s\n", game.getImgUrl());
            System.out.println("------------------------------------");
        } else {
            System.out.println("해당하는 게임을 찾을 수 없습니다.");
        }
    }

    public void addGame(Nintendo game) {
        this.gameList.add(game);
    }

    public void editGame(Nintendo game, String title, String genre, String grade, int price) {
        this.editGame(game, title, genre, grade, price, null);
    }

    public void editGame(Nintendo game, String title, String genre, String grade, int price, String imgUrl) {
        if (this.gameList.contains(game)) {
            if (imgUrl == null) {
                game.editGame(title, genre, grade, price);
            } else {
                game.editGame(title, genre, grade, price, imgUrl);
            }

        } else {
            System.out.println("해당하는 게임을 찾을 수 없습니다.");
        }
    }

    public void removeGame(Nintendo game) {
        if (this.gameList.contains(game)) {
            this.gameList.remove(game);
        } else {
            System.out.println("해당하는 게임을 찾을 수 없습니다.");
        }
    }
}
