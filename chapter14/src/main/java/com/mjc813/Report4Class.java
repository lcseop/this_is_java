package com.mjc813;
public class Report4Class extends Thread {
    private String word;

    public Report4Class(String word) {
        this.word = word;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println(word);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void setWord(String word) {
        this.word = word;
        System.out.println("------" + word + "(으)로 변경 완료.");
    }
}
