package com.tinqin.academy.piim.business.operations.review;

import com.tinqin.academy.piim.api.errors.review.DeleteReviewError;
import com.tinqin.academy.piim.api.generics.PiimError;
import com.tinqin.academy.piim.api.review.delete.DeleteReviewInput;
import com.tinqin.academy.piim.api.review.delete.DeleteReviewOperation;
import com.tinqin.academy.piim.api.review.delete.DeleteReviewResult;
import com.tinqin.academy.piim.data.repositories.ReviewRepository;
import io.vavr.control.Either;
import io.vavr.control.Try;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;

@RequiredArgsConstructor
@Service
public class DeleteReviewOperationProcessor implements DeleteReviewOperation {
    private final ReviewRepository reviewRepository;

    @Override
    public Either<PiimError, DeleteReviewResult> process(DeleteReviewInput input) {
        return Try.of(() -> {
                    if (input.getId() <= 0) throw new InvalidParameterException("Review id is invalid.");
                    if (!reviewRepository.existsById(input.getId()))
                        throw new EntityNotFoundException(
                                String.format("Review with id %d does not exist.", input.getId()));

                    reviewRepository.deleteById(input.getId());

                    return DeleteReviewResult.builder().success(true).build();
                })
                .toEither()
                .mapLeft(throwable -> {
                    return new DeleteReviewError(400, throwable.getMessage());
                });
    }
}
