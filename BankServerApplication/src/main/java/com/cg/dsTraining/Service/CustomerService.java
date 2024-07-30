package com.cg.dsTraining.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dsTraining.Dao.CustomerRepository;
import com.cg.dsTraining.Entity.AccountEntity;
import com.cg.dsTraining.Entity.CustomerEntity;

@Service
public interface CustomerService {
	
	public CustomerEntity registerCustomer(CustomerEntity registrationDetails);
	public boolean validateLogin(String userName, String password);
	public CustomerEntity getCustomerByUserName(String userName);
   
}
