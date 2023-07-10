package com.tinqin.academy.piim.api.errors.review;

import com.tinqin.academy.piim.api.errors.GenericError;

public class DeleteReviewError extends GenericError {
    public DeleteReviewError(Integer statusCode, String message) {
        super(statusCode, message);
    }
}
