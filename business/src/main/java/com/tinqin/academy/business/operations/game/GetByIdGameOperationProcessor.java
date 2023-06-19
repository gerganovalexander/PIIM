package com.tinqin.academy.business.operations.game;

import com.tinqin.academy.api.game.getbyid.GetByIdGameInput;
import com.tinqin.academy.api.game.getbyid.GetByIdGameOperation;
import com.tinqin.academy.api.game.getbyid.GetByIdGameResult;
import com.tinqin.academy.data.models.Game;
import com.tinqin.academy.data.repositories.GameRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetByIdGameOperationProcessor implements GetByIdGameOperation {

    private final GameRepository gameRepository;

    @Override
    public GetByIdGameResult process(GetByIdGameInput input) {
        Game game = gameRepository.findById(input.getId()).orElseThrow(
                () -> new EntityNotFoundException(String.format("Game with id %d not found.", input.getId())));

        return GetByIdGameResult.builder()
                .id(game.getId())
                .name(game.getName())
                .avgReviewDescription(game.getAvgReviewDescription())
                .releaseDate(game.getReleaseDate())
                .publisher(game.getPublisher())
                .build();
    }
}
