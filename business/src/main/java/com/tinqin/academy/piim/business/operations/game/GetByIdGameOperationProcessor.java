package com.tinqin.academy.piim.business.operations.game;

import com.tinqin.academy.piim.api.errors.game.GetGameByIdError;
import com.tinqin.academy.piim.api.game.getbyid.GetByIdGameInput;
import com.tinqin.academy.piim.api.game.getbyid.GetByIdGameOperation;
import com.tinqin.academy.piim.api.game.getbyid.GetByIdGameResult;
import com.tinqin.academy.piim.api.generics.PiimError;
import com.tinqin.academy.piim.data.models.Game;
import com.tinqin.academy.piim.data.repositories.GameRepository;
import io.vavr.control.Either;
import io.vavr.control.Try;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetByIdGameOperationProcessor implements GetByIdGameOperation {

    private final GameRepository gameRepository;

    @Override
    public Either<PiimError, GetByIdGameResult> process(GetByIdGameInput input) {
        return Try.of(() -> {
                    Game game = gameRepository
                            .findById(input.getId())
                            .orElseThrow(() -> new EntityNotFoundException(
                                    String.format("Game with id %d not found.", input.getId())));

                    return GetByIdGameResult.builder()
                            .id(game.getId())
                            .name(game.getName())
                            .avgReviewDescription(game.getAvgReviewDescription())
                            .releaseDate(game.getReleaseDate())
                            .publisher(game.getPublisher())
                            .build();
                })
                .toEither()
                .mapLeft(throwable -> new GetGameByIdError(400, throwable.getMessage()));
    }
}
