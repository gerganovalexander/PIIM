package com.tinqin.academy.piim.business.converters.review;

import com.tinqin.academy.piim.api.entityoutputmodels.GameOutput;
import com.tinqin.academy.piim.api.entityoutputmodels.ReviewOutput;
import com.tinqin.academy.piim.api.entityoutputmodels.UserOutput;
import com.tinqin.academy.piim.data.models.Review;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ReviewToReviewOutputConverter implements Converter<Review, ReviewOutput> {

    private final ConversionService conversionService;

    @Lazy
    public ReviewToReviewOutputConverter(ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    public ReviewOutput convert(Review source) {
        return ReviewOutput.builder()
                .user(conversionService.convert(source.getUser(), UserOutput.class))
                .text(source.getText())
                .score(source.getScore())
                .id(source.getId())
                .game(conversionService.convert(source.getGame(), GameOutput.class))
                .build();
    }
}
