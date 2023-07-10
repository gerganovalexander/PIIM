package com.tinqin.academy.piim.api.errors.systemrequirements;

import com.tinqin.academy.piim.api.errors.GenericError;

public class UpdateSystemRequirementsError extends GenericError {
    public UpdateSystemRequirementsError(Integer statusCode, String message) {
        super(statusCode, message);
    }
}
