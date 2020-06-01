package com.pismo.transactionroutines.services.interfaces;

import com.pismo.transactionroutines.domain.Account;

import com.pismo.transactionroutines.domain.Transaction;
import org.springframework.stereotype.Service;

@Service
public interface TransactionService {
    Transaction insert(Transaction transaction);
}