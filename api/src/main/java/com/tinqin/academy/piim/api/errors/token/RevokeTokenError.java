package com.tinqin.academy.piim.api.errors.token;

import com.tinqin.academy.piim.api.errors.GenericError;

public class RevokeTokenError extends GenericError {

    public RevokeTokenError(Integer statusCode, String message) {
        super(statusCode, message);
    }
}
