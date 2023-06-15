package com.tinqin.academy.api.generics;

public interface OperationInterface<I extends OperationInput, R extends OperationResult> {
    R process(I input);

}
