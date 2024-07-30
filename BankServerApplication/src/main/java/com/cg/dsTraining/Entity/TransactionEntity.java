package com.cg.dsTraining.Entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Transaction_Entity")
public class TransactionEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name ="transection_Id")
	private int transectionId;
	@Column(name ="transection_type")
	private String transectionType;
	@Column(name ="transection_date")
	private Date transectionDate;
	@Column(name ="transection_amount")
	private double transectionAmount;
	@Column(name ="transection_status")
	private String transectionStatus;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_number") 
    private AccountEntity accountEntity;
	
	public TransactionEntity(int transectionId, String transectionType, Date transectionDate, double transectionAmount,
			String transectionStatus, AccountEntity accountEntity) {
		super();
		this.transectionId = transectionId;
		this.transectionType = transectionType;
		this.transectionDate = transectionDate;
		this.transectionAmount = transectionAmount;
		this.transectionStatus = transectionStatus;
		this.accountEntity = accountEntity;
	}

	public TransactionEntity() {
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

	public AccountEntity getAccountNumber() {
		return accountEntity;
	}

	public void setAccountEntity(AccountEntity accountEntity) {
		this.accountEntity = accountEntity;
	}

	@Override
	public String toString() {
		return "TransactionEntity [transectionId=" + transectionId + ", transectionType=" + transectionType
				+ ", transectionDate=" + transectionDate + ", transectionAmount=" + transectionAmount
				+ ", transectionStatus=" + transectionStatus + ", accountEntity=" + accountEntity + "]";
	}
	
}
