package com.mjc813.exam;

import java.util.*;

import com.google.gson.Gson;
import lombok.Getter;

@Getter
public class NintendoGameService<G> implements CRUD<G> {
    private final List<G> gameList = new LinkedList<>();
    private Gson gson = new Gson();

    @Override
    public void add(G item) {
        gameList.add(item);
    }

    @Override
    public int size() {
        return gameList.size();
    }

    @Override
    public G set(int index, G item) {
        gameList.add(index, item);
        return item;
    }

    @Override
    public G remove(int index) {
        return gameList.remove(index);
    }

    @Override
    public G get(int index) {
        return gameList.get(index);
    }

    @Override
    public String getJson(int index) {
        return gson.toJson(gameList.get(index));
    }

    @Override
    public String getJsonAllItems() {
        String result = "[";
        for (int i = 0; i < gameList.size(); i++) {
            result += gson.toJson(gameList.get(i)) + ",\n";
        }
        result += "]";
        return result;
    }
}
