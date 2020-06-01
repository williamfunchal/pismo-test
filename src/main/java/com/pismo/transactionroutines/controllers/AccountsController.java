package com.pismo.transactionroutines.controllers;

import com.pismo.transactionroutines.domain.Account;
import com.pismo.transactionroutines.services.interfaces.AccountService;
import com.pismo.transactionroutines.util.exceptions.AccountNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/accounts")
public class AccountsController {

    private AccountService accountService;

    @Autowired
    public AccountsController(AccountService accountService) {
        this.accountService = accountService;
    }

    @RequestMapping(value = "/{accountID}", method = RequestMethod.GET)
    public Account getByAccountID(@PathVariable Long accountID) {
        try {
            return accountService.getByAccountID(accountID);

        } catch (AccountNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Account Not Found", e);
        }
    }

    @PostMapping
    public Account insert(@RequestBody Account account) {
        try {
            return accountService.insert(account);
        } catch (AccountNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Account Not Found", e);
        }
    }
}