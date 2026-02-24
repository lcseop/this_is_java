package com.mjc813;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class GenericPackaging<T> {
    private ArrayList<T> list = new ArrayList<T>();
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
