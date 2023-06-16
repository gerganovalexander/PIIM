package com.tinqin.academy.business.operations.game;

import com.tinqin.academy.api.game.create.CreateGameInput;
import com.tinqin.academy.api.game.create.CreateGameOperation;
import com.tinqin.academy.api.game.create.CreateGameResult;
import com.tinqin.academy.business.exceptions.DuplicateEntityException;
import com.tinqin.academy.business.exceptions.EmptyEntityException;
import com.tinqin.academy.data.models.Game;
import com.tinqin.academy.data.repositories.CategoryRepository;
import com.tinqin.academy.data.repositories.GameRepository;
import com.tinqin.academy.ext.steam.interactors.SteamApiInteractor;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateGameOperationProcessor implements CreateGameOperation {

    private final GameRepository gameRepository;
    private final CategoryRepository categoryRepository;
    private final ConversionService conversionService;
    private final SteamApiInteractor steamApiInteractor;

    @Override
    public CreateGameResult process(CreateGameInput input) {

        Game game = Game.builder()
                .name(input.getName())
                .releaseDate(input.getReleaseDate())
                .publisher(input.getPublisher())
                .build();


        if (game == null) {
            throw new EmptyEntityException("Invalid game");
        }
        if (gameRepository.existsByName(game.getName())) {
            throw new DuplicateEntityException("Game", "name", game.getName());
        }

        game.setAvgReviewDescription(steamApiInteractor.getReviewByName(game.getName()));
        game = gameRepository.save(game);

        return conversionService.convert(game, CreateGameResult.class);
    }
}
