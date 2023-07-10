package com.tinqin.academy.piim.business.operations.gamepatch;

import com.tinqin.academy.piim.api.entityoutputmodels.GamePatchOutput;
import com.tinqin.academy.piim.api.errors.gamepatch.CreateGamePatchError;
import com.tinqin.academy.piim.api.gamepatch.create.CreateGamePatchInput;
import com.tinqin.academy.piim.api.gamepatch.create.CreateGamePatchOperation;
import com.tinqin.academy.piim.api.gamepatch.create.CreateGamePatchResult;
import com.tinqin.academy.piim.api.generics.PiimError;
import com.tinqin.academy.piim.data.models.Game;
import com.tinqin.academy.piim.data.models.GamePatch;
import com.tinqin.academy.piim.data.repositories.GamePatchRepository;
import com.tinqin.academy.piim.data.repositories.GameRepository;
import io.vavr.control.Either;
import io.vavr.control.Try;
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
    public Either<PiimError, CreateGamePatchResult> process(CreateGamePatchInput input) {
        return Try.of(() -> {
                    Game game = gameRepository
                            .findById(input.getGameId())
                            .orElseThrow(() -> new EntityNotFoundException("Game with this Id does not exist."));

                    boolean patchExists = gamePatchRepository.existsGamePatchByVersion(input.getVersion());
                    if (patchExists) {
                        throw new EntityExistsException("Game patch with this version already exists.");
                    }

                    GamePatch gamePatch = GamePatch.builder()
                            .version(input.getVersion())
                            .description(input.getDescription())
                            .game(game)
                            .build();

                    gamePatch = gamePatchRepository.save(gamePatch);

                    return CreateGamePatchResult.builder()
                            .gamePatchOutput(conversionService.convert(gamePatch, GamePatchOutput.class))
                            .build();
                })
                .toEither()
                .mapLeft(throwable -> new CreateGamePatchError(400, throwable.getMessage()));
    }
}
