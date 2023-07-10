package com.tinqin.academy.piim.business.operations.game;

import com.tinqin.academy.piim.api.errors.game.UpdateGameError;
import com.tinqin.academy.piim.api.game.update.UpdateGameInput;
import com.tinqin.academy.piim.api.game.update.UpdateGameOperation;
import com.tinqin.academy.piim.api.game.update.UpdateGameResult;
import com.tinqin.academy.piim.api.generics.PiimError;
import com.tinqin.academy.piim.data.models.Game;
import com.tinqin.academy.piim.data.repositories.GameRepository;
import com.tinqin.academy.piim.ext.steam.interactors.SteamApiInteractor;
import io.vavr.control.Either;
import io.vavr.control.Try;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UpdateGameOperationProcessor implements UpdateGameOperation {

    private final GameRepository gameRepository;
    private final ConversionService conversionService;
    private final SteamApiInteractor steamApiInteractor;

    @Override
    public Either<PiimError, UpdateGameResult> process(UpdateGameInput input) {
        return Try.of(() -> {
                    if (input.getId() <= 0) throw new InvalidParameterException("Game id is invalid.");
                    if (!gameRepository.existsById(input.getId())) {
                        throw new EntityNotFoundException(
                                String.format("Game with id %d does not exist.", input.getId()));
                    }

                    if (gameRepository.existsByName(input.getName())) {
                        throw new EntityExistsException(
                                String.format("Game with name %s already exists.", input.getName()));
                    }

                    Game game = Game.builder()
                            .id(input.getId())
                            .name(input.getName())
                            .releaseDate(input.getReleaseDate().orElse(LocalDateTime.parse("0000-01-01T00:00:00")))
                            .publisher(input.getPublisher().orElse("N/A"))
                            .build();

                    game.setAvgReviewDescription(steamApiInteractor.getReviewByName(game.getName()));

                    gameRepository.save(game);

                    return conversionService.convert(game, UpdateGameResult.class);
                })
                .toEither()
                .mapLeft(throwable -> new UpdateGameError(400, throwable.getMessage()));
    }
}
