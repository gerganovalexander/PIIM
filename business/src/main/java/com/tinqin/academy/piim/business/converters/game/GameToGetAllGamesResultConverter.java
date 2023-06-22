package com.tinqin.academy.piim.business.converters.game;

import com.tinqin.academy.piim.api.game.getall.GetAllGamesResult;
import com.tinqin.academy.piim.data.models.Game;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class GameToGetAllGamesResultConverter implements Converter<Game, GetAllGamesResult> {

    @Override
    public GetAllGamesResult convert(Game source) {
        return GetAllGamesResult.builder()
                .id(source.getId())
                .name(source.getName())
                .avgReviewDescription(source.getAvgReviewDescription())
                .releaseDate(source.getReleaseDate())
                .publisher(source.getPublisher())
                .build();
    }
}
