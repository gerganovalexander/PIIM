package com.tinqin.academy.business.services.contracts;

import com.tinqin.academy.data.models.Game;

import java.util.List;

public interface GameService {

    List<Game> findAll();

    Game findById(long id);

    Game create(Game game);

    Game update(Game game);

    void delete(long id);
}
