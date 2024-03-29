package com.tinqin.academy.piim.business.operations.game;

import com.tinqin.academy.piim.api.errors.game.DeleteGameError;
import com.tinqin.academy.piim.api.game.delete.DeleteGameInput;
import com.tinqin.academy.piim.api.game.delete.DeleteGameOperation;
import com.tinqin.academy.piim.api.game.delete.DeleteGameResult;
import com.tinqin.academy.piim.api.generics.PiimError;
import com.tinqin.academy.piim.data.repositories.GameRepository;
import io.vavr.control.Either;
import io.vavr.control.Try;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;

@Service
@RequiredArgsConstructor
public class DeleteGameOperationProcessor implements DeleteGameOperation {

    private final GameRepository gameRepository;

    @Override
    public Either<PiimError, DeleteGameResult> process(DeleteGameInput input) {
        return Try.of(() -> {
                    if (input.getId() <= 0) throw new InvalidParameterException("Game id is invalid.");
                    if (!gameRepository.existsById(input.getId())) {
                        throw new EntityNotFoundException(
                                String.format("Game with id %d does not exists.", input.getId()));
                    }
                    gameRepository.deleteById(input.getId());

                    return DeleteGameResult.builder().success(true).build();
                })
                .toEither()
                .mapLeft(throwable -> new DeleteGameError(400, throwable.getMessage()));
    }
}
