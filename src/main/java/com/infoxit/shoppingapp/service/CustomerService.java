package com.infoxit.shoppingapp.service;

import com.infoxit.shoppingapp.dto.LoginDetails;
import com.infoxit.shoppingapp.entity.Customer;

public interface CustomerService {

	public Customer registerCustomer(Customer customer) throws Exception;
	
	public boolean customerLogin(LoginDetails login) throws Exception;
}
