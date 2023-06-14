package com.tinqin.academy.api.generics;

public interface OperationProcessor<I extends OperationInput, R extends OperationResult> {
    R process(I input);

}
