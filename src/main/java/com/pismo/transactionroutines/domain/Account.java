package com.pismo.transactionroutines.domain;

import javax.persistence.*;

@Entity
@Table(name = "Accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long accountId;

    private long documentNumber;

    private float availableCreditLimit;

    public Account(){

    }

    public Account(long accountId, long documentNumber, float availableCreditLimit){
        this.accountId = accountId;
        this.documentNumber = documentNumber;
        this.availableCreditLimit = availableCreditLimit;
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


    /**
     * @return the availableCreditLimit
     */

    public float getAvailableCreditLimit() {
        return availableCreditLimit;
    }

    /**
     * @param availableCreditLimit the documentNumber to set
     */
    public void setAvailableCreditLimit(float availableCreditLimit) {
        this.availableCreditLimit = availableCreditLimit;
    }
}