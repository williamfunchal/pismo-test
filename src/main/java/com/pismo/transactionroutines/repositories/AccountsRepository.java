package com.pismo.transactionroutines.repositories;

import com.pismo.transactionroutines.domain.Account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountsRepository extends CrudRepository<Account, Long> {

    @Query(value = "SELECT account_id, document_number FROM accounts a WHERE a.account_id = :accountIdParam", nativeQuery = true)
    Account getByAccountId(@Param("accountIdParam") Long accountId);

    @Query(value = "SELECT account_id, document_number FROM accounts a WHERE a.document_number = :documentNumberParam", nativeQuery = true)
    Account getByDocumentNumber(@Param("documentNumberParam") Long documentNumber);

}