package com.tinqin.academy.piim.api.errors.gamepatch;

import com.tinqin.academy.piim.api.errors.GenericError;

public class GetAllGamePatchError extends GenericError {
    public GetAllGamePatchError(Integer statusCode, String message) {
        super(statusCode, message);
    }
}
