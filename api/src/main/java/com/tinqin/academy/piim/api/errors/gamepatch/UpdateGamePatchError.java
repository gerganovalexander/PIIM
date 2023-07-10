package com.tinqin.academy.piim.api.errors.gamepatch;

import com.tinqin.academy.piim.api.errors.GenericError;

public class UpdateGamePatchError extends GenericError {
    public UpdateGamePatchError(Integer statusCode, String message) {
        super(statusCode, message);
    }
}
