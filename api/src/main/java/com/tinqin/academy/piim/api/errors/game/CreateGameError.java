package com.tinqin.academy.piim.api.errors.game;

import com.tinqin.academy.piim.api.errors.GenericError;

public class CreateGameError extends GenericError {
    public CreateGameError(Integer statusCode, String message) {
        super(statusCode, message);
    }
}
