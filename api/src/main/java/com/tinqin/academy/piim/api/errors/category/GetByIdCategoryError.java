package com.tinqin.academy.piim.api.errors.category;

import com.tinqin.academy.piim.api.errors.GenericError;

public class GetByIdCategoryError extends GenericError {
    public GetByIdCategoryError(Integer statusCode, String message) {
        super(statusCode, message);
    }
}
