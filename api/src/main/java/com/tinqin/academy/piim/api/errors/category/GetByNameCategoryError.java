package com.tinqin.academy.piim.api.errors.category;

import com.tinqin.academy.piim.api.errors.GenericError;

public class GetByNameCategoryError extends GenericError {
    public GetByNameCategoryError(Integer statusCode, String message) {
        super(statusCode, message);
    }
}
