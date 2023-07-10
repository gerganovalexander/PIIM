package com.tinqin.academy.piim.business.operations.review;

import com.tinqin.academy.piim.api.errors.review.ExistsByIdReviewError;
import com.tinqin.academy.piim.api.generics.PiimError;
import com.tinqin.academy.piim.api.review.existsbyid.ExistsByIdReviewInput;
import com.tinqin.academy.piim.api.review.existsbyid.ExistsByIdReviewOperation;
import com.tinqin.academy.piim.api.review.existsbyid.ExistsByIdReviewResult;
import com.tinqin.academy.piim.data.repositories.ReviewRepository;
import io.vavr.control.Either;
import io.vavr.control.Try;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExistsByIdReviewOperationProcessor implements ExistsByIdReviewOperation {
    private final ReviewRepository reviewRepository;

    @Override
    public Either<PiimError, ExistsByIdReviewResult> process(ExistsByIdReviewInput input) {
        return Try.of(() -> {
                    boolean doesExist = reviewRepository.existsById(input.getId());
                    return ExistsByIdReviewResult.builder().doesExist(doesExist).build();
                })
                .toEither()
                .mapLeft(throwable -> {
                    return new ExistsByIdReviewError(400, throwable.getMessage());
                });
    }
}
