package com.tinqin.academy.piim.api.errors.user;

import com.tinqin.academy.piim.api.errors.GenericError;

public class GetUserByIdError extends GenericError {
    public GetUserByIdError(Integer statusCode, String message) {
        super(statusCode, message);
    }
}
