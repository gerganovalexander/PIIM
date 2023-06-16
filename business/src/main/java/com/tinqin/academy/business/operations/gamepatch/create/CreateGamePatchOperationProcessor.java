package com.tinqin.academy.business.operations.gamepatch.create;

import com.tinqin.academy.api.entityoutputmodels.GamePatchOutput;
import com.tinqin.academy.api.gamepatch.create.CreateGamePatchInput;
import com.tinqin.academy.api.gamepatch.create.CreateGamePatchOperation;
import com.tinqin.academy.api.gamepatch.create.CreateGamePatchResult;
import com.tinqin.academy.data.models.Game;
import com.tinqin.academy.data.models.GamePatch;
import com.tinqin.academy.data.repositories.GamePatchRepository;
import com.tinqin.academy.data.repositories.GameRepository;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateGamePatchOperationProcessor implements CreateGamePatchOperation {
    private final ConversionService conversionService;
    private final GameRepository gameRepository;
    private final GamePatchRepository gamePatchRepository;

    @Override
    public CreateGamePatchResult process(CreateGamePatchInput input) {
        Game game = gameRepository.findById(input.getGameId())
                .orElseThrow(() -> new EntityNotFoundException("Game with this Id does not exist."));

        boolean patchExists = gamePatchRepository.existsGamePatchByVersion(input.getVersion());
        if (patchExists) {
            throw new EntityExistsException("Game patch with this version already exists.");
        }

        GamePatch gamePatch = GamePatch.builder()
                .version(input.getVersion())
                .description(input.getDescription())
                .game(game).build();

        gamePatch = gamePatchRepository.save(gamePatch);

        return CreateGamePatchResult.builder()
                .gamePatchOutput(conversionService.convert(gamePatch, GamePatchOutput.class))
                .build();
    }
}
