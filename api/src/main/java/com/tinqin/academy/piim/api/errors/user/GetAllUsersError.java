package com.tinqin.academy.piim.api.errors.user;

import com.tinqin.academy.piim.api.errors.GenericError;

public class GetAllUsersError extends GenericError {
    public GetAllUsersError(Integer statusCode, String message) {
        super(statusCode, message);
    }
}
