package com.tinqin.academy.piim.business.operations.review;

import com.tinqin.academy.piim.api.review.existsbyid.ExistsByIdReviewInput;
import com.tinqin.academy.piim.api.review.existsbyid.ExistsByIdReviewOperation;
import com.tinqin.academy.piim.api.review.existsbyid.ExistsByIdReviewResult;
import com.tinqin.academy.piim.data.repositories.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExistsByIdReviewOperationProcessor implements ExistsByIdReviewOperation {
    private final ReviewRepository reviewRepository;

    @Override
    public ExistsByIdReviewResult process(ExistsByIdReviewInput input) {
        boolean doesExist = reviewRepository.existsById(input.getId());
        return ExistsByIdReviewResult.builder().doesExist(doesExist).build();
    }
}
