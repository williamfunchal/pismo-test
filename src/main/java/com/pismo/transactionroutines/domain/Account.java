package com.pismo.transactionroutines.domain;

import javax.persistence.*;

@Entity
@Table(name = "Accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountID;

    private Long documentNumber;

    public Account(){

    }

    public Account(Long accountID, Long documentNumber){
        this.accountID = accountID;
        this.documentNumber = documentNumber;
    }

    /**
     * @return the accountID
     */
    public Long getAccountId() {
        return accountID;
    }

    /**
     * @param accountID the accountID to set
     */
    public void setId(Long accountID) {
        this.accountID = accountID;
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