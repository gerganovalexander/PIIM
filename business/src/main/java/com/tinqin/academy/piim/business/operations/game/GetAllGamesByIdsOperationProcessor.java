package com.tinqin.academy.piim.business.operations.game;

import com.tinqin.academy.piim.api.entityoutputmodels.GameOutput;
import com.tinqin.academy.piim.api.game.getallbyids.GetAllGamesByIdsInput;
import com.tinqin.academy.piim.api.game.getallbyids.GetAllGamesByIdsOperation;
import com.tinqin.academy.piim.api.game.getallbyids.GetAllGamesByIdsResult;
import com.tinqin.academy.piim.data.repositories.GameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class GetAllGamesByIdsOperationProcessor implements GetAllGamesByIdsOperation {

    private final GameRepository gameRepository;
    private final ConversionService conversionService;

    @Override
    public GetAllGamesByIdsResult process(final GetAllGamesByIdsInput input) {
        List<GameOutput> games = gameRepository.findAllById(input.getIds()).stream()
                .map(game -> conversionService.convert(game, GameOutput.class)).toList();

        return new GetAllGamesByIdsResult(games);
    }
}
