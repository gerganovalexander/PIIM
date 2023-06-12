package com.tinqin.academy.piim.services.contracts;

import com.tinqin.academy.piim.models.Game;

import java.util.List;

public interface GameService {

    List<Game> findAll();

    Game findById(long id);

    Game create(Game game);

    Game update(Game game);

    void delete(long id);
}
