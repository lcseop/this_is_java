package com.mjc813;

public class Nintendo {
    private String title;
    private String genre;
    private String grade;
    private int price;
    private String imgUrl;

    public Nintendo(String title, String genre, String grade, int price) {
        this(title, genre, grade, price, "");
    }

    public Nintendo(String title, String genre, String grade, int price, String imgUrl) {
        this.title = title;
        this.genre = genre;
        this.grade = grade;
        this.price = price;
        this.imgUrl = imgUrl;
    }

    public void editGame(String title, String genre, String grade, int price) {
        this.editGame(title, genre, grade, price, this.imgUrl);
    }

    public void editGame(String title, String genre, String grade, int price, String imgUrl) {
        this.title = title;
        this.genre = genre;
        this.grade = grade;
        this.price = price;
        this.imgUrl = imgUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public String getGrade() {
        return grade;
    }

    public int getPrice() {
        return price;
    }

    public String getImgUrl() {
        return imgUrl;
    }
}
