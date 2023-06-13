package com.tinqin.academy.web.controllers;

import com.tinqin.academy.business.dtos.GameDto;
import com.tinqin.academy.business.mappers.GameMapper;
import com.tinqin.academy.business.services.contracts.GameService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static com.tinqin.academy.business.mappers.GameMapper.dtoToGame;
import static com.tinqin.academy.business.mappers.GameMapper.gameToDto;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/games")
public class GameController {

    private final GameService gameService;

    @GetMapping
    public List<GameDto> findAll() {
        return gameService.findAll().stream()
                .map(GameMapper::gameToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public GameDto findById(@PathVariable long id) {
        return gameToDto(gameService.findById(id));
    }

    @PostMapping
    public GameDto create(@Valid @RequestBody GameDto game) {
        return gameToDto(gameService.create(dtoToGame(game)));
    }

    @PutMapping("/{id}")
    public GameDto update(@PathVariable long id, @Valid @RequestBody GameDto game) {
        return gameToDto(gameService.update(dtoToGame(game, id)));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        gameService.delete(id);
    }
}
