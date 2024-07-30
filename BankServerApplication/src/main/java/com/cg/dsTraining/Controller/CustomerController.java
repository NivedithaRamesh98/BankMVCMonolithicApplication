package com.cg.dsTraining.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cg.dsTraining.Dao.AccountRepository;
import com.cg.dsTraining.Entity.AccountEntity;
import com.cg.dsTraining.Entity.CustomerEntity;
import com.cg.dsTraining.Model.CustomerModel;
import com.cg.dsTraining.Service.AcountService;
import com.cg.dsTraining.Service.CustomerService;

@Controller
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	@Autowired
	private AcountService accountService;
	
	@RequestMapping("/login")
	public String indexPage() {		
	 return "index";
	}
	
	@RequestMapping("logout")
	public String logoutPage() {		
	 return "logoutForm";
	}
	
	@RequestMapping("/register")
	public String registerPage() {		
	 return "newUser";
	}
	
	@RequestMapping("/addCustomer") 
	public String loginwithPassword(@RequestParam("username") String username,@RequestParam("password") String password, Model aModel) {
		
		   if ((username.isEmpty())||(username.isBlank())) {
		    	aModel.addAttribute("error", "Username and password are required.");
		        return "index";
		    }  else if (username.isEmpty() || password.isEmpty()) {
		    	aModel.addAttribute("error", "Username and password are required.");
		        return "index";
		    }  else if(customerService.validateLogin(username, password)) {
		    	
	    	     aModel.addAttribute("userName",username);
			     aModel.addAttribute("pasword",password);
	    	     CustomerEntity customer = customerService.getCustomerByUserName(username);
	    	    List<AccountEntity> account = accountService.getAccountDetails();
	    	     System.out.println("Customer::::"+ customer);
	    	     if(customer != null)
	    		   aModel.addAttribute("customerName",customer.getCustomerName());
	    	       aModel.addAttribute("customerId",customer.getCustomerId());
			       aModel.addAttribute("emailId",customer.getCustomerEmailId());
			       aModel.addAttribute("accountNumber",account.get(0).getAccountNumber());
			       aModel.addAttribute("accountBalance",account.get(0).getAccountBalance());

			       return "addCustomer";
	         }   else {
	    	      aModel.addAttribute("error","Invalid username or password.");
	              return "index";
	    } 
		
	}
	
	
	@RequestMapping("/registerDetails") 
	public String newRegistration(@Valid @ModelAttribute("registerValues") CustomerEntity newCustomer, Model model) {
		if(newCustomer != null) {
		model.addAttribute("customerId",newCustomer.getCustomerId());
		model.addAttribute("customerName",newCustomer.getCustomerName());
		model.addAttribute("emailId",newCustomer.getCustomerEmailId());
		model.addAttribute("username",newCustomer.getUserName());
		model.addAttribute("password",newCustomer.getPassword());

		customerService.registerCustomer(newCustomer);
		return "index";
		} else {
			model.addAttribute("error","All the fields are required");
			return "newUser";
		}
		    
	}
	
}
