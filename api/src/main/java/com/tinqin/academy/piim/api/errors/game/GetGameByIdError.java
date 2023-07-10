package com.tinqin.academy.piim.api.errors.game;

import com.tinqin.academy.piim.api.errors.GenericError;

public class GetGameByIdError extends GenericError {
    public GetGameByIdError(Integer statusCode, String message) {
        super(statusCode, message);
    }
}
