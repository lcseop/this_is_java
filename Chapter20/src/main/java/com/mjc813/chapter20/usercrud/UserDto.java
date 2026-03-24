package com.mjc813.chapter20.usercrud;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private String userid;
    private String name;
    private String password;
    private Integer age;
    private String email;
}
