package com.model.service;

import com.custApp.entities.Customer;

public interface CustomerServiceDao {
	public Customer findCustById(int id);
	public void addCustomer(Customer customer);
}
