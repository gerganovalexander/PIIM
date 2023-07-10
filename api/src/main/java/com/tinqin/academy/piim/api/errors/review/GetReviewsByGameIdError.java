package com.tinqin.academy.piim.api.errors.review;

import com.tinqin.academy.piim.api.errors.GenericError;

public class GetReviewsByGameIdError extends GenericError {
    public GetReviewsByGameIdError(Integer statusCode, String message) {
        super(statusCode, message);
    }
}
