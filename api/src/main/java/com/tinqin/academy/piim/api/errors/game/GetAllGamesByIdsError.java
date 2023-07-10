package com.tinqin.academy.piim.api.errors.game;

import com.tinqin.academy.piim.api.errors.GenericError;

public class GetAllGamesByIdsError extends GenericError {
    public GetAllGamesByIdsError(Integer statusCode, String message) {
        super(statusCode, message);
    }
}
