package com.mjc813.chapter20.gamecrud;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IGameMybatis {
    void insertData(GameDto newGame);
    void updateData(GameDto gameDto);
    void deleteData(Integer id);
    GameDto findById(Integer id);
    List<GameDto> searchList(SearchDto searchDto);
}
