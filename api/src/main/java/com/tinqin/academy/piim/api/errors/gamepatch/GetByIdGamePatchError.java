package com.tinqin.academy.piim.api.errors.gamepatch;

import com.tinqin.academy.piim.api.errors.GenericError;

public class GetByIdGamePatchError extends GenericError {
    public GetByIdGamePatchError(Integer statusCode, String message) {
        super(statusCode, message);
    }
}
