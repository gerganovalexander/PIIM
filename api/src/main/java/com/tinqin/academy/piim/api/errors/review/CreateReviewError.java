package com.tinqin.academy.piim.api.errors.review;

import com.tinqin.academy.piim.api.errors.GenericError;

public class CreateReviewError extends GenericError {
    public CreateReviewError(Integer statusCode, String message) {
        super(statusCode, message);
    }
}
