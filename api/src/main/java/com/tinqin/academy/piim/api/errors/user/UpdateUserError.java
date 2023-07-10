package com.tinqin.academy.piim.api.errors.user;

import com.tinqin.academy.piim.api.errors.GenericError;

public class UpdateUserError extends GenericError {
    public UpdateUserError(Integer statusCode, String message) {
        super(statusCode, message);
    }
}
