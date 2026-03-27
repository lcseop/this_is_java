package com.mjc813.chapter20.gamecrud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {
    @Autowired
    private IGameMybatis gameMybatis;

    public void insertData(GameDto newGame) {
        this.gameMybatis.insertData(newGame);
    }

    public void updateData(GameDto newGame) {
        this.gameMybatis.updateData(newGame);
    }

    public void deleteData(Integer id) {
        this.gameMybatis.deleteData(id);
    }

    public GameDto findById(Integer id) {
        return this.gameMybatis.findById(id);
    }

    public List<GameDto> searchList(SearchDto searchDto) {
        return this.gameMybatis.searchList(searchDto);
    }
}
