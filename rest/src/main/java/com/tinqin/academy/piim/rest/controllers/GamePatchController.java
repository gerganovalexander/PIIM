package com.tinqin.academy.piim.rest.controllers;

import com.tinqin.academy.piim.api.gamepatch.create.CreateGamePatchInput;
import com.tinqin.academy.piim.api.gamepatch.create.CreateGamePatchOperation;
import com.tinqin.academy.piim.api.gamepatch.create.CreateGamePatchResult;
import com.tinqin.academy.piim.api.gamepatch.delete.DeleteGamePatchInput;
import com.tinqin.academy.piim.api.gamepatch.delete.DeleteGamePatchOperation;
import com.tinqin.academy.piim.api.gamepatch.delete.DeleteGamePatchResult;
import com.tinqin.academy.piim.api.gamepatch.getall.GetAllGamePatchesInput;
import com.tinqin.academy.piim.api.gamepatch.getall.GetAllGamePatchesOperation;
import com.tinqin.academy.piim.api.gamepatch.getall.GetAllGamePatchesResults;
import com.tinqin.academy.piim.api.gamepatch.getbyid.GetGamePatchByIdInput;
import com.tinqin.academy.piim.api.gamepatch.getbyid.GetGamePatchByIdOperation;
import com.tinqin.academy.piim.api.gamepatch.getbyid.GetGamePatchByIdResult;
import com.tinqin.academy.piim.api.gamepatch.update.UpdateGamePatchInput;
import com.tinqin.academy.piim.api.gamepatch.update.UpdateGamePatchOperation;
import com.tinqin.academy.piim.api.gamepatch.update.UpdateGamePatchResult;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/game-patches")
@RequiredArgsConstructor
public class GamePatchController {

    private final GetGamePatchByIdOperation getGamePatchByIdOperation;
    private final GetAllGamePatchesOperation getAllGamePatchesOperation;
    private final CreateGamePatchOperation createGamePatchOperation;
    private final UpdateGamePatchOperation updateGamePatchOperation;
    private final DeleteGamePatchOperation deleteGamePatchOperation;

    @GetMapping("/")
    public GetAllGamePatchesResults getAllGamePatches() {
        GetAllGamePatchesInput getAllGamePatchesInput = new GetAllGamePatchesInput();
        return getAllGamePatchesOperation.process(getAllGamePatchesInput);
    }

    @GetMapping("/{id}")
    public GetGamePatchByIdResult findGamePatchById(@PathVariable Long id) {
        GetGamePatchByIdInput getGamePatchByIdInput = new GetGamePatchByIdInput(id);
        return getGamePatchByIdOperation.process(getGamePatchByIdInput);
    }

    @PostMapping("/")
    public CreateGamePatchResult createGamePatch(@Valid @RequestBody CreateGamePatchInput input) {
        return createGamePatchOperation.process(input);
    }

    @PutMapping("/{id}")
    public UpdateGamePatchResult updateGamePatch(
            @PathVariable Long id, @Valid @RequestBody UpdateGamePatchInput updateGamePatchInput) {
        updateGamePatchInput.setId(id);
        return updateGamePatchOperation.process(updateGamePatchInput);
    }

    @DeleteMapping("/{id}")
    public DeleteGamePatchResult deleteGamePatch(@PathVariable Long id) {
        DeleteGamePatchInput deleteGamePatchInput = new DeleteGamePatchInput(id);
        return deleteGamePatchOperation.process(deleteGamePatchInput);
    }
}
