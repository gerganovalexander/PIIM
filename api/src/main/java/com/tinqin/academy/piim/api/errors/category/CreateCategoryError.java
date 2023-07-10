package com.tinqin.academy.piim.api.errors.category;

import com.tinqin.academy.piim.api.errors.GenericError;

public class CreateCategoryError extends GenericError {

    public CreateCategoryError(Integer statusCode, String message) {
        super(statusCode, message);
    }
}
