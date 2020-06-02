package com.pismo.transactionroutines.util.exceptions;

public class AccountNotInformedException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public AccountNotInformedException(String exception) {
        super(exception);
    }

}