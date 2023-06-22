package com.tinqin.academy.piim.rest.controllers;

import com.tinqin.academy.piim.api.game.create.CreateGameInput;
import com.tinqin.academy.piim.api.game.create.CreateGameOperation;
import com.tinqin.academy.piim.api.game.create.CreateGameResult;
import com.tinqin.academy.piim.api.game.delete.DeleteGameInput;
import com.tinqin.academy.piim.api.game.delete.DeleteGameOperation;
import com.tinqin.academy.piim.api.game.delete.DeleteGameResult;
import com.tinqin.academy.piim.api.game.getall.GetAllGamesInput;
import com.tinqin.academy.piim.api.game.getall.GetAllGamesOperation;
import com.tinqin.academy.piim.api.game.getall.GetAllGamesResults;
import com.tinqin.academy.piim.api.game.getallbycategoryname.GetAllGamesByCategoryNameInput;
import com.tinqin.academy.piim.api.game.getallbycategoryname.GetAllGamesByCategoryNameOperation;
import com.tinqin.academy.piim.api.game.getallbycategoryname.GetAllGamesByCategoryNameResult;
import com.tinqin.academy.piim.api.game.getallbyids.GetAllGamesByIdsInput;
import com.tinqin.academy.piim.api.game.getallbyids.GetAllGamesByIdsOperation;
import com.tinqin.academy.piim.api.game.getallbyids.GetAllGamesByIdsResult;
import com.tinqin.academy.piim.api.game.getbyid.GetByIdGameInput;
import com.tinqin.academy.piim.api.game.getbyid.GetByIdGameOperation;
import com.tinqin.academy.piim.api.game.getbyid.GetByIdGameResult;
import com.tinqin.academy.piim.api.game.getbyname.GetByNameGameInput;
import com.tinqin.academy.piim.api.game.getbyname.GetByNameGameResult;
import com.tinqin.academy.piim.api.game.getbyname.GetByNameOperation;
import com.tinqin.academy.piim.api.game.update.UpdateGameInput;
import com.tinqin.academy.piim.api.game.update.UpdateGameOperation;
import com.tinqin.academy.piim.api.game.update.UpdateGameResult;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.security.InvalidParameterException;

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
    private final GetAllGamesByIdsOperation getAllGamesByIdsOperation;
    private final GetAllGamesByCategoryNameOperation getAllGamesByCategoryNameOperation;

    @GetMapping
    public GetAllGamesResults getAll() {
        return getAllGamesOperation.process(GetAllGamesInput.builder().build());
    }

    @GetMapping("/{id}")
    public GetByIdGameResult getById(@PathVariable long id) {
        return getByIdGameOperation.process(GetByIdGameInput.builder().id(id).build());
    }

    @PostMapping("/get-by-ids")
    public GetAllGamesByIdsResult getAllGamesByIds(@RequestBody @Valid GetAllGamesByIdsInput getAllGamesByIdsInput) {
        return getAllGamesByIdsOperation.process(getAllGamesByIdsInput);
    }

    @GetMapping("/filter")
    public GetAllGamesByCategoryNameResult getAllGamesByCategoryName(
            @Valid GetAllGamesByCategoryNameInput input, BindingResult result) {

        if (result.hasErrors()) {
            throw new InvalidParameterException(result.getAllErrors().get(0).getDefaultMessage());
        }

        return getAllGamesByCategoryNameOperation.process(GetAllGamesByCategoryNameInput.builder()
                .categoryName(input.getCategoryName())
                .page(input.getPage())
                .size(input.getSize())
                .build());
    }

    @GetMapping(params = "name")
    public GetByNameGameResult getByName(@RequestParam(name = "name") String name) {
        return getByNameOperation.process(
                GetByNameGameInput.builder().name(name).build());
    }

    @PostMapping
    public CreateGameResult create(@RequestBody @Valid CreateGameInput game) {
        return createGameOperation.process(game);
    }

    @PutMapping("/{id}")
    public UpdateGameResult update(@PathVariable long id, @Valid @RequestBody UpdateGameInput updateGameInput) {
        updateGameInput.setId(id);
        return updateGameOperation.process(updateGameInput);
    }

    @DeleteMapping("/{id}")
    public DeleteGameResult delete(@PathVariable long id) {
        return deleteGameOperation.process(DeleteGameInput.builder().id(id).build());
    }
}
