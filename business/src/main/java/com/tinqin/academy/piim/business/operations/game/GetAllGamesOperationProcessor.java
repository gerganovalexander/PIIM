package com.tinqin.academy.piim.business.operations.game;

import com.tinqin.academy.piim.api.game.getall.GetAllGamesInput;
import com.tinqin.academy.piim.api.game.getall.GetAllGamesOperation;
import com.tinqin.academy.piim.api.game.getall.GetAllGamesResult;
import com.tinqin.academy.piim.api.game.getall.GetAllGamesResults;
import com.tinqin.academy.piim.data.repositories.GameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetAllGamesOperationProcessor implements GetAllGamesOperation {

    private final GameRepository gameRepository;
    private final ConversionService conversionService;


    @Override
    public GetAllGamesResults process(GetAllGamesInput input) {
        List<GetAllGamesResult> results = gameRepository.findAll(PageRequest.of(1, 20)).stream()
                .map(game -> conversionService.convert(game, GetAllGamesResult.class))
                .toList();


        return GetAllGamesResults.builder()
                .results(results)
                .build();
    }
}
