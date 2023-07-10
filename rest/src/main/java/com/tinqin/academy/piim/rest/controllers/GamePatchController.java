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
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/game-patches")
@RequiredArgsConstructor
public class GamePatchController extends BaseController{

    private final GetGamePatchByIdOperation getGamePatchByIdOperation;
    private final GetAllGamePatchesOperation getAllGamePatchesOperation;
    private final CreateGamePatchOperation createGamePatchOperation;
    private final UpdateGamePatchOperation updateGamePatchOperation;
    private final DeleteGamePatchOperation deleteGamePatchOperation;

    @GetMapping
    public ResponseEntity<?> getAllGamePatches() {
        GetAllGamePatchesInput getAllGamePatchesInput = new GetAllGamePatchesInput();
        return handleOperation(getAllGamePatchesOperation.process(getAllGamePatchesInput));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findGamePatchById(@PathVariable Long id) {
        GetGamePatchByIdInput getGamePatchByIdInput = new GetGamePatchByIdInput(id);
        return handleOperation(getGamePatchByIdOperation.process(getGamePatchByIdInput));
    }

    @PostMapping
    public ResponseEntity<?> createGamePatch(@Valid @RequestBody CreateGamePatchInput input) {
        return handleOperation(createGamePatchOperation.process(input));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateGamePatch(
            @PathVariable Long id, @Valid @RequestBody UpdateGamePatchInput updateGamePatchInput) {
        updateGamePatchInput.setId(id);
        return handleOperation(updateGamePatchOperation.process(updateGamePatchInput));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteGamePatch(@PathVariable Long id) {
        DeleteGamePatchInput deleteGamePatchInput = new DeleteGamePatchInput(id);
        return handleOperation(deleteGamePatchOperation.process(deleteGamePatchInput));
    }
}
