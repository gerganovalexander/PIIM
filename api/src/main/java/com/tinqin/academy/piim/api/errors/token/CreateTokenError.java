package com.tinqin.academy.piim.api.errors.token;

import com.tinqin.academy.piim.api.errors.GenericError;

public class CreateTokenError extends GenericError {

    public CreateTokenError(Integer statusCode, String message) {
        super(statusCode, message);
    }
}
