package com.pismo.transactionroutines.domain;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;

    private Long ammount;

    private Date eventDate;

    private Long operationTypeId;

    private Long accountId;


    public Transaction(){
        
    }

    public Transaction(Long transactionID, Long ammount, Date eventDate, Long operationTypeId, Long accountId){
        this.transactionId = transactionId;
        this.ammount = ammount;
        this.eventDate = eventDate;
        this.operationTypeId = operationTypeId;
        this.accountId = accountId;
    }

    /**
     * @return the transactionID
     */
    public Long getTransactionID() {
        return transactionId;
    }

    /**
     * @param transactionID the transactionID to set
     */
    public void setId(Long transactionID) {
        this.transactionId = transactionID;
    }

    /**
     * @return the ammount
     */
    public Long getAmmount() {
        return ammount;
    }

    /**
     * @param ammount the ammount to set
     */
    public void setAmmount(Long ammount) {
        this.ammount = ammount;
    }

    /**
     * @return the eventDate
     */
    public Date getEventDate() {
        return eventDate;
    }

    /**
     * @param eventDate the eventDate to set
     */
    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    /**
     * @return the operationTypeId
     */
    public Long getOperationTypeId() {
        return this.operationTypeId;
    }


    /**
     * @param operationTypeId the operationTypeId to set
     */
    public void setOperationTypeId(Long operationTypeId) {
        this.operationTypeId = operationTypeId;
    }

    /**
     * @return the accountId
     */
    public Long getAccountId() {
        return accountId;
    }

    /**
     * @param accountID the accountID to set
     */
    public void setAccountId(Long accountID) {
        this.accountId = accountId;
    }

}