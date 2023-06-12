package com.tinqin.academy.piim.controllers;

import com.tinqin.academy.piim.models.Game;
import com.tinqin.academy.piim.services.contracts.GameService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/games")
public class GameController {

    private final GameService gameService;

    @GetMapping
    public List<Game> findAll() {
        return gameService.findAll();
    }

    @GetMapping("/{id}")
    public Game findById(@PathVariable long id) {
        return gameService.findById(id);
    }

    @PostMapping
    public Game create(@Valid @RequestBody Game game) {
        return gameService.create(game);
    }

    @PutMapping("/{id}")
    public Game update(@PathVariable long id, @Valid @RequestBody Game game) {
        game.setId(id);
        return gameService.update(game);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        gameService.delete(id);
    }
}
