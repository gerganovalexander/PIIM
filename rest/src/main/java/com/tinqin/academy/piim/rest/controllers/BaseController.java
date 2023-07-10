package com.tinqin.academy.piim.rest.controllers;

import com.tinqin.academy.piim.api.generics.PiimError;
import io.vavr.control.Either;
import org.springframework.http.ResponseEntity;

public abstract class BaseController {

    protected ResponseEntity<?> handleOperation(final Either<PiimError, ?> result) {
        if (result.isLeft()) {
            return ResponseEntity.status(result.getLeft().getStatusCode()).body(result.getLeft());
        }
        return ResponseEntity.status(200).body(result.get());
    }
}
