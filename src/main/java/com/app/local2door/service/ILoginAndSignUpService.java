package com.app.local2door.service;

import com.app.local2door.dto.User;
import com.app.local2door.pojo.Customer;
import com.app.local2door.pojo.Shopkeeper;

public interface ILoginAndSignUpService {

	String emailExist(String email);
	String phoneExist(long phone);
    Integer saveUserDetails(User user);
    Integer saveShopkeeperDetails(User user);
    String getCustomer(String email);
}
