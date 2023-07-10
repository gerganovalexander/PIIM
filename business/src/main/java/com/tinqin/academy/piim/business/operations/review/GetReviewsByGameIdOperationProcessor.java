package com.tinqin.academy.piim.business.operations.review;

import com.tinqin.academy.piim.api.entityoutputmodels.ReviewOutput;
import com.tinqin.academy.piim.api.errors.review.GetReviewsByGameIdError;
import com.tinqin.academy.piim.api.generics.PiimError;
import com.tinqin.academy.piim.api.review.getreviewsbygameid.GetReviewsByGameIdInput;
import com.tinqin.academy.piim.api.review.getreviewsbygameid.GetReviewsByGameIdOperation;
import com.tinqin.academy.piim.api.review.getreviewsbygameid.GetReviewsByGameIdResult;
import com.tinqin.academy.piim.data.repositories.GameRepository;
import io.vavr.control.Either;
import io.vavr.control.Try;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class GetReviewsByGameIdOperationProcessor implements GetReviewsByGameIdOperation {
    private final GameRepository gameRepository;
    private final ConversionService conversionService;

    @Override
    public Either<PiimError, GetReviewsByGameIdResult> process(final GetReviewsByGameIdInput input) {
        return Try.of(() -> {
                    List<ReviewOutput> reviews = gameRepository
                            .findById(input.getId())
                            .orElseThrow(() -> new EntityNotFoundException("Game not found"))
                            .getListOfReviews()
                            .stream()
                            .map(review -> conversionService.convert(review, ReviewOutput.class))
                            .toList();

                    return new GetReviewsByGameIdResult(reviews);
                })
                .toEither()
                .mapLeft(throwable -> {
                    return new GetReviewsByGameIdError(400, throwable.getMessage());
                });
    }
}
