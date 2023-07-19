package com.tinqin.academy.piim.api.errors.token;

import com.tinqin.academy.piim.api.errors.GenericError;

public class FindByTokenError extends GenericError {

    public FindByTokenError(Integer statusCode, String message) {
        super(statusCode, message);
    }
}
