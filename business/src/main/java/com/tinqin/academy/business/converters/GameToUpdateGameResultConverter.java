package com.tinqin.academy.business.converters;

import com.tinqin.academy.api.game.update.UpdateGameResult;
import com.tinqin.academy.data.models.Game;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class GameToUpdateGameResultConverter implements Converter<Game, UpdateGameResult> {
    @Override
    public UpdateGameResult convert(Game source) {
        return UpdateGameResult.builder()
                .id(source.getId())
                .name(source.getName())
                .avgReviewDescription(source.getAvgReviewDescription())
                .releaseDate(source.getReleaseDate())
                .publisher(source.getPublisher())
                .build();
    }
}
