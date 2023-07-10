package com.tinqin.academy.piim.business.operations.game;

import com.tinqin.academy.piim.api.errors.game.ExistsByIdGameError;
import com.tinqin.academy.piim.api.game.existsbyid.ExistsByIdGameInput;
import com.tinqin.academy.piim.api.game.existsbyid.ExistsByIdGameOperation;
import com.tinqin.academy.piim.api.game.existsbyid.ExistsByIdGameResult;
import com.tinqin.academy.piim.api.generics.PiimError;
import com.tinqin.academy.piim.data.repositories.GameRepository;
import io.vavr.control.Either;
import io.vavr.control.Try;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExistsByIdGameOperationProcessor implements ExistsByIdGameOperation {
    private final GameRepository gameRepository;

    @Override
    public Either<PiimError, ExistsByIdGameResult> process(ExistsByIdGameInput input) {
        return Try.of(() -> {
                    boolean doesExist = gameRepository.existsById(input.getId());
                    return ExistsByIdGameResult.builder().doesExist(doesExist).build();
                })
                .toEither()
                .mapLeft(throwable -> new ExistsByIdGameError(400, throwable.getMessage()));
    }
}
