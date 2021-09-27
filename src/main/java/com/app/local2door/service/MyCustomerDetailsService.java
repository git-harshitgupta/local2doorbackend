package com.app.local2door.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.app.local2door.dao.ICustomerDao;

import com.app.local2door.dao.IShopkeeperDao;
import com.app.local2door.pojo.Customer;
import com.app.local2door.pojo.Shopkeeper;

import java.util.ArrayList;

@Service
public class MyCustomerDetailsService implements UserDetailsService {
    @Autowired
    ICustomerDao customerDao;
    @Autowired
    IShopkeeperDao shopkeeperDao;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Customer customer=customerDao.findByEmail(email);
        Shopkeeper shopkeeper=shopkeeperDao.findByEmail(email);
        if(customer!=null) {
        	System.out.println("Customer");
            return new User(customer.getEmail(), customer.getPassword(), new ArrayList<>());
         }
        else if(shopkeeper!=null)
            return new User(shopkeeper.getEmail(), shopkeeper.getPassword(), new ArrayList<>());
        else
            throw new UsernameNotFoundException("Incorrect email and password");
    }

}
