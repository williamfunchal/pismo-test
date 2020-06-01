package com.pismo.transactionroutines.services.interfaces;

import com.pismo.transactionroutines.domain.Account;
import com.pismo.transactionroutines.domain.Transaction;

import org.springframework.stereotype.Service;

@Service
public interface AccountService {

    Account insert(Account account);
    Account getByAccountID(long accountId);
}