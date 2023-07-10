package com.tinqin.academy.piim.business.operations.game;

import com.tinqin.academy.piim.api.entityoutputmodels.GameOutput;
import com.tinqin.academy.piim.api.errors.game.GetAllGamesByCategoryNameError;
import com.tinqin.academy.piim.api.game.getallbycategoryname.GetAllGamesByCategoryNameInput;
import com.tinqin.academy.piim.api.game.getallbycategoryname.GetAllGamesByCategoryNameOperation;
import com.tinqin.academy.piim.api.game.getallbycategoryname.GetAllGamesByCategoryNameResult;
import com.tinqin.academy.piim.api.generics.PiimError;
import com.tinqin.academy.piim.data.models.Game;
import com.tinqin.academy.piim.data.repositories.GameRepository;
import io.vavr.control.Either;
import io.vavr.control.Try;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class GetAllGamesByCategoryNameOperationProcessor implements GetAllGamesByCategoryNameOperation {

    private final GameRepository gameRepository;
    private final ConversionService conversionService;

    @Override
    public Either<PiimError, GetAllGamesByCategoryNameResult> process(final GetAllGamesByCategoryNameInput input) {
        return Try.of(() -> {
                    Pageable pageable = PageRequest.of(input.getPage(), input.getSize());

                    Page<Game> games = gameRepository.findAllByCategoryName(input.getCategoryName(), pageable);

                    return GetAllGamesByCategoryNameResult.builder()
                            .page(games.getNumber())
                            .limit(games.getSize())
                            .totalItems(games.getTotalElements())
                            .games(games.getContent().stream()
                                    .map(game -> conversionService.convert(game, GameOutput.class))
                                    .toList())
                            .build();
                })
                .toEither()
                .mapLeft(throwable -> new GetAllGamesByCategoryNameError(400, throwable.getMessage()));
    }
}
