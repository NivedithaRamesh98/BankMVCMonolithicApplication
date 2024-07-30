package com.cg.dsTraining.Service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.cg.dsTraining.Entity.AccountEntity;
import com.cg.dsTraining.Entity.TransactionEntity;

@Service
public interface AcountService {

    public double getAccountBalanceByAccountNumber(int id);
    public AccountEntity addAccountDetails(AccountEntity accountDetails);
	List<AccountEntity> getAccountDetails();

	public AccountEntity getAccountDetails(int accountNumber);
	
	public TransactionEntity transfer(int fromAccountId, int toAccountId, double transferAmount);
	TransactionEntity withdraw(int accountNumber, double withdrawAmount);
	TransactionEntity deposit(int accountNumber, double depositeAmount);
	
}
