package com.tinqin.academy.piim.api.errors.systemrequirements;

import com.tinqin.academy.piim.api.errors.GenericError;

public class GetAllSystemRequirementsError extends GenericError {
    public GetAllSystemRequirementsError(Integer statusCode, String message) {
        super(statusCode, message);
    }
}
