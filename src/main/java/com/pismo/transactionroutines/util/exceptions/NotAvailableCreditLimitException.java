package com.pismo.transactionroutines.util.exceptions;

public class NotAvailableCreditLimitException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public NotAvailableCreditLimitException(String exception) {
        super(exception);
    }

}