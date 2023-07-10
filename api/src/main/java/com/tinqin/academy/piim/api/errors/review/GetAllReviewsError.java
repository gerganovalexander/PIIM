package com.tinqin.academy.piim.api.errors.review;

import com.tinqin.academy.piim.api.errors.GenericError;

public class GetAllReviewsError extends GenericError {
    public GetAllReviewsError(Integer statusCode, String message) {
        super(statusCode, message);
    }
}
