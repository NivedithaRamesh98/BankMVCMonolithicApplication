package com.cg.dsTraining.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.dsTraining.Entity.AccountEntity;
import com.cg.dsTraining.Entity.TransactionEntity;

@Repository
public interface TransactionRepository extends JpaRepository<TransactionEntity, Integer>{

	//@Query("SELECT tr FROM TransactionEntity tr where tr.accountNumber.=:account_Number")
	//List<TransactionEntity> findByAccountEntity(@Param("account_number") AccountEntity accountNumber);

	  
}
