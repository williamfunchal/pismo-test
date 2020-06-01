package com.pismo.transactionroutines.repositories;

import com.pismo.transactionroutines.domain.Account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountsRepository extends JpaRepository<Account, Long> {

    @Query(value = "SELECT Account_ID, Document_Number FROM Accounts a WHERE a.Account_ID = :accountIDParam", nativeQuery = true)
    Account getByAccountID(@Param("accountIDParam") Long accountID);

}