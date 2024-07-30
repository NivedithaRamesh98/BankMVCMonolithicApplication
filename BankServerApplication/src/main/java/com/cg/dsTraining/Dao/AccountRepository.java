package com.cg.dsTraining.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.dsTraining.Entity.AccountEntity;

@Repository
public interface AccountRepository extends JpaRepository<AccountEntity,Integer>{

	@Query("SELECT acc.accountBalance FROM AccountEntity  acc where acc.accountNumber=:id")
	public double findAccountBalanceByAccountNumber(int id);

	//@Query("SELECT acc FROM AccountEntity  acc where acc.accountNumber=:accountNumber")
	public AccountEntity findByAccountNumber(int accountNumber);

}
