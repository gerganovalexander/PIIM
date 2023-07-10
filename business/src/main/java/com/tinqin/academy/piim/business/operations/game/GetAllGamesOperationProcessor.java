package com.tinqin.academy.piim.business.operations.game;

import com.tinqin.academy.piim.api.errors.game.GetAllGamesError;
import com.tinqin.academy.piim.api.game.getall.GetAllGamesInput;
import com.tinqin.academy.piim.api.game.getall.GetAllGamesOperation;
import com.tinqin.academy.piim.api.game.getall.GetAllGamesResult;
import com.tinqin.academy.piim.api.game.getall.GetAllGamesResults;
import com.tinqin.academy.piim.api.generics.PiimError;
import com.tinqin.academy.piim.data.repositories.GameRepository;
import io.vavr.control.Either;
import io.vavr.control.Try;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetAllGamesOperationProcessor implements GetAllGamesOperation {

    private final GameRepository gameRepository;
    private final ConversionService conversionService;

    @Override
    public Either<PiimError, GetAllGamesResults> process(GetAllGamesInput input) {
        return Try.of(() -> {
                    List<GetAllGamesResult> results = gameRepository.findAll().stream()
                            .map(game -> conversionService.convert(game, GetAllGamesResult.class))
                            .toList();

                    return GetAllGamesResults.builder().results(results).build();
                })
                .toEither()
                .mapLeft(throwable -> new GetAllGamesError(400, throwable.getMessage()));
    }
}
