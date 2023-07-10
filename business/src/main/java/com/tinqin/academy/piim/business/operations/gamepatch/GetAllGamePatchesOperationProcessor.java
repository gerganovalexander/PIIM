package com.tinqin.academy.piim.business.operations.gamepatch;

import com.tinqin.academy.piim.api.errors.gamepatch.GetAllGamePatchError;
import com.tinqin.academy.piim.api.gamepatch.getall.GetAllGamePatchesInput;
import com.tinqin.academy.piim.api.gamepatch.getall.GetAllGamePatchesOperation;
import com.tinqin.academy.piim.api.gamepatch.getall.GetAllGamePatchesResult;
import com.tinqin.academy.piim.api.gamepatch.getall.GetAllGamePatchesResults;
import com.tinqin.academy.piim.api.generics.PiimError;
import com.tinqin.academy.piim.data.repositories.GamePatchRepository;
import io.vavr.control.Either;
import io.vavr.control.Try;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GetAllGamePatchesOperationProcessor implements GetAllGamePatchesOperation {
    private final ConversionService conversionService;
    private final GamePatchRepository gamePatchRepository;

    @Override
    public Either<PiimError, GetAllGamePatchesResults> process(GetAllGamePatchesInput input) {
        return Try.of(() -> {
                    List<GetAllGamePatchesResult> results = gamePatchRepository.findAll().stream()
                            .map(gamePatch -> conversionService.convert(gamePatch, GetAllGamePatchesResult.class))
                            .collect(Collectors.toList());

                    return GetAllGamePatchesResults.builder().results(results).build();
                })
                .toEither()
                .mapLeft(throwable -> new GetAllGamePatchError(400, throwable.getMessage()));
    }
}
