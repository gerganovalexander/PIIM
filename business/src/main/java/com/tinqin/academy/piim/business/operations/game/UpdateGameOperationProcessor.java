package com.tinqin.academy.piim.business.operations.game;

import com.tinqin.academy.piim.api.game.update.UpdateGameInput;
import com.tinqin.academy.piim.api.game.update.UpdateGameOperation;
import com.tinqin.academy.piim.api.game.update.UpdateGameResult;
import com.tinqin.academy.piim.data.models.Game;
import com.tinqin.academy.piim.data.repositories.GameRepository;
import com.tinqin.academy.piim.ext.steam.interactors.SteamApiInteractor;
import jakarta.persistence.EntityExistsException;
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
            throw new EntityExistsException(String.format("Game with name %s already exists.", input.getName()));
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