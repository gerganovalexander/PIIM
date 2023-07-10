package com.tinqin.academy.piim.api.errors;

import com.tinqin.academy.piim.api.generics.PiimError;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public abstract class GenericError implements PiimError {

    private final Integer statusCode;
    private final String message;
}
