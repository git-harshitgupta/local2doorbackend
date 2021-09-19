package com.app.local2door.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.local2door.dao.ICustomerDao;
import com.app.local2door.dao.IShopkeeperDao;
import com.app.local2door.pojo.Customer;
import com.app.local2door.pojo.Shopkeeper;

@Service
@Transactional
public class LoginAndSignUpService implements ILoginAndSignUpService {
	@Autowired
	IShopkeeperDao shopKeeperDao;
	@Autowired
	ICustomerDao customerDao;
	@Override
    public String getCustomer(String email) {
        Customer customer=customerDao.findCustomerByEmail(email);
        Shopkeeper shopkeeper=shopKeeperDao.findShopkeeperByEmail(email);
        if(customer!=null)
            return "customer";
        else
            return "shopkeeper";
    }
	
}
