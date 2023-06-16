package com.tinqin.academy.business.operations.game;

import com.tinqin.academy.api.game.update.UpdateGameInput;
import com.tinqin.academy.api.game.update.UpdateGameOperation;
import com.tinqin.academy.api.game.update.UpdateGameResult;
import com.tinqin.academy.business.exceptions.DuplicateEntityException;
import com.tinqin.academy.data.models.Game;
import com.tinqin.academy.data.repositories.GameRepository;
import com.tinqin.academy.ext.steam.interactors.SteamApiInteractor;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;

@Service
@RequiredArgsConstructor
public class UpdateGameOperationProcessor implements UpdateGameOperation {

    private final GameRepository gameRepository;
    private final ConversionService conversionService;
    private final SteamApiInteractor steamApiInteractor;

    @Override
    public UpdateGameResult process(UpdateGameInput input) {
        if (input.getId() <= 0) throw new InvalidParameterException("Game id is invalid.");
        if (!gameRepository.existsById(input.getId())) {
            throw new EntityNotFoundException(String.format("Game with id %d does not exist.", input.getId()));
        }

        if (gameRepository.existsByName(input.getName())) {
            throw new DuplicateEntityException("Game", "name", input.getName());
        }

        Game game = Game.builder()
                .id(input.getId())
                .name(input.getName())
                .releaseDate(input.getReleaseDate())
                .publisher(input.getPublisher())
                .build();

        game.setAvgReviewDescription(steamApiInteractor.getReviewByName(game.getName()));

        gameRepository.save(game);

        return conversionService.convert(game, UpdateGameResult.class);
    }
}
