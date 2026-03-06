package com.mjc813.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;

@Getter
@AllArgsConstructor
@ToString
public class NintendoGame implements Serializable {

    @Serial
    private static final long serialVersionUID = -372898888513931166L;
    private String name;
    private Integer price;
    private Grade grade;
    private GameType typpe;
}
