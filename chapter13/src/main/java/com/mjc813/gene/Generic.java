package com.mjc813.gene;

import lombok.*;
import java.util.*;

@Getter
@Setter
@AllArgsConstructor
public class Generic<K, V> {
    private final Map<K, V> map = new HashMap<K, V>();

    public void add(K key, V value) {
        if (map.containsKey(key)) {
            map.replace(key, value);
        } else {
            map.put(key, value);
        }
    }

    public V get(K key) {
        return map.get(key);
    }

    public V remove(K key) {
        return map.remove(key);
    }

    public int size() {
        return map.size();
    }

    public void change(K key1, K key2) {
        V temp = map.get(key1);
        map.replace(key1, map.get(key2));
        map.replace(key2, temp);
    }
}
