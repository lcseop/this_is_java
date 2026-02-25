package com.mjc813;

public class Util {
    public static <K, V, T extends Pair<K, V>> V getValue(T t, K s) {
        if (t.getKey().equals(s)) {
            return t.getValue();
        } else {
            return null;
        }
    }
}
