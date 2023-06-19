package com.tinqin.academy.piim.business.operations.review;


import com.tinqin.academy.piim.api.review.delete.DeleteReviewInput;
import com.tinqin.academy.piim.api.review.delete.DeleteReviewOperation;
import com.tinqin.academy.piim.api.review.delete.DeleteReviewResult;
import com.tinqin.academy.piim.data.repositories.ReviewRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;

@RequiredArgsConstructor
@Service
public class DeleteReviewOperationProcessor implements DeleteReviewOperation {
    private final ReviewRepository reviewRepository;

    @Override
    public DeleteReviewResult process(DeleteReviewInput input) {

        if (input.getId() <= 0) throw new InvalidParameterException("Review id is invalid.");
        if (!reviewRepository.existsById(input.getId()))
            throw new EntityNotFoundException(String.format("Review with id %d does not exist.", input.getId()));

        reviewRepository.deleteById(input.getId());

        return DeleteReviewResult.builder()
                .success(true)
                .build();
    }
}
