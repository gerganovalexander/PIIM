package com.tinqin.academy.piim.business.operations.game;

import com.tinqin.academy.piim.api.game.create.CreateGameInput;
import com.tinqin.academy.piim.api.game.create.CreateGameOperation;
import com.tinqin.academy.piim.api.game.create.CreateGameResult;
import com.tinqin.academy.piim.data.models.Game;
import com.tinqin.academy.piim.data.repositories.GameRepository;
import com.tinqin.academy.piim.ext.steam.interactors.SteamApiInteractor;
import jakarta.persistence.EntityExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CreateGameOperationProcessor implements CreateGameOperation {

    private final GameRepository gameRepository;
    private final ConversionService conversionService;
    private final SteamApiInteractor steamApiInteractor;

    @Override
    public CreateGameResult process(CreateGameInput input) {

        Game game = Game.builder()
                .name(input.getName())
                .releaseDate(input.getReleaseDate().orElse(LocalDateTime.parse("0000-01-01T00:00:00")))
                .publisher(input.getPublisher().orElse("N/A"))
                .build();

        if (gameRepository.existsByName(game.getName())) {
            throw new EntityExistsException(String.format("Game with name %s already exists.", input.getName()));
        }

        game.setAvgReviewDescription(steamApiInteractor.getReviewByName(game.getName()));
        game = gameRepository.save(game);

        return conversionService.convert(game, CreateGameResult.class);
    }
}
