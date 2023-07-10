package com.tinqin.academy.piim.api.errors.systemrequirements;

import com.tinqin.academy.piim.api.errors.GenericError;

public class GetSystemRequirementsByIdError extends GenericError {
    public GetSystemRequirementsByIdError(Integer statusCode, String message) {
        super(statusCode, message);
    }
}
