package com.app.local2door.service;

import com.app.local2door.pojo.Customer;
import com.app.local2door.pojo.Shopkeeper;
import com.app.local2door.pojo.User;

public interface ILoginAndSignUpService {

	String emailExist(String email);
	String phoneExist(long phone);
    Customer saveUserDetails(User user);
    Shopkeeper saveShopkeeperDetails(User user);
    String getCustomer(String email);
}
