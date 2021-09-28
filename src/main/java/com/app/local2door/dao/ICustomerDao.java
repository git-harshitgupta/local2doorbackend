package com.app.local2door.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.app.local2door.dto.UserDetails;
import com.app.local2door.pojo.Customer;


public interface ICustomerDao extends JpaRepository<Customer, Integer>{
	
    Customer findByEmail(String email);
	@Query("select new com.app.local2door.dto.UserDetails(c.name,c.fullAddreas,c.houseNo) from Customer c where c.email=:email")
	UserDetails getUserInformation(String email);
	Customer findByMobileNo(long mobileNo);
}
