package com.tinqin.academy.piim.api.errors.token;

import com.tinqin.academy.piim.api.errors.GenericError;

public class FindAllValidTokenByUserError extends GenericError {

    public FindAllValidTokenByUserError(Integer statusCode, String message) {
        super(statusCode, message);
    }
}
