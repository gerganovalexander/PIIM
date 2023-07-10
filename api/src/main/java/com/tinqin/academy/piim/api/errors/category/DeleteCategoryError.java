package com.tinqin.academy.piim.api.errors.category;

import com.tinqin.academy.piim.api.errors.GenericError;

public class DeleteCategoryError extends GenericError {
    public DeleteCategoryError(Integer statusCode, String message) {
        super(statusCode, message);
    }
}
