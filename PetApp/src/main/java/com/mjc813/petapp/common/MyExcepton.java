package com.mjc813.petapp.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MyExcepton extends Exception {
    private Object data;
}
