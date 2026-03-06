package com.mjc813;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;

@AllArgsConstructor
@ToString
public class Product implements Serializable {
    @Serial
    private static final long serialVersionUID = 6505252251179678023L;
    private String name;
    private int price;
}
