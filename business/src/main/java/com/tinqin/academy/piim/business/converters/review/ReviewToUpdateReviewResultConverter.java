package com.tinqin.academy.piim.business.converters.review;

import com.tinqin.academy.piim.api.review.update.UpdateReviewResult;
import com.tinqin.academy.piim.data.models.Review;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ReviewToUpdateReviewResultConverter implements Converter<Review, UpdateReviewResult> {
    @Override
    public UpdateReviewResult convert(Review source) {
        return UpdateReviewResult.builder()
                .id(source.getId())
                .text(source.getText())
                .build();
    }
}
