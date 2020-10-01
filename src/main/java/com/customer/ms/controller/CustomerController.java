package com.customer.ms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.customer.ms.dao.CustomerDAO;
import com.customer.ms.model.Customer;
import com.customer.ms.model.CustomerM;
import com.customer.ms.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerDAO customerDAO;
	
	@Autowired
	private CustomerService customerService;

	// URL - http://localhost:8080/hello
	@RequestMapping("/hello")
	public String hello() {
		return "Greetings from Spring Boot Application 1.0";
	}

	// URL - http://localhost:8080/customers
	@RequestMapping(value = "/customers", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<Customer> getCustomers() {
		List<Customer> list = customerDAO.getAllCustomers();
		return list;
	}

	// URL - http://localhost:8080/customer/{cusId}
	@RequestMapping(value = "/customer/{cusId}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public Customer getCustomer(@PathVariable("cusId") String cusId) {
		return customerDAO.getCustomer(cusId);
	}

	// URL - POST http://localhost:8080/customer}
	@RequestMapping(value = "/customer", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE })
	public Customer addCustomer(@RequestBody Customer customer) {
		return customerDAO.addCustomer(customer);
	}
	
	@RequestMapping(value = "/customer", method = RequestMethod.PUT, produces = { MediaType.APPLICATION_JSON_VALUE })
	public Customer updateCustomer(@RequestBody Customer customer) {
		return customerDAO.updateCustomer(customer);
	}
	
	@RequestMapping(value = "/customer", method = RequestMethod.DELETE, produces = { MediaType.APPLICATION_JSON_VALUE })
	public Customer deleteCustomer(@RequestBody Customer customer) {
		return customerDAO.deleteCustomer(customer);
	}
	
	@RequestMapping(value = "/mongoCustomers", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE})
	public List<CustomerM> getMongoCustomers(){
		List<CustomerM> list = customerService.findAll();
		return list;
	}
	
	@RequestMapping(value = "/mongoCustomer/{cusId}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE})
	public CustomerM getMongoCustomers1(@PathVariable("cusId") String cusId){
		return customerService.findById(cusId);
	}
	
	@RequestMapping(value = "/mongoCustomers", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE})
	public CustomerM addMongoCustomer(@RequestBody CustomerM customerM) { 
		return customerService.addCustomer(customerM);
	}
	
	@RequestMapping(value = "/mongoCustomers", method = RequestMethod.PUT, produces = { MediaType.APPLICATION_JSON_VALUE})
	public CustomerM updateMongoCustomer(@RequestBody CustomerM customerM) { 
		return customerService.addCustomer(customerM);
	}
	
	@RequestMapping(value = "/mongoCustomer/{cusId}", method = RequestMethod.DELETE, produces = { MediaType.APPLICATION_JSON_VALUE})
	public void deleteMongoCustomer(@PathVariable("cusId") String cusId) { 
	}
	
	
}