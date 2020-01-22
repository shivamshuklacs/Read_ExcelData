package com.mustang;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mustang.service.CustomerService;

@RestController
public class Controller {
	
	@Autowired
	private CustomerService cService;
	
	@RequestMapping(path="customers")
	public void saveCustomerData(){
		cService.saveCustomer();
	}
}
