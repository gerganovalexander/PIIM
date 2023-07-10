package com.tinqin.academy.piim.api.errors.game;

import com.tinqin.academy.piim.api.errors.GenericError;

public class GetAllGamesByCategoryNameError extends GenericError {
    public GetAllGamesByCategoryNameError(Integer statusCode, String message) {
        super(statusCode, message);
    }
}
