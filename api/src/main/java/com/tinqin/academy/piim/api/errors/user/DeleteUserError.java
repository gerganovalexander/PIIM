package com.tinqin.academy.piim.api.errors.user;

import com.tinqin.academy.piim.api.errors.GenericError;

public class DeleteUserError extends GenericError {
    public DeleteUserError(Integer statusCode, String message) {
        super(statusCode, message);
    }
}
