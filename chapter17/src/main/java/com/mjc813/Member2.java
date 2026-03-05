package com.mjc813;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Member2 {
    private String name;
    private String job;

    @Override
    public String toString() {
        return "{name:" + name + ", job: " + job + "}";
    }
}
