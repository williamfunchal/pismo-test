package com.pismo.transactionroutines.services;

import com.pismo.transactionroutines.domain.Account;
import com.pismo.transactionroutines.repositories.AccountsRepository;
import com.pismo.transactionroutines.services.interfaces.AccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountsRepository accountsRepository;

    @Autowired
    public AccountServiceImpl(AccountsRepository accountsRepository) {
        this.accountsRepository = accountsRepository;
    }

    public Account getByAccountID(long accountId) {
        return accountsRepository.getByAccountID(accountId);
    }

    public Account insert(Account account) {
        if (account == null)
            throw new RuntimeException();

        return accountsRepository.save(account);
    }
}