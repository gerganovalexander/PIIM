package com.tinqin.academy.piim.api.errors.game;

import com.tinqin.academy.piim.api.errors.GenericError;

public class DeleteGameError extends GenericError {
    public DeleteGameError(Integer statusCode, String message) {
        super(statusCode, message);
    }
}
