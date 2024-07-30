package com.cg.dsTraining.Entity;

import java.util.List;
import java.util.Set;

import javax.validation.constraints.NotBlank;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;


@Entity
public class CustomerEntity {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	private int customerId;
	private String customerName;
	private String customerEmailId;
	@NotBlank(message = "Username cannot be empty")
	private String userName;
	@NotBlank(message = "Password cannot be empty")
	private String password;
	
	@OneToMany(mappedBy ="customerEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<AccountEntity> accountEntity;

	public CustomerEntity(int id, int customerId, String customerName, String customerEmailId,
			@NotBlank(message = "Username cannot be empty") String userName,
			@NotBlank(message = "Password cannot be empty") String password, List<AccountEntity> accountEntity) {
		super();
		this.id = id;
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerEmailId = customerEmailId;
		this.userName = userName;
		this.password = password;
		this.accountEntity = accountEntity;
	}

	public CustomerEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerEmailId() {
		return customerEmailId;
	}

	public void setCustomerEmailId(String customerEmailId) {
		this.customerEmailId = customerEmailId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<AccountEntity> getAccountEntity() {
		return accountEntity;
	}

	public void setAccountEntity(List<AccountEntity> accountEntity) {
		this.accountEntity = accountEntity;
	}

	@Override
	public String toString() {
		return "CustomerEntity [id=" + id + ", customerId=" + customerId + ", customerName=" + customerName
				+ ", customerEmailId=" + customerEmailId + ", userName=" + userName + ", password=" + password
				+ ", accountEntity=" + accountEntity + "]";
	}

	
}
