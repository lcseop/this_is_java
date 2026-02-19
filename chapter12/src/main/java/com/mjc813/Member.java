package com.mjc813;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Member {
    private String id;
    private String name;

    @Override
    public String toString() {
        return this.getId() + ": " + this.getName();
    }
}
