package com.cg.dsTraining.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.dsTraining.Entity.AccountEntity;
import com.cg.dsTraining.Entity.TransactionEntity;
import com.cg.dsTraining.Service.TransactionService;

@Controller
public class TransactionController {

	@Autowired
	private TransactionService transactionService;
	
	@RequestMapping("/allrecords")
	public List<TransactionEntity> getTransactionStatus() {
		return transactionService.getTransactionStatus();
	}
	
	@RequestMapping("transactionForm")
	public String getTransactionDetails(Model theModel) {
       TransactionEntity transactions = transactionService.getAllTransactionHistory();
		System.out.println("transactions history"+ transactionService.getAllTransactionHistory());
		
		if(transactions !=null){
		theModel.addAttribute("transactionId", transactions.getTransectionId());
		theModel.addAttribute("transactionType", transactions.getTransectionType());
		theModel.addAttribute("transactionAmount", transactions.getTransectionAmount());
		theModel.addAttribute("transactionDate", transactions.getTransectionDate());
		theModel.addAttribute("transactionStatus", transactions.getTransectionStatus());
		return "accountDetails";
		} else {
			throw new RuntimeException("No Transactions Found");
			
		}
	}
	
}
