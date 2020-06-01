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
    private Long transactionID;

    private Long ammount;

    private Date eventDate;

    private Long operationTypeID;

    private Long accountID;


    public Transaction(){
        
    }

    public Transaction(Long transactionID, Long ammount, Date eventDate, Long operationTypeID, Long accountID){
        this.transactionID = transactionID;
        this.ammount = ammount;
        this.eventDate = eventDate;
        this.operationTypeID = operationTypeID;
        this.accountID = accountID;
    }

    /**
     * @return the transactionID
     */
    public Long getTransactionID() {
        return transactionID;
    }

    /**
     * @param transactionID the transactionID to set
     */
    public void setId(Long transactionID) {
        this.transactionID = transactionID;
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
     * @return the operationTypeID
     */
    public Long getOperationTypeID() {
        return this.operationTypeID;
    }


    /**
     * @param operationTypeID the operationTypeID to set
     */
    public void setOperationTypeID(Long operationTypeID) {
        this.operationTypeID = operationTypeID;
    }

    /**
     * @return the accountID
     */
    public Long getAccountID() {
        return accountID;
    }

    /**
     * @param accountID the accountID to set
     */
    public void setAccountID(Long accountID) {
        this.accountID = accountID;
    }

}