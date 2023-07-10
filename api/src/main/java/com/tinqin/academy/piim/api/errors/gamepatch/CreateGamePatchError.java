package com.tinqin.academy.piim.api.errors.gamepatch;

import com.tinqin.academy.piim.api.errors.GenericError;

public class CreateGamePatchError extends GenericError {
    public CreateGamePatchError(Integer statusCode, String message) {
        super(statusCode, message);
    }
}
