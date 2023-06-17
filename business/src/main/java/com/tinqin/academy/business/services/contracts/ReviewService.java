package com.tinqin.academy.business.services.contracts;

import com.tinqin.academy.data.models.Review;

public interface ReviewService {


    Review getReviewById(long id);

    Review createReview(Review review);

    Review updateReview(long id, Review review);

    void deleteReview(long id);

}
