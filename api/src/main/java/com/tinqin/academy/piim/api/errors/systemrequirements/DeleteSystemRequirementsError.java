package com.tinqin.academy.piim.api.errors.systemrequirements;

import com.tinqin.academy.piim.api.errors.GenericError;

public class DeleteSystemRequirementsError extends GenericError {
    public DeleteSystemRequirementsError(Integer statusCode, String message) {
        super(statusCode, message);
    }
}
