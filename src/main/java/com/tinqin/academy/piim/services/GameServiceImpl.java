package com.tinqin.academy.piim.services;

import com.tinqin.academy.piim.exceptions.DuplicateEntityException;
import com.tinqin.academy.piim.models.Game;
import com.tinqin.academy.piim.repositories.GameRepository;
import com.tinqin.academy.piim.services.contracts.GameService;
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
