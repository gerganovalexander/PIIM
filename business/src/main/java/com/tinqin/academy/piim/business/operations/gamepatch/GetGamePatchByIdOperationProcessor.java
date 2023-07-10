package com.tinqin.academy.piim.business.operations.gamepatch;

import com.tinqin.academy.piim.api.entityoutputmodels.GamePatchOutput;
import com.tinqin.academy.piim.api.errors.gamepatch.GetByIdGamePatchError;
import com.tinqin.academy.piim.api.gamepatch.getbyid.GetGamePatchByIdInput;
import com.tinqin.academy.piim.api.gamepatch.getbyid.GetGamePatchByIdOperation;
import com.tinqin.academy.piim.api.gamepatch.getbyid.GetGamePatchByIdResult;
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
public class GetGamePatchByIdOperationProcessor implements GetGamePatchByIdOperation {
    private final ConversionService conversionService;
    private final GamePatchRepository gamePatchRepository;

    @Override
    public Either<PiimError, GetGamePatchByIdResult> process(GetGamePatchByIdInput input) {
        return Try.of(() -> {
                    GamePatch gamePatch = gamePatchRepository
                            .findById(input.getId())
                            .orElseThrow(() -> new EntityNotFoundException("Game patch with this Id does not exist."));

                    return GetGamePatchByIdResult.builder()
                            .gamePatch(conversionService.convert(gamePatch, GamePatchOutput.class))
                            .build();
                })
                .toEither()
                .mapLeft(throwable -> new GetByIdGamePatchError(400, throwable.getMessage()));
    }
}
