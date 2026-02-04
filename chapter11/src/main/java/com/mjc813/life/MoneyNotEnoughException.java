package com.mjc813.life;

public class MoneyNotEnoughException extends RuntimeException {
    public MoneyNotEnoughException() {}
    public MoneyNotEnoughException(String message) {
        super(message);
    }
}
