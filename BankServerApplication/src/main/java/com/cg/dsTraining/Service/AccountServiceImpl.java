package com.cg.dsTraining.Service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.cg.dsTraining.Dao.AccountRepository;
import com.cg.dsTraining.Dao.TransactionRepository;
import com.cg.dsTraining.Entity.AccountEntity;
import com.cg.dsTraining.Entity.TransactionEntity;
import com.cg.dsTraining.Service.AcountService;

import jakarta.transaction.Transactional;

@Service
public class AccountServiceImpl implements AcountService {

	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private TransactionRepository transactionRepository;

	@Override
	public List<AccountEntity> getAccountDetails() {
		  //addAccountDetails(addDetails);
		return accountRepository.findAll();
	}

	@Override
	public AccountEntity addAccountDetails(AccountEntity accountDetails) {
		return accountRepository.save(accountDetails);
	}

	@Override
	public double getAccountBalanceByAccountNumber(int id) {
		return accountRepository.findAccountBalanceByAccountNumber(id);
	}

	@Override
	@Transactional
	public TransactionEntity deposit(int accountNumber, double depositeAmount) {
		AccountEntity account = accountRepository.findByAccountNumber(accountNumber);
		if (depositeAmount <=0) {
			return null;
		}
		account.setAccountBalance(account.getAccountBalance() + depositeAmount);
		accountRepository.save(account);

		TransactionEntity transaction = new TransactionEntity();
		transaction.setTransectionType("Deposit");
		transaction.setTransectionDate(new Date());
		transaction.setTransectionAmount(depositeAmount);
		transaction.setTransectionStatus("Success");
		transaction.setAccountEntity(account);
		//transaction.setAccountEntity(account);
		System.out.println("Transaction Entries:" + transaction);
		return transactionRepository.save(transaction);
	}

	@Override
	@Transactional
	public TransactionEntity withdraw(int accountNumber, double withdrawAmount) {
		AccountEntity withAccount = accountRepository.findByAccountNumber(accountNumber);
		
		if (withAccount.getAccountBalance() < withdrawAmount) {
			return null;
		}
		withAccount.setAccountBalance(withAccount.getAccountBalance() - withdrawAmount);
		accountRepository.save(withAccount);

		TransactionEntity transaction = new TransactionEntity();
		transaction.setTransectionType("Withdrawal");
		transaction.setTransectionDate(new Date());
		transaction.setTransectionAmount(withdrawAmount);
		transaction.setTransectionStatus("Success");
		transaction.setAccountEntity(withAccount);
		return transactionRepository.save(transaction);
	}

	public TransactionEntity withdrawForTransfer(int fromAccountId, double transferAmount) {
       AccountEntity withAccount = accountRepository.findByAccountNumber(fromAccountId);
       System.out.println("Account Balance for withdrawal:"+ withAccount.getAccountBalance());

			withAccount.setAccountBalance(withAccount.getAccountBalance() - transferAmount);
			 accountRepository.save(withAccount);
			 
		 TransactionEntity transaction = new TransactionEntity();
			transaction.setTransectionType("Transfer - Withdrawal");
			transaction.setTransectionDate(new Date());
			transaction.setTransectionAmount(transferAmount);
			transaction.setTransectionStatus("Success");
			transaction.setAccountEntity(withAccount);
		
			return transactionRepository.save(transaction);
	}
	
	public void depositForTransfer(int toAccountId, double transferAmount) {
		AccountEntity account = accountRepository.findByAccountNumber(toAccountId);
		
		account.setAccountBalance(account.getAccountBalance() + transferAmount);
		 accountRepository.save(account);
         
		 TransactionEntity transaction = new TransactionEntity();
			transaction.setTransectionType("Transfer - Deposition");
			transaction.setTransectionDate(new Date());
			transaction.setTransectionAmount(transferAmount);
			transaction.setTransectionStatus("Success");
			transaction.setAccountEntity(account);
		
			 transactionRepository.save(transaction);
	}
	
	@Override
	public TransactionEntity transfer(int fromAccountId, int toAccountId, double transferAmount) {
		
		TransactionEntity afterWith = new TransactionEntity();
		
			afterWith = withdrawForTransfer(fromAccountId, transferAmount);
			depositForTransfer(toAccountId, transferAmount);
			
		
		return afterWith;

	}

	public AccountEntity getAccountDetails(int accountNumber) {
		return accountRepository.findByAccountNumber(accountNumber);
	}

	public List<TransactionEntity> getAllTransactionHistory() {
		System.out.println(transactionRepository.findAll());
		return transactionRepository.findAll();
		
		
	}

}
