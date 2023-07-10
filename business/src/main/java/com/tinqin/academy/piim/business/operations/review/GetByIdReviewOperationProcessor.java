package com.tinqin.academy.piim.business.operations.review;

import com.tinqin.academy.piim.api.entityoutputmodels.UserOutput;
import com.tinqin.academy.piim.api.errors.review.GetByIdReviewError;
import com.tinqin.academy.piim.api.generics.PiimError;
import com.tinqin.academy.piim.api.review.getbyid.GetByIdReviewInput;
import com.tinqin.academy.piim.api.review.getbyid.GetByIdReviewOperation;
import com.tinqin.academy.piim.api.review.getbyid.GetByIdReviewResult;
import com.tinqin.academy.piim.data.models.Review;
import com.tinqin.academy.piim.data.repositories.ReviewRepository;
import io.vavr.control.Either;
import io.vavr.control.Try;
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
    public Either<PiimError, GetByIdReviewResult> process(GetByIdReviewInput input) {
        return Try.of(() -> {
                    Review review = reviewRepository
                            .findById(input.getId())
                            .orElseThrow(() -> new EntityNotFoundException(
                                    String.format("Review with id %d not found.", input.getId())));

                    return GetByIdReviewResult.builder()
                            .id(review.getId())
                            .text(review.getText())
                            .score(review.getScore())
                            .userOutput(conversionService.convert(review.getUser(), UserOutput.class))
                            .build();
                })
                .toEither()
                .mapLeft(throwable -> {
                    return new GetByIdReviewError(400, throwable.getMessage());
                });
    }
}
