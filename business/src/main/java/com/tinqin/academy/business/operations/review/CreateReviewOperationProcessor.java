package com.tinqin.academy.business.operations.review;


import com.tinqin.academy.api.entityoutputmodels.ReviewOutput;
import com.tinqin.academy.api.review.create.CreateReviewInput;
import com.tinqin.academy.api.review.create.CreateReviewOperation;
import com.tinqin.academy.api.review.create.CreateReviewResult;
import com.tinqin.academy.data.models.Review;
import com.tinqin.academy.data.models.User;
import com.tinqin.academy.data.repositories.ReviewRepository;
import com.tinqin.academy.data.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CreateReviewOperationProcessor implements CreateReviewOperation {
    private final ConversionService conversionService;
    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;

    @Override
    public CreateReviewResult process(CreateReviewInput input) {

        User user = userRepository.findById(input.getUserId())
                .orElseThrow(() -> new EntityNotFoundException("User with this Id does not exist."));

        Review review = Review.builder()
                .text(input.getText())
                .score(input.getScore())
                .user(user)
                .build();


        review = reviewRepository.save(review);

        return CreateReviewResult.builder()
                .reviewOutput(conversionService.convert(review, ReviewOutput.class))
                .build();
    }
}
