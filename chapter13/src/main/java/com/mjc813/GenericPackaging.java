package com.mjc813;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class GenericPackaging<T> {
    private final List<T> list = new ArrayList<>();
    private int index = -1;

    public void add (T obj) {
        if (index >= this.list.size()) {
            return;
        }
        this.list.add(obj);
        index++;
    }

    public T remove() {
        if (index < 0) {
            return null;
        }
        return this.list.remove(index--);
    }

}
