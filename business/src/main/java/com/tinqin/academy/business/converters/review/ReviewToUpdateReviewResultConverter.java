package com.tinqin.academy.business.converters.review;

import com.tinqin.academy.api.review.update.UpdateReviewResult;
import com.tinqin.academy.data.models.Review;
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
