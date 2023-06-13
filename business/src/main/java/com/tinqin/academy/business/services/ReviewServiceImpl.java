package com.tinqin.academy.business.services;

import com.tinqin.academy.business.services.contracts.ReviewService;
import com.tinqin.academy.data.models.Review;
import com.tinqin.academy.data.repositories.ReviewRepository;
import jakarta.persistence.EntityNotFoundException;
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
