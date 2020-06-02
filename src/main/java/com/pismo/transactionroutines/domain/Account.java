package com.pismo.transactionroutines.domain;

import javax.persistence.*;

@Entity
@Table(name = "Accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;

    private Long documentNumber;

    public Account(){

    }

    public Account(Long accountID, Long documentNumber){
        this.accountId = accountId;
        this.documentNumber = documentNumber;
    }

    /**
     * @return the accountID
     */
    public Long getAccountId() {
        return accountId;
    }

    /**
     * @param accountID the accountID to set
     */
    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    /**
     * @return the documentNumber
     */
    public long getDocumentNumber() {
        return documentNumber;
    }

    /**
     * @param documentNumber the documentNumber to set
     */
    public void setDocumentNumber(long documentNumber) {
        this.documentNumber = documentNumber;
    }
}