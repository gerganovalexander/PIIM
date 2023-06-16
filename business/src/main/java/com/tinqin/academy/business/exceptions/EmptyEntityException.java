package com.tinqin.academy.business.exceptions;

public class EmptyEntityException extends RuntimeException {
    public EmptyEntityException(String message) {
        super(message);
    }
}
