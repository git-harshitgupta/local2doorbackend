package com.app.local2door.service;

import java.time.LocalDate;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.local2door.custom_excpt.EmailExistException;
import com.app.local2door.custom_excpt.NumberAlreadyInUseException;
import com.app.local2door.dao.ICustomerDao;
import com.app.local2door.dao.IShopkeeperDao;
import com.app.local2door.pojo.Customer;
import com.app.local2door.pojo.Shopkeeper;
import com.app.local2door.pojo.Type;
import com.app.local2door.pojo.User;

@Service
@Transactional
public class LoginAndSignUpService implements ILoginAndSignUpService {
	@Autowired
    ICustomerDao customerDao;
    @Autowired
    IShopkeeperDao shopKeeperDao;
    


    @Override
    public String emailExist(String email) {
    	Shopkeeper shopkeeper = shopKeeperDao.findByEmail(email);
    	Customer customer = customerDao.findByEmail(email);
        if(shopkeeper==null&&customer==null) {
        	return "Not Exist";	
        }
        else {
        	throw new EmailExistException("Email already exist");
		}   
    }

    

    @Override
    public Customer saveUserDetails(User user) {
        System.out.println("Inside user details");

            Customer customer = new Customer();
            customer.setUser(Type.CUSTOMER);
            customer.setEmail(user.getEmail());
            customer.setPassword(user.getPassword());
            customer.setName(user.getName());
            customer.setFullAddreas(user.getFullAddreas());
            customer.setLongi(user.getLongi());
            customer.setLati(user.getLati());
            customer.setHouseNo(user.getHouseNo());
            customer.setMobileNo(Long.parseLong(user.getMobileNo()));
            customer.setJoinDate(LocalDate.now());
            return customerDao.save(customer);

    }

    @Override
    public Shopkeeper saveShopkeeperDetails(User user) {
        Shopkeeper shopkeeper = new Shopkeeper();
        shopkeeper.setUser(Type.SHOPKEEPER);
        shopkeeper.setEmail(user.getEmail());
        shopkeeper.setPassword(user.getPassword());
        shopkeeper.setShopName(user.getShopName());
        shopkeeper.setShopAddreas(user.getFullAddreas());
        shopkeeper.setLongi(user.getLongi());
        shopkeeper.setLati(user.getLati());
        shopkeeper.setStatus("CLOSED");
        shopkeeper.setShopRegisterationId(user.getShopRegId());
        shopkeeper.setMobileNo(Long.parseLong(user.getMobileNo()));
        shopkeeper.setJoinDate(LocalDate.now());
        return shopKeeperDao.save(shopkeeper);
    }


    @Override
    public String getCustomer(String email) {
        Customer customer=customerDao.findByEmail(email);
        
        if(customer!=null)
            return "customer";
        else
            return "shopkeeper";
    }



	@Override
	public String phoneExist(long phone) {
		Shopkeeper shopkeeper = shopKeeperDao.findByMobileNo(phone);
    	Customer customer = customerDao.findByMobileNo(phone);
    	if(shopkeeper==null&&customer==null) {
    		return "Not Exist";
        	
        }
        else {
        	throw new NumberAlreadyInUseException("MobileNo already in use");
		}
	}

	
}
