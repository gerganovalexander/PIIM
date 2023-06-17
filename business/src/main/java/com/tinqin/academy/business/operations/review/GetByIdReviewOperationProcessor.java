package com.tinqin.academy.business.operations.review;


import com.tinqin.academy.api.entityoutputmodels.UserOutput;
import com.tinqin.academy.api.review.getbyid.GetByIdReviewInput;
import com.tinqin.academy.api.review.getbyid.GetByIdReviewOperation;
import com.tinqin.academy.api.review.getbyid.GetByIdReviewResult;
import com.tinqin.academy.data.models.Review;
import com.tinqin.academy.data.repositories.ReviewRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;


@Service
public class GetByIdReviewOperationProcessor implements GetByIdReviewOperation {
    private final ReviewRepository reviewRepository;
    private final ConversionService conversionService;

    @Lazy
    public GetByIdReviewOperationProcessor(ReviewRepository reviewRepository, ConversionService conversionService) {
        this.reviewRepository = reviewRepository;
        this.conversionService = conversionService;
    }

    @Override
    public GetByIdReviewResult process(GetByIdReviewInput input) {
        Review review = reviewRepository.findById(input.getId()).orElseThrow(
                () -> new EntityNotFoundException(String.format("Review with id %d not found.", input.getId())));

        return GetByIdReviewResult.builder()
                .id(review.getId())
                .text(review.getText())
                .score(review.getScore())
                .userOutput(conversionService.convert(review.getUser(), UserOutput.class))
                .build();
    }
}
