package com.tinqin.academy.piim.business.converters.game;

import com.tinqin.academy.piim.api.game.update.UpdateGameResult;
import com.tinqin.academy.piim.data.models.Game;
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
