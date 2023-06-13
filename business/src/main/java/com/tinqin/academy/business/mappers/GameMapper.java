package com.tinqin.academy.business.mappers;

import com.tinqin.academy.business.dtos.GameDto;
import com.tinqin.academy.data.models.Game;

public class GameMapper {

    public static Game dtoToGame(GameDto dto) {
        Game game = new Game();
        game.setName(dto.getName());
        return game;
    }

    public static Game dtoToGame(GameDto dto, long id) {
        Game game = dtoToGame(dto);
        game.setId(id);
        return game;
    }

    public static GameDto gameToDto(Game game) {
        return new GameDto(game.getName());
    }
}
