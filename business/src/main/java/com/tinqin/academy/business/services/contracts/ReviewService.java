package com.tinqin.academy.business.services.contracts;

import com.tinqin.academy.data.models.Review;

import java.util.List;

public interface ReviewService {

    List<Review> getAllReviews();

    Review getReviewById(long id);

    Review createReview(Review review);

    Review updateReview(long id, Review review);

    void deleteReview(long id);

}
