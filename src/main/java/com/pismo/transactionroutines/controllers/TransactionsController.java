package com.pismo.transactionroutines.controllers;

import com.pismo.transactionroutines.domain.Transaction;
import com.pismo.transactionroutines.services.interfaces.TransactionService;
import com.pismo.transactionroutines.util.exceptions.AccountNotFoundException;
import com.pismo.transactionroutines.util.exceptions.AccountNotInformedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/transactions")
public class TransactionsController {
    private TransactionService transactionService;

    @Autowired
    public TransactionsController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    public Transaction insert(@RequestBody Transaction transaction) {
        try {
            return transactionService.insert(transaction);
        } catch (AccountNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Account Not Found", e);
        } catch (AccountNotInformedException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Account Not Informed", e);
        }
    }
}