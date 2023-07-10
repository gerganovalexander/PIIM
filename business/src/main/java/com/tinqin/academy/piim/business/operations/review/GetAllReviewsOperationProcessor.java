package com.tinqin.academy.piim.business.operations.review;

import com.tinqin.academy.piim.api.entityoutputmodels.ReviewOutput;
import com.tinqin.academy.piim.api.errors.review.GetAllReviewsError;
import com.tinqin.academy.piim.api.generics.PiimError;
import com.tinqin.academy.piim.api.review.getall.GetAllReviewsInput;
import com.tinqin.academy.piim.api.review.getall.GetAllReviewsOperation;
import com.tinqin.academy.piim.api.review.getall.GetAllReviewsResult;
import com.tinqin.academy.piim.data.repositories.ReviewRepository;
import io.vavr.control.Either;
import io.vavr.control.Try;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class GetAllReviewsOperationProcessor implements GetAllReviewsOperation {
    private final ReviewRepository reviewRepository;
    private final ConversionService conversionService;

    @Override
    public Either<PiimError, GetAllReviewsResult> process(GetAllReviewsInput input) {
        return Try.of(() -> {
                    List<ReviewOutput> results = reviewRepository.findAll().stream()
                            .map(review -> conversionService.convert(review, ReviewOutput.class))
                            .toList();

                    return GetAllReviewsResult.builder().reviews(results).build();
                })
                .toEither()
                .mapLeft(throwable -> {
                    return new GetAllReviewsError(400, throwable.getMessage());
                });
    }
}
