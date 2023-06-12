package com.tinqin.academy.piim.services;

import com.tinqin.academy.piim.exceptions.EntityNotFoundException;
import com.tinqin.academy.piim.models.Review;
import com.tinqin.academy.piim.repositories.ReviewRepository;
import com.tinqin.academy.piim.services.contracts.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;

    @Override
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    @Override
    public Review getReviewById(long id) {
        return reviewRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Review not found"));
    }

    @Override
    public Review createReview(Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public Review updateReview(long id, Review review) {
        Optional<Review> optionalReview = reviewRepository.findById(id);
        if (optionalReview.isPresent()) {
            Review reviewToUpdate = optionalReview.get();
            reviewToUpdate.setText(review.getText());
            reviewToUpdate.setScore(review.getScore());
            return reviewRepository.save(reviewToUpdate);
        } else {
            throw new IllegalArgumentException(String.format("Review with ID:%s not found", id));
        }
    }

    @Override
    public void deleteReview(long id) {
        reviewRepository.deleteById(id);
    }
}
