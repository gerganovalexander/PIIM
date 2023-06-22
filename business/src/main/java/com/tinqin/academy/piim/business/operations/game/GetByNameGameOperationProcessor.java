package com.tinqin.academy.piim.business.operations.game;

import com.tinqin.academy.piim.api.game.getbyname.GetByNameGameInput;
import com.tinqin.academy.piim.api.game.getbyname.GetByNameGameResult;
import com.tinqin.academy.piim.api.game.getbyname.GetByNameOperation;
import com.tinqin.academy.piim.data.models.Game;
import com.tinqin.academy.piim.data.repositories.GameRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetByNameGameOperationProcessor implements GetByNameOperation {

    private final GameRepository gameRepository;

    @Override
    public GetByNameGameResult process(GetByNameGameInput input) {
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
    }
}
