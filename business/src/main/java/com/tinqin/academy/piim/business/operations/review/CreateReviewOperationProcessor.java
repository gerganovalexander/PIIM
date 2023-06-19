package com.tinqin.academy.piim.business.operations.review;


import com.tinqin.academy.piim.api.entityoutputmodels.ReviewOutput;
import com.tinqin.academy.piim.api.review.create.CreateReviewInput;
import com.tinqin.academy.piim.api.review.create.CreateReviewOperation;
import com.tinqin.academy.piim.api.review.create.CreateReviewResult;
import com.tinqin.academy.piim.data.models.Review;
import com.tinqin.academy.piim.data.models.User;
import com.tinqin.academy.piim.data.repositories.ReviewRepository;
import com.tinqin.academy.piim.data.repositories.UserRepository;
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
