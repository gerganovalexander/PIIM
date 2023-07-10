package com.tinqin.academy.piim.api.errors.gamepatch;

import com.tinqin.academy.piim.api.errors.GenericError;

public class DeleteGamePatchError extends GenericError {
    public DeleteGamePatchError(Integer statusCode, String message) {
        super(statusCode, message);
    }
}
