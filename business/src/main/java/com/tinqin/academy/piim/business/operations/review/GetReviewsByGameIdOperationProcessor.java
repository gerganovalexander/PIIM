package com.tinqin.academy.piim.business.operations.review;

import com.tinqin.academy.piim.api.entityoutputmodels.ReviewOutput;
import com.tinqin.academy.piim.api.review.getreviewsbygameid.GetReviewsByGameIdInput;
import com.tinqin.academy.piim.api.review.getreviewsbygameid.GetReviewsByGameIdOperation;
import com.tinqin.academy.piim.api.review.getreviewsbygameid.GetReviewsByGameIdResult;
import com.tinqin.academy.piim.data.repositories.GameRepository;
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
    public GetReviewsByGameIdResult process(final GetReviewsByGameIdInput input) {

        List<ReviewOutput> reviews = gameRepository
                .findById(input.getId())
                .orElseThrow(() -> new EntityNotFoundException("Game not found"))
                .getListOfReviews()
                .stream()
                .map(review -> conversionService.convert(review, ReviewOutput.class))
                .toList();

        return new GetReviewsByGameIdResult(reviews);
    }
}
