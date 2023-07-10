package com.tinqin.academy.piim.api.errors.user;

import com.tinqin.academy.piim.api.errors.GenericError;

public class CreateUserError extends GenericError {

    public CreateUserError(Integer statusCode, String message) {
        super(statusCode, message);
    }
}
