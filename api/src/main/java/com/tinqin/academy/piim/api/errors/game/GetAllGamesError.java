package com.tinqin.academy.piim.api.errors.game;

import com.tinqin.academy.piim.api.errors.GenericError;

public class GetAllGamesError extends GenericError {
    public GetAllGamesError(Integer statusCode, String message) {
        super(statusCode, message);
    }
}
