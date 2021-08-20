package com.model.dao;

import com.custApp.entities.Customer;

public interface CustDao {
public Customer findCustById(int id);
public void addCustomer(Customer customer);
}
