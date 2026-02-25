package com.mjc813.exam;

import java.util.*;

import com.google.gson.Gson;
import lombok.Getter;

@Getter
public class NintendoGameService<G> implements CRUD<G> {
    private final List<G> gameList = new LinkedList<>();
    private final Gson gson = new Gson();

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
        if (index < 0) {
            gameList.addFirst(item);
        } else if (index >= gameList.size()) {
            gameList.add(item);
        } else {
            gameList.add(index, item);
        }
        return item;
    }

    @Override
    public G remove(int index) {
        if (index < 0 || index >= gameList.size()) {
            return null;
        } else {
            return gameList.remove(index);
        }
    }

    @Override
    public G get(int index) {
        if (index < 0 || index >= gameList.size()) {
            return null;
        } else {
            return gameList.get(index);
        }
    }

    @Override
    public String getJson(int index) {
        if (index >= gameList.size() || index < 0) {
            return null;
        } else {
            return gson.toJson(gameList.get(index));
        }
    }

    @Override
    public String getJsonAllItems() {
        String result = "[\n";
        for (int i = 0; i < gameList.size(); i++) {
            result += (i != gameList.size()-1) ?
                    gson.toJson(gameList.get(i)) + ",\n" :
                    gson.toJson(gameList.get(i)) + "\n]";
        }
        return result;
    }
}
