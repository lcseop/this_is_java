package com.mjc813;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;

@AllArgsConstructor
@ToString
public class Member implements Serializable {
    @Serial
    private static final long serialVersionUID = -5684627554637331746L;
    private String id;
    private String name;
}
