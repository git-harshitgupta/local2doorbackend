package com.app.local2door.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.local2door.pojo.Customer;
import com.app.local2door.pojo.Shopkeeper;

public interface ICustomerDao extends JpaRepository<Customer, Integer>{
	@Query("select u from Customer u where u.email=:email")
    Customer findCustomerByEmail(String email);
}
