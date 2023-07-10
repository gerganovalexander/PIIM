package com.tinqin.academy.piim.api.errors.review;

import com.tinqin.academy.piim.api.errors.GenericError;

public class ExistsByIdReviewError extends GenericError {
    public ExistsByIdReviewError(Integer statusCode, String message) {
        super(statusCode, message);
    }
}
