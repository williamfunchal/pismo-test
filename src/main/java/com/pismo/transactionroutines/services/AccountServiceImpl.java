package com.pismo.transactionroutines.services;

import com.pismo.transactionroutines.domain.Account;
import com.pismo.transactionroutines.repositories.AccountsRepository;
import com.pismo.transactionroutines.services.interfaces.AccountService;

import com.pismo.transactionroutines.util.exceptions.AccountAlreadyExistsException;
import com.pismo.transactionroutines.util.exceptions.AccountNotFoundException;
import com.pismo.transactionroutines.util.exceptions.LimitNotSetException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountsRepository accountsRepository;

    @Autowired
    public AccountServiceImpl(AccountsRepository accountsRepository) {
        this.accountsRepository = accountsRepository;
    }

    public Account getByAccountId(long accountId) {
        Account account = accountsRepository.getByAccountId(accountId);

        if (account == null)
            throw new AccountNotFoundException("Account not found");

        return account;
    }

    public Account insert(Account account) {
        if (account == null)
            throw new RuntimeException();

        if(account.getAvailableCreditLimit() <= 0)
            throw new LimitNotSetException("Limit was not defined for Account");

        if (accountsRepository.getByAccountId(account.getAccountId()) != null)
            throw new AccountAlreadyExistsException("Account Already Exists");

        return accountsRepository.save(account);
    }
}