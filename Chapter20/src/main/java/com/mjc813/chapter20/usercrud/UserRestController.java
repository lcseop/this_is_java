package com.mjc813.chapter20.usercrud;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRestController {

    @PostMapping("/api/users")
    public void insertData(@RequestBody UserDto userDto) {
        System.out.println(userDto.toString());
    }
}
