package com.tinqin.academy.piim.api.errors.systemrequirements;

import com.tinqin.academy.piim.api.errors.GenericError;

public class CreateSystemRequirementsError extends GenericError {
    public CreateSystemRequirementsError(Integer statusCode, String message) {
        super(statusCode, message);
    }
}
