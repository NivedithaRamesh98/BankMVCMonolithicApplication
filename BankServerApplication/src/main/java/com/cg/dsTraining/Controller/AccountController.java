package com.cg.dsTraining.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.cg.dsTraining.Dao.TransactionRepository;
import com.cg.dsTraining.Entity.AccountEntity;
import com.cg.dsTraining.Entity.CustomerEntity;
import com.cg.dsTraining.Entity.TransactionEntity;
import com.cg.dsTraining.Model.AccountModel;
import com.cg.dsTraining.Service.AcountService;
import com.cg.dsTraining.Service.TransactionService;


@Controller
public class AccountController {
	@Autowired
	private AcountService acountService;
	@Autowired
	private TransactionRepository transactionRepository;

	
	@RequestMapping("/checkBal")
	public String getAccountDetails(@RequestParam("accountNumber") int accountNumber, Model theModel) {
		
		double accountBalance = acountService.getAccountBalanceByAccountNumber(accountNumber);
		theModel.addAttribute("accountBalance", accountBalance);
		
		return "checkBalance";
		
	}
	
	@RequestMapping("/accountForm")
	public String accountPage() {		
	 return "accountsForm";
	}
	
	@RequestMapping("/addAccount") 
	public String newRegistration(@Valid @ModelAttribute("accountDetails") AccountEntity accountDetails, Model model) {
		
		model.addAttribute("accId",accountDetails.getAcId());
		model.addAttribute("accountNumber",accountDetails.getAccountNumber());
		model.addAttribute("accountType", accountDetails.getAccountType());
		model.addAttribute("accountBalance", accountDetails.getAccountBalance());
		model.addAttribute("custId",accountDetails.getCustomerEntity());
	    acountService.addAccountDetails(accountDetails);
		return "accounts";
	}
    
	@RequestMapping("depositForm")
	public String depositePage() {
	 return "depositPage";
	}
	
	@RequestMapping("withdrawForm")
	public String withdrawalPage() {
	 return "withdraw";
	}
	
	@RequestMapping("transferForm")
	public String transferPage() {
	 return "transfer";
	}
	
	
	@RequestMapping("doDeposit")
	public String depositeValue( @Valid @ModelAttribute("accountNumber") int accountNumber,
			                     @Valid @ModelAttribute("depositAmount") double depositAmount, 
			                     Model theModel) {
		
		TransactionEntity accountDep = acountService.deposit(accountNumber, depositAmount);
		
		if (accountDep!=null) {
	    
		theModel.addAttribute("transectionId", accountDep.getTransectionId());
		theModel.addAttribute("transectionType", accountDep.getTransectionType());
		theModel.addAttribute("transectionAmount", accountDep.getTransectionAmount());
		theModel.addAttribute("transectionDate", accountDep.getTransectionDate());
		theModel.addAttribute("transectionStatus", accountDep.getTransectionStatus());
		theModel.addAttribute("accountBalance", accountDep.getAccountNumber().getAccountBalance());
          
		return "deposited";
        } else {
        	
	        theModel.addAttribute("errorMessage", "Depopsit amount cannot be Zero. ");

            return "depositPage";
        }
	}
	
	@RequestMapping("doWithdraw")
	public String withdrawValue(@Valid @ModelAttribute("accountNumber") int accountNumber,
	                            @Valid @ModelAttribute("withdrawAmount") double withdrawAmount,
	                            Model theModel) {

	    TransactionEntity accountWith = acountService.withdraw(accountNumber, withdrawAmount);

	    if (accountWith != null) {
	        
	        theModel.addAttribute("transectionId", accountWith.getTransectionId());
	        theModel.addAttribute("transectionType", accountWith.getTransectionType());
	        theModel.addAttribute("transectionAmount", accountWith.getTransectionAmount());
	        theModel.addAttribute("transectionDate", accountWith.getTransectionDate());
	        theModel.addAttribute("transectionStatus", accountWith.getTransectionStatus());
	        theModel.addAttribute("accountBalance", accountWith.getAccountNumber().getAccountBalance());

	        return "withdrawedStatus";
	    } else {
	        
	        theModel.addAttribute("errorMessage", "Insufficient balance for withdrawal");
	        return "withdraw";
	    }
	}

	
	@RequestMapping("doTransfer")
	public String transfer(@Valid @ModelAttribute("fromAccountNumber") int fromAccountNumber, @Valid @ModelAttribute("toAccountNumber") int toAccountNumber,
			@Valid @ModelAttribute("transferAmount") double transferAmount, Model theModel) {
		
		acountService.transfer(fromAccountNumber,toAccountNumber , transferAmount);
		theModel.addAttribute("transferAmount",transferAmount);
		TransactionEntity transcatEntry = acountService.transfer(fromAccountNumber, toAccountNumber, transferAmount);
		theModel.addAttribute("transactionStatus",transcatEntry.getTransectionStatus());
		theModel.addAttribute("transactionType",transcatEntry.getTransectionType());
		theModel.addAttribute("transactionAmount",transcatEntry.getTransectionAmount());
		theModel.addAttribute("transactionDate",transcatEntry.getTransectionDate());
		theModel.addAttribute("transactionId",transcatEntry.getTransectionId());
		return "transferBalance";
		
	}
		
}
