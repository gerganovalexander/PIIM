package com.tinqin.academy.piim.rest.controllers;

import com.tinqin.academy.piim.api.game.create.CreateGameInput;
import com.tinqin.academy.piim.api.game.create.CreateGameOperation;
import com.tinqin.academy.piim.api.game.create.CreateGameResult;
import com.tinqin.academy.piim.api.game.delete.DeleteGameInput;
import com.tinqin.academy.piim.api.game.delete.DeleteGameOperation;
import com.tinqin.academy.piim.api.game.delete.DeleteGameResult;
import com.tinqin.academy.piim.api.game.existsbyid.ExistsByIdGameInput;
import com.tinqin.academy.piim.api.game.existsbyid.ExistsByIdGameOperation;
import com.tinqin.academy.piim.api.game.existsbyid.ExistsByIdGameResult;
import com.tinqin.academy.piim.api.game.getall.GetAllGamesInput;
import com.tinqin.academy.piim.api.game.getall.GetAllGamesOperation;
import com.tinqin.academy.piim.api.game.getallbycategoryname.GetAllGamesByCategoryNameInput;
import com.tinqin.academy.piim.api.game.getallbycategoryname.GetAllGamesByCategoryNameOperation;
import com.tinqin.academy.piim.api.game.getallbyids.GetAllGamesByIdsInput;
import com.tinqin.academy.piim.api.game.getallbyids.GetAllGamesByIdsOperation;
import com.tinqin.academy.piim.api.game.getbyid.GetByIdGameInput;
import com.tinqin.academy.piim.api.game.getbyid.GetByIdGameOperation;
import com.tinqin.academy.piim.api.game.getbyname.GetByNameGameInput;
import com.tinqin.academy.piim.api.game.getbyname.GetByNameGameResult;
import com.tinqin.academy.piim.api.game.getbyname.GetByNameOperation;
import com.tinqin.academy.piim.api.game.update.UpdateGameInput;
import com.tinqin.academy.piim.api.game.update.UpdateGameOperation;
import com.tinqin.academy.piim.api.game.update.UpdateGameResult;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.security.InvalidParameterException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/games")
public class GameController extends BaseController {

    private final CreateGameOperation createGameOperation;
    private final GetAllGamesOperation getAllGamesOperation;
    private final GetByIdGameOperation getByIdGameOperation;
    private final GetByNameOperation getByNameOperation;
    private final UpdateGameOperation updateGameOperation;
    private final DeleteGameOperation deleteGameOperation;
    private final GetAllGamesByIdsOperation getAllGamesByIdsOperation;
    private final GetAllGamesByCategoryNameOperation getAllGamesByCategoryNameOperation;
    private final ExistsByIdGameOperation existsByIdGameOperation;

    @GetMapping
    public ResponseEntity<?> getAll() {
        return handleOperation(
                getAllGamesOperation.process(GetAllGamesInput.builder().build()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable long id) {
        return handleOperation(
                getByIdGameOperation.process(GetByIdGameInput.builder().id(id).build()));
    }

    @PostMapping("/get-by-ids")
    public ResponseEntity<?> getAllGamesByIds(@RequestBody @Valid GetAllGamesByIdsInput getAllGamesByIdsInput) {
        return handleOperation(getAllGamesByIdsOperation.process(getAllGamesByIdsInput));
    }

    @GetMapping("/filter")
    public ResponseEntity<?> getAllGamesByCategoryName(@Valid GetAllGamesByCategoryNameInput input) {
        return handleOperation(getAllGamesByCategoryNameOperation.process(GetAllGamesByCategoryNameInput.builder()
                .categoryName(input.getCategoryName())
                .page(input.getPage())
                .size(input.getSize())
                .build()));
    }

    @GetMapping(params = "name")
    public ResponseEntity<?> getByName(@RequestParam(name = "name") String name) {
        return handleOperation(getByNameOperation.process(
                GetByNameGameInput.builder().name(name).build()));
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid CreateGameInput game) {
        return handleOperation(createGameOperation.process(game));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable long id, @Valid @RequestBody UpdateGameInput updateGameInput) {
        updateGameInput.setId(id);
        return handleOperation(updateGameOperation.process(updateGameInput));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        return handleOperation(deleteGameOperation.process(DeleteGameInput.builder().id(id).build()));
    }

    @GetMapping("/{id}/exists")
    public ResponseEntity<?> checkIfGameExistsById(@PathVariable Long id) {
        return handleOperation(existsByIdGameOperation.process(
                ExistsByIdGameInput.builder().id(id).build()));
    }
}
