package com.cg.dsTraining.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.dsTraining.Entity.TransactionEntity;

@Service
public interface TransactionService {

	public List<TransactionEntity> getTransactionStatus();
	
	public TransactionEntity getAllTransactionHistory();
	
}
