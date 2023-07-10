package com.tinqin.academy.piim.api.errors.category;

import com.tinqin.academy.piim.api.errors.GenericError;

public class GetAllCategoryError extends GenericError {
    public GetAllCategoryError(Integer statusCode, String message) {
        super(statusCode, message);
    }
}
