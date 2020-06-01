package com.pismo.transactionroutines.services;

import java.util.Date;

import com.pismo.transactionroutines.domain.Transaction;
import com.pismo.transactionroutines.repositories.TransactionsRepository;
import com.pismo.transactionroutines.services.interfaces.AccountService;

import com.pismo.transactionroutines.services.interfaces.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionsServiceImpl implements TransactionService {

    private TransactionsRepository transactionsRepository;

    @Autowired
    public TransactionsServiceImpl(TransactionsRepository transactionsRepository) {
        this.transactionsRepository = transactionsRepository;
    }

    public Transaction insert(Transaction transaction) {
        if (transaction == null)
            throw new RuntimeException();

        transaction.setEventDate(new Date());

        return transactionsRepository.save(transaction);
    }

}