package com.cg.dsTraining.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dsTraining.Dao.TransactionRepository;
import com.cg.dsTraining.Entity.TransactionEntity;

@Service
public class TransactionServiceImpl implements TransactionService{

	@Autowired
	private TransactionRepository transactionRepo;
	
	
	public List<TransactionEntity> getTransactionStatus() {
		return transactionRepo.findAll();
	}
	
	public TransactionEntity getAllTransactionHistory(){
		return transactionRepo.findById(1).orElse(null);
	}
	
}
