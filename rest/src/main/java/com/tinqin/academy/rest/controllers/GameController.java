package com.tinqin.academy.rest.controllers;

import com.tinqin.academy.api.game.create.CreateGameInput;
import com.tinqin.academy.api.game.create.CreateGameOperation;
import com.tinqin.academy.api.game.create.CreateGameResult;
import com.tinqin.academy.api.game.delete.DeleteGameInput;
import com.tinqin.academy.api.game.delete.DeleteGameOperation;
import com.tinqin.academy.api.game.delete.DeleteGameResult;
import com.tinqin.academy.api.game.getall.GetAllGamesInput;
import com.tinqin.academy.api.game.getall.GetAllGamesOperation;
import com.tinqin.academy.api.game.getall.GetAllGamesResults;
import com.tinqin.academy.api.game.getbyid.GetByIdGameInput;
import com.tinqin.academy.api.game.getbyid.GetByIdGameOperation;
import com.tinqin.academy.api.game.getbyid.GetByIdGameResult;
import com.tinqin.academy.api.game.getbyname.GetByNameGameInput;
import com.tinqin.academy.api.game.getbyname.GetByNameGameResult;
import com.tinqin.academy.api.game.getbyname.GetByNameOperation;
import com.tinqin.academy.api.game.update.UpdateGameInput;
import com.tinqin.academy.api.game.update.UpdateGameOperation;
import com.tinqin.academy.api.game.update.UpdateGameResult;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/games")
public class GameController {

    private final CreateGameOperation createGameOperation;
    private final GetAllGamesOperation getAllGamesOperation;
    private final GetByIdGameOperation getByIdGameOperation;
    private final GetByNameOperation getByNameOperation;
    private final UpdateGameOperation updateGameOperation;
    private final DeleteGameOperation deleteGameOperation;

    @GetMapping
    public GetAllGamesResults getAll() {
        return getAllGamesOperation.process(GetAllGamesInput.builder().build());
    }

    @GetMapping("/{id}")
    public GetByIdGameResult getById(@PathVariable long id) {
        return getByIdGameOperation.process(GetByIdGameInput.builder().id(id).build());
    }

    @GetMapping(params = "name")
    public GetByNameGameResult getByName(@RequestParam(name = "name") String name) {
        return getByNameOperation.process(GetByNameGameInput.builder().name(name).build());
    }

    @PostMapping
    public CreateGameResult create(@RequestBody @Valid CreateGameInput game) {
        return createGameOperation.process(game);
    }

    @PutMapping("/{id}")
    public UpdateGameResult update(@PathVariable long id,
                                   @Valid @RequestBody UpdateGameInput updateGameInput) {
        updateGameInput.setId(id);
        return updateGameOperation.process(updateGameInput);
    }

    @DeleteMapping("/{id}")
    public DeleteGameResult delete(@PathVariable long id) {
        return deleteGameOperation.process(DeleteGameInput.builder().id(id).build());
    }
}
