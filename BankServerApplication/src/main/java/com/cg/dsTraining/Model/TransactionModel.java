package com.cg.dsTraining.Model;

import java.util.Date;

import com.cg.dsTraining.*;
import com.cg.dsTraining.Entity.AccountEntity;

public class TransactionModel {

	private int transectionId;
	private String transectionType;
	private Date transectionDate;
	private double transectionAmount;
	private String transectionStatus;
	private AccountEntity account;
	
	public TransactionModel(int transectionId, String transectionType, Date transectionDate, double transectionAmount,
			String transectionStatus, AccountEntity account) {
		super();
		this.transectionId = transectionId;
		this.transectionType = transectionType;
		this.transectionDate = transectionDate;
		this.transectionAmount = transectionAmount;
		this.transectionStatus = transectionStatus;
		this.account = account;
	}

	public TransactionModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getTransectionId() {
		return transectionId;
	}

	public void setTransectionId(int transectionId) {
		this.transectionId = transectionId;
	}

	public String getTransectionType() {
		return transectionType;
	}

	public void setTransectionType(String transectionType) {
		this.transectionType = transectionType;
	}

	public Date getTransectionDate() {
		return transectionDate;
	}

	public void setTransectionDate(Date transectionDate) {
		this.transectionDate = transectionDate;
	}

	public double getTransectionAmount() {
		return transectionAmount;
	}

	public void setTransectionAmount(double transectionAmount) {
		this.transectionAmount = transectionAmount;
	}

	public String getTransectionStatus() {
		return transectionStatus;
	}

	public void setTransectionStatus(String transectionStatus) {
		this.transectionStatus = transectionStatus;
	}

	public AccountEntity getAccount() {
		return account;
	}

	public void setAccount(AccountEntity account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "Transaction [transectionId=" + transectionId + ", transectionType=" + transectionType
				+ ", transectionDate=" + transectionDate + ", transectionAmount=" + transectionAmount
				+ ", transectionStatus=" + transectionStatus + ", account=" + account + "]";
	}
	
	
	
}
