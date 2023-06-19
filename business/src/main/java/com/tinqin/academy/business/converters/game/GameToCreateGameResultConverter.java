package com.tinqin.academy.business.converters.game;

import com.tinqin.academy.api.game.create.CreateGameResult;
import com.tinqin.academy.data.models.Game;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class GameToCreateGameResultConverter implements Converter<Game, CreateGameResult> {
    @Override
    public CreateGameResult convert(Game game) {
        return CreateGameResult.builder()
                .id(game.getId())
                .name(game.getName())
                .avgReviewDescription(game.getAvgReviewDescription())
                .releaseDate(game.getReleaseDate())
                .publisher(game.getPublisher())
                .build();
    }
}
