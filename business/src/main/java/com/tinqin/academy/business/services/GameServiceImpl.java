package com.tinqin.academy.business.services;

import com.tinqin.academy.business.exceptions.DuplicateEntityException;
import com.tinqin.academy.business.services.contracts.GameService;
import com.tinqin.academy.data.models.Game;
import com.tinqin.academy.data.repositories.GameRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GameServiceImpl implements GameService {

    private final GameRepository gameRepository;

    @Override
    public List<Game> findAll() {
        return gameRepository.findAll();
    }

    @Override
    public Game findById(long id) {
        return gameRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Game with this Id not found."));
    }

    @Override
    public Game create(Game game) {
        if (gameRepository.existsByName(game.getName())) {
            throw new DuplicateEntityException("Game", "name", game.getName());
        }

        //make a call to first URL > GET ID
        //Make a call to second URL using the first ID to get review score
        //Set review score save
        return gameRepository.save(game);
    }

    @Override
    public Game update(Game game) {
        if (gameRepository.existsByName(game.getName())) {
            throw new DuplicateEntityException("Game", "name", game.getName());
        }
        return gameRepository.save(game);
    }

    @Override
    public void delete(long id) {
        gameRepository.deleteById(id);
    }
}
