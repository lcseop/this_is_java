package com.mjc813;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    private int balance = 0;
    private String number;
    private String name;
    final static int MIN_BALANCE = 0;
    final static int MAX_BALANCE = 1000000;

    public void setBalance(int balance) {
        if (balance < MIN_BALANCE || balance > MAX_BALANCE) {
            return;
        } else {
            this.balance = balance;
        }
    }
}
