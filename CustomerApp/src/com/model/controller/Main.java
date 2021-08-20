package com.model.controller;

import java.util.Date;

import com.custApp.entities.Customer;
import com.model.dao.CustDaoImp;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
CustDaoImp custDaoImp=new CustDaoImp();
Customer customer=
custDaoImp.findCustById(1);
//Date d1 = new Date(2000, 11, 21);
//Customer customer1=new Customer(1, "ronak", "noida", 23445, d1);


	}

}
