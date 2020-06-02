package com.pismo.transactionroutines.util.exceptions;

public class AccountAlreadyExistsException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public AccountAlreadyExistsException(String exception) {
        super(exception);
    }

}