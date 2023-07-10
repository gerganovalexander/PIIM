package com.tinqin.academy.piim.api.generics;

import io.vavr.control.Either;

public interface OperationInterface<I extends OperationInput, R extends OperationResult> {
    Either<PiimError, R> process(I input);
}
