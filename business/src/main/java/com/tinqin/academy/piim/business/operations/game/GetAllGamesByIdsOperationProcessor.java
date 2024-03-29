package com.tinqin.academy.piim.business.operations.game;

import com.tinqin.academy.piim.api.entityoutputmodels.GameOutput;
import com.tinqin.academy.piim.api.errors.game.GetAllGamesByIdsError;
import com.tinqin.academy.piim.api.game.getallbyids.GetAllGamesByIdsInput;
import com.tinqin.academy.piim.api.game.getallbyids.GetAllGamesByIdsOperation;
import com.tinqin.academy.piim.api.game.getallbyids.GetAllGamesByIdsResult;
import com.tinqin.academy.piim.api.generics.PiimError;
import com.tinqin.academy.piim.data.repositories.GameRepository;
import io.vavr.control.Either;
import io.vavr.control.Try;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetAllGamesByIdsOperationProcessor implements GetAllGamesByIdsOperation {

    private final GameRepository gameRepository;
    private final ConversionService conversionService;

    @Override
    public Either<PiimError, GetAllGamesByIdsResult> process(final GetAllGamesByIdsInput input) {
        return Try.of(() -> {
                    Pageable pageable = PageRequest.of(input.getPage(), input.getSize());

                    Page<GameOutput> games = gameRepository
                            .findAllByIds(input.getIds(), pageable)
                            .map(game -> conversionService.convert(game, GameOutput.class));

                    return GetAllGamesByIdsResult.builder()
                            .page(games.getNumber())
                            .limit(games.getSize())
                            .totalItems(games.getTotalElements())
                            .games(games.getContent())
                            .build();
                })
                .toEither()
                .mapLeft(throwable -> new GetAllGamesByIdsError(400, throwable.getMessage()));
    }
}
