package com.tinqin.academy.piim.api.errors.review;

import com.tinqin.academy.piim.api.errors.GenericError;

public class GetByIdReviewError extends GenericError {
    public GetByIdReviewError(Integer statusCode, String message) {
        super(statusCode, message);
    }
}
