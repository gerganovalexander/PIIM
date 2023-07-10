package com.tinqin.academy.piim.api.errors.game;

import com.tinqin.academy.piim.api.errors.GenericError;

public class ExistsByIdGameError extends GenericError {
    public ExistsByIdGameError(Integer statusCode, String message) {
        super(statusCode, message);
    }
}
