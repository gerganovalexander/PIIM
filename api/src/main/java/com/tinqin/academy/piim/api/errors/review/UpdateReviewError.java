package com.tinqin.academy.piim.api.errors.review;

import com.tinqin.academy.piim.api.errors.GenericError;

public class UpdateReviewError extends GenericError {
    public UpdateReviewError(Integer statusCode, String message) {
        super(statusCode, message);
    }
}
