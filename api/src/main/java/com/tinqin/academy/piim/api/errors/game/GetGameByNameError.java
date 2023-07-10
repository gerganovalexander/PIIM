package com.tinqin.academy.piim.api.errors.game;

import com.tinqin.academy.piim.api.errors.GenericError;

public class GetGameByNameError extends GenericError {
    public GetGameByNameError(Integer statusCode, String message) {
        super(statusCode, message);
    }
}
