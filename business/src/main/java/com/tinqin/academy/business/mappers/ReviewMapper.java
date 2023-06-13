package com.tinqin.academy.business.mappers;

import com.tinqin.academy.api.dtos.ReviewDto;
import com.tinqin.academy.data.models.Review;

public class ReviewMapper {
    public static Review dtoToReview(ReviewDto dto) {
        Review review = new Review();
        review.setText(dto.getText());
        return review;
    }

    public static Review dtoToReview(ReviewDto dto, long id) {
        Review review = dtoToReview(dto);
        review.setId(id);
        return review;
    }

    public static ReviewDto reviewToDto(Review review) {
        return new ReviewDto(review.getText());
    }
}
