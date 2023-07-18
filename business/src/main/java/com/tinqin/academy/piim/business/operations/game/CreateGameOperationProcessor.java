package com.tinqin.academy.piim.business.operations.game;

import com.tinqin.academy.piim.api.errors.game.CreateGameError;
import com.tinqin.academy.piim.api.game.create.CreateGameInput;
import com.tinqin.academy.piim.api.game.create.CreateGameOperation;
import com.tinqin.academy.piim.api.game.create.CreateGameResult;
import com.tinqin.academy.piim.api.generics.PiimError;
import com.tinqin.academy.piim.data.models.Game;
import com.tinqin.academy.piim.data.repositories.GameRepository;
import com.tinqin.academy.piim.ext.steam.interactors.SteamApiInteractor;
import io.vavr.control.Either;
import io.vavr.control.Try;
import jakarta.persistence.EntityExistsException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Slf4j
@RequiredArgsConstructor
public class CreateGameOperationProcessor implements CreateGameOperation {

    private final GameRepository gameRepository;
    private final ConversionService conversionService;
    private final SteamApiInteractor steamApiInteractor;

    @Override
    public Either<PiimError, CreateGameResult> process(CreateGameInput input) {

        return Try.of(() -> {
                    Game game = Game.builder()
                            .name(input.getName())
                            .releaseDate(input.getReleaseDate().orElse(LocalDateTime.parse("0000-01-01T00:00:00")))
                            .publisher(input.getPublisher().orElse("N/A"))
                            .build();

                    if (gameRepository.existsByName(game.getName())) {
                        throw new EntityExistsException(
                                String.format("Game with name %s already exists.", input.getName()));
                    }

                    game.setAvgReviewDescription(steamApiInteractor.getReviewByName(game.getName()));
                    game = gameRepository.save(game);

                    return conversionService.convert(game, CreateGameResult.class);
                })
                .toEither()
                .mapLeft(throwable -> new CreateGameError(400, throwable.getMessage()));
    }
}
