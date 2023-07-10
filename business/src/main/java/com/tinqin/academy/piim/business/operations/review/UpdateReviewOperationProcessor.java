package com.tinqin.academy.piim.business.operations.review;

import com.tinqin.academy.piim.api.errors.review.UpdateReviewError;
import com.tinqin.academy.piim.api.generics.PiimError;
import com.tinqin.academy.piim.api.review.update.UpdateReviewInput;
import com.tinqin.academy.piim.api.review.update.UpdateReviewOperation;
import com.tinqin.academy.piim.api.review.update.UpdateReviewResult;
import com.tinqin.academy.piim.data.models.Review;
import com.tinqin.academy.piim.data.repositories.ReviewRepository;
import io.vavr.control.Either;
import io.vavr.control.Try;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;

@RequiredArgsConstructor
@Service
public class UpdateReviewOperationProcessor implements UpdateReviewOperation {
    private final ReviewRepository reviewRepository;
    private final ConversionService conversionService;

    @Override
    public Either<PiimError, UpdateReviewResult> process(UpdateReviewInput input) {
        return Try.of(() -> {
                    if (input.getId() <= 0) throw new InvalidParameterException("Review id is invalid.");
                    if (!reviewRepository.existsById(input.getId()))
                        throw new EntityNotFoundException(
                                String.format("Review with id %d does not exist.", input.getId()));

                    Review reviewFromRepo = reviewRepository.getById(input.getId());

                    Review review = Review.builder()
                            .id(input.getId())
                            .text(input.getText())
                            .score(reviewFromRepo.getScore())
                            .createdAt(reviewFromRepo.getCreatedAt())
                            .user(reviewFromRepo.getUser())
                            .build();

                    reviewRepository.save(review);

                    return conversionService.convert(review, UpdateReviewResult.class);
                })
                .toEither()
                .mapLeft(throwable -> {
                    return new UpdateReviewError(400, throwable.getMessage());
                });
    }
}
