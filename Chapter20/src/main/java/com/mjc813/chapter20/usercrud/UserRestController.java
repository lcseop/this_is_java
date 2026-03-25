package com.mjc813.chapter20.usercrud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRestController {
    @Autowired
    private UserService userService;

    @PostMapping("/api/users")
    public void insertData(@RequestBody UserDto userDto) {
        System.out.println(userDto.toString());
        this.userService.insertData(userDto);
    }
}
