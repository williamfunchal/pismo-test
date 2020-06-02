package com.pismo.transactionroutines.controllers;

import com.pismo.transactionroutines.domain.Account;
import com.pismo.transactionroutines.services.interfaces.AccountService;
import com.pismo.transactionroutines.util.exceptions.AccountAlreadyExistsException;
import com.pismo.transactionroutines.util.exceptions.AccountNotFoundException;
import com.pismo.transactionroutines.util.exceptions.LimitNotSetException;
import org.hibernate.HibernateException;
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
            return accountService.getByAccountId(accountID);

        }
        catch (AccountNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Account Not Found", e);
        }
        catch (AccountAlreadyExistsException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Account Already Exists", e);
        }
        catch (HibernateException e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Hibernate JPA Exception", e);
        }
        catch (RuntimeException e){
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "", e);
        }
    }

    @PostMapping
    public Account insert(@RequestBody Account account) {
        try {
            return accountService.insert(account);
        } catch (AccountNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Account Not Found", e);
        }
        catch (AccountAlreadyExistsException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Account Already Exists", e);
        }
        catch (LimitNotSetException e){
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Account Limit not Set", e);
        }
        catch (HibernateException e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Hibernate JPA Exception", e);
        }
        catch (RuntimeException e){
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "", e);
        }
    }
}