package com.model.service;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.custApp.dao.factory.DBConnectionFactory;
import com.custApp.entities.Customer;
import com.custApp.exceptions.DataAccessException;
import com.custApp.exceptions.ResourceNotFoundException;

public class CustomerServiceImp implements CustomerServiceDao {
	private java.sql.Connection connection;

	 public CustomerServiceImp() {
		 connection=DBConnectionFactory.getConnection();
	}
	 
	@Override
	public Customer findCustById(int id) {


		// TODO Auto-generated method stub
		Customer customer=null;
		try {
			PreparedStatement pstmt=connection.prepareStatement("select * from customer1 where id=?");
			pstmt.setInt(1, id);
			ResultSet rs=	pstmt.executeQuery();
		if(rs.next()) {
			customer=new Customer(rs.getInt("id"),rs.getString("name"),rs.getString("address"),rs.getInt("phone"),rs.getDate("dob"));
		}else {
			throw new ResourceNotFoundException("customer with id is not found");
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		throw new DataAccessException(e.toString());
		}
		return customer;
	
		
	
	}

	@Override
	public void addCustomer(Customer customer) {


		// TODO Auto-generated method stub
	try {
		
		String INSERT_BOOK_QUERY = "insert into books(id,name,address,phone,dob) valuse(?,?,?,?,?)";
		PreparedStatement pstmt=connection.prepareStatement(INSERT_BOOK_QUERY,Statement.RETURN_GENERATED_KEYS);
	pstmt.setInt(1,customer.getId());
	pstmt.setString(2,customer.getName());
	pstmt.setString(3,customer.getAddress());
	pstmt.setInt(4,customer.getPhNo());
	pstmt.setDate(5, new Date(customer.getDob().getTime()));
	
		pstmt.executeUpdate();
	
	ResultSet rs=pstmt.getGeneratedKeys();
	if(rs.next()) {
		customer.setId(rs.getInt(1));
	}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
	throw new DataAccessException(e.toString());
	}
	
	
		
		
		
	
		
	}

}
