package com.pismo.transactionroutines.util.exceptions;

public class LimitNotSetException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public LimitNotSetException(String exception) {
        super(exception);
    }

}