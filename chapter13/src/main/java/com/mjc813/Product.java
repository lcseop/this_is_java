package com.mjc813;

import lombok.*;

@Getter
@Setter
public class Product<K, M> {
    private K kind;
    private M model;
}
