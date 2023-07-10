package com.tinqin.academy.piim.business.operations.game;

import com.tinqin.academy.piim.api.errors.game.GetGameByNameError;
import com.tinqin.academy.piim.api.game.getbyname.GetByNameGameInput;
import com.tinqin.academy.piim.api.game.getbyname.GetByNameGameResult;
import com.tinqin.academy.piim.api.game.getbyname.GetByNameOperation;
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
public class GetByNameGameOperationProcessor implements GetByNameOperation {

    private final GameRepository gameRepository;

    @Override
    public Either<PiimError, GetByNameGameResult> process(GetByNameGameInput input) {
        return Try.of(() -> {
                    Game game = gameRepository
                            .findFirstByName(input.getName())
                            .orElseThrow(() -> new EntityNotFoundException(
                                    String.format("Game with name %s does not exist.", input.getName())));

                    return GetByNameGameResult.builder()
                            .id(game.getId())
                            .name(game.getName())
                            .avgReviewDescription(game.getAvgReviewDescription())
                            .releaseDate(game.getReleaseDate())
                            .publisher(game.getPublisher())
                            .build();
                })
                .toEither()
                .mapLeft(throwable -> new GetGameByNameError(400, throwable.getMessage()));
    }
}
