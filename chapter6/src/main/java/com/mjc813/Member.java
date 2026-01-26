package com.mjc813;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Member {
    private String name;
    private String id;
    private String password;
    private int age;

    public Member(String name, String id) {
        this(name, id, "", 20);
    }
}
