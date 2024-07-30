package com.cg.dsTraining.Entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
@Table(name="Account_Entity")
public class AccountEntity {
   
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name ="ac_id")
	private int acId;
	@Column(name ="account_number")
	private int accountNumber;
	@Column(name ="account_type")
	private String accountType;
	@Column(name ="account_balance")
	private double accountBalance;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private CustomerEntity customerEntity;
	
	@OneToMany(mappedBy = "accountEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<TransactionEntity> transactions;
	
 public AccountEntity(int acId, int accountNumber, String accountType, double accountBalance,
			CustomerEntity customerEntity, List<TransactionEntity> transactions) {
		super();
		this.acId = acId;
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.accountBalance = accountBalance;
		this.customerEntity = customerEntity;
		this.transactions = transactions;
	}

   
	
	public AccountEntity() {
	super();
	// TODO Auto-generated constructor stub
   }



	public CustomerEntity getCustomerEntity() {
		return customerEntity;
	}

	public void setCustomerEntity(CustomerEntity customerEntity) {
		this.customerEntity = customerEntity;
	}

	public int getAcId() {
		return acId;
	}

	public void setAcId(int acId) {
		this.acId = acId;
	}
	
	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	
	
	public List<TransactionEntity> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<TransactionEntity> transactions) {
		this.transactions = transactions;
	}

	@Override
	public String toString() {
		return "AccountEntity [acId=" + acId + ", accountNumber=" + accountNumber + ", accountType=" + accountType
				+ ", accountBalance=" + accountBalance + ", customerEntity=" + customerEntity + ", transactions="
				+ transactions + "]";
	}
	
	
}

