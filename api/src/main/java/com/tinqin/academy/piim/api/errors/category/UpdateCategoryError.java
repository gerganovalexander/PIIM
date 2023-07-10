package com.tinqin.academy.piim.api.errors.category;

import com.tinqin.academy.piim.api.errors.GenericError;

public class UpdateCategoryError extends GenericError {
    public UpdateCategoryError(Integer statusCode, String message) {
        super(statusCode, message);
    }
}
