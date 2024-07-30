package com.cg.dsTraining.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dsTraining.Dao.AccountRepository;
import com.cg.dsTraining.Dao.CustomerRepository;
import com.cg.dsTraining.Entity.AccountEntity;
import com.cg.dsTraining.Entity.CustomerEntity;

@Service
public class CustomerServiceimpl implements CustomerService{

	@Autowired
	private CustomerRepository customerRepo;
	
	@Autowired
	private AccountRepository accountRepo;

	@Override
	public CustomerEntity registerCustomer(CustomerEntity registrationDetails) {
		return customerRepo.save(registrationDetails);
	}

    @Override
    public boolean validateLogin(String userName, String password) {
 
    	if(userName.equalsIgnoreCase(customerRepo.findByUserName(userName).getUserName()) 
    			&& password.equalsIgnoreCase(customerRepo.findByUserName(userName).getPassword())) {
    		return true;
    	}
    	return false;
    }

	@Override
	public CustomerEntity getCustomerByUserName(String userName) {
		CustomerEntity cust = customerRepo.findByUserName(userName);
		
		AccountEntity  account = new AccountEntity();
		account.setAccountBalance(2500);
		account.setAccountType("Savings");
		accountRepo.save(account);
		account.setAccountNumber(10203 +account.getAcId());
		accountRepo.save(account);
		System.out.println("acc:"+accountRepo.findAll());
		return cust;
	}
	

}
