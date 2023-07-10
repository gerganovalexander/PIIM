package com.tinqin.academy.piim.api.errors.game;

import com.tinqin.academy.piim.api.errors.GenericError;

public class UpdateGameError extends GenericError {
    public UpdateGameError(Integer statusCode, String message) {
        super(statusCode, message);
    }
}
