package com.tinqin.academy.piim.api.generics;

public interface OperationInterface<I extends OperationInput, R extends OperationResult> {
    R process(I input);

}
