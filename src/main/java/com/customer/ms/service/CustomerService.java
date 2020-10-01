package com.customer.ms.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.customer.ms.model.CustomerM;


public interface CustomerService {
	
	List <CustomerM> findAll();
	
	CustomerM findById (String cusId);
	
	CustomerM addCustomer (CustomerM customerm);
	
	void deleteCustomer (String cusId);
	
	CustomerM updateCustomer (CustomerM customerm);


}
