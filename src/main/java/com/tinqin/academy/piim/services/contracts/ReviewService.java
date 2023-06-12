package com.tinqin.academy.piim.services.contracts;

import com.tinqin.academy.piim.models.Review;

import java.util.List;

public interface ReviewService {

    List<Review> getAllReviews();

    Review getReviewById(long id);

    void createReview(Review review);

    void updateReview(long id, Review review);

    void deleteReview(long id);

}
