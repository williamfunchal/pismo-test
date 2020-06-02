package com.pismo.transactionroutines.services;

import java.util.Date;

import com.pismo.transactionroutines.domain.Account;
import com.pismo.transactionroutines.domain.Transaction;
import com.pismo.transactionroutines.repositories.AccountsRepository;
import com.pismo.transactionroutines.repositories.TransactionsRepository;
import com.pismo.transactionroutines.services.interfaces.AccountService;

import com.pismo.transactionroutines.services.interfaces.TransactionService;
import com.pismo.transactionroutines.util.exceptions.AccountNotFoundException;
import com.pismo.transactionroutines.util.exceptions.AccountNotInformedException;
import com.pismo.transactionroutines.util.exceptions.NotAvailableCreditLimitException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionsServiceImpl implements TransactionService {

    private TransactionsRepository transactionsRepository;
    private AccountsRepository accountsRepository;

    @Autowired
    public TransactionsServiceImpl(TransactionsRepository transactionsRepository, AccountsRepository accountsRepository) {
        this.transactionsRepository = transactionsRepository;
        this.accountsRepository = accountsRepository;
    }

    public Transaction insert(Transaction transaction) {
        if (transaction == null)
            throw new RuntimeException();

        if(transaction.getAccountId() == null)
            throw new AccountNotInformedException("Account not Informed.");

        Account a = accountsRepository.getByAccountId(transaction.getAccountId());

        if(a == null)
            throw new AccountNotFoundException("Account not found.");

        if(transaction.getAmmount() > a.getAvailableCreditLimit())
            throw new NotAvailableCreditLimitException("Credit Limit not Available");

        transaction.setEventDate(new Date());

        a.setAvailableCreditLimit(a.getAvailableCreditLimit() - transaction.getAmmount());

        Transaction t = transactionsRepository.save(transaction);
        accountsRepository.save(a);

        return t;
    }

}