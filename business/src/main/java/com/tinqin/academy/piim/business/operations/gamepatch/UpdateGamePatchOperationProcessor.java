package com.tinqin.academy.piim.business.operations.gamepatch;

import com.tinqin.academy.piim.api.entityoutputmodels.GamePatchOutput;
import com.tinqin.academy.piim.api.errors.gamepatch.UpdateGamePatchError;
import com.tinqin.academy.piim.api.gamepatch.update.UpdateGamePatchInput;
import com.tinqin.academy.piim.api.gamepatch.update.UpdateGamePatchOperation;
import com.tinqin.academy.piim.api.gamepatch.update.UpdateGamePatchResult;
import com.tinqin.academy.piim.api.generics.PiimError;
import com.tinqin.academy.piim.data.models.GamePatch;
import com.tinqin.academy.piim.data.repositories.GamePatchRepository;
import io.vavr.control.Either;
import io.vavr.control.Try;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateGamePatchOperationProcessor implements UpdateGamePatchOperation {
    private final ConversionService conversionService;
    private final GamePatchRepository gamePatchRepository;

    @Override
    public Either<PiimError, UpdateGamePatchResult> process(UpdateGamePatchInput input) {
        return Try.of(() -> {
                    GamePatch gamePatchForUpdate = gamePatchRepository
                            .findById(input.getId())
                            .orElseThrow(() -> new EntityNotFoundException("Game patch with this Id does not exist."));

                    gamePatchForUpdate.setDescription(input.getDescription());
                    gamePatchForUpdate = gamePatchRepository.save(gamePatchForUpdate);

                    return UpdateGamePatchResult.builder()
                            .gamePatchOutput(conversionService.convert(gamePatchForUpdate, GamePatchOutput.class))
                            .build();
                })
                .toEither()
                .mapLeft(throwable -> new UpdateGamePatchError(400, throwable.getMessage()));
    }
}
