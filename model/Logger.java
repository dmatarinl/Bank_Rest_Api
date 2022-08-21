package io.bankapp.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.Instant;

    /*Comment Section */
//Creation of the class Logger
//As per the ID of the user, we will show what kind of transaction had, if it was possible to make it,
//The increase or decrease of the balance and the instant time the customer made it.

@Entity
public class Logger {

	@Id
	private int acctID;

	private String transacType;
	private String transacStatus;

	private int initBal;
	private int finalBal;

	private Instant dateTime;

	public Logger() {

	}

	public Logger(int acctID, String transacType, String transacStatus, int initBal, int finalBal, Instant dateTimeInstant) {
		super();
		this.acctID = acctID;

		this.transacType = transacType;
		this.transacStatus = transacStatus;

		this.initBal = initBal;
		this.finalBal = finalBal;

		this.dateTime = dateTimeInstant;
	}

	public int getAcctID() {

		return acctID;

	}

	public void setAcctID(int acctID) {

		this.acctID = acctID;

	}

	public String getTransacType() {

		return transacType;

	}

	public void setTransacType(String transacType) {

		this.transacType = transacType;

	}

	public String getTransacStatus() {

		return transacStatus;

	}

	public void setTransacStatus(String transacStatus) {

		this.transacStatus = transacStatus;

	}

	public int getInitBal() {

		return initBal;

	}

	public void setInitBal(int initBal) {

		this.initBal = initBal;

	}

	public int getFinalBal() {

		return finalBal;

	}

	public void setFinalBal(int finalBal) {

		this.finalBal = finalBal;

	}

	public Instant getDateTime() {

		return dateTime;

	}

	public void setDateTime(Instant dateTimeInstant) {

		this.dateTime = dateTimeInstant;

	}
}
