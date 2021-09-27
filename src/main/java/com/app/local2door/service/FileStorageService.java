package com.app.local2door.service;

import java.io.IOException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.app.local2door.dao.ICustomerDao;
import com.app.local2door.dao.IShopkeeperDao;
import com.app.local2door.pojo.Customer;

import com.app.local2door.pojo.Shopkeeper;



@Service
public class FileStorageService implements IFileStorageService {
	@Autowired
	ICustomerDao customerDao;
	@Autowired
	IShopkeeperDao shopkeeeperDao;
	@Override
	public String storeCustomerProfile(MultipartFile file, int id) {
		Customer customer = customerDao.findById(id).get();
		
		try {
			
			
			customer.setProfileImage(file.getBytes());
			customerDao.save(customer);
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return "Added";
	}
	@Override
	public String storeShopkeeperProfile(MultipartFile file, int id) {
		Shopkeeper shopkeeper = shopkeeeperDao.findById(id).get();
		
		try {
			
			
				
			    
			
			
			shopkeeper.setProfileImage(file.getBytes());
			shopkeeeperDao.save(shopkeeper);
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return "Added";
	}
	@Override
	public Shopkeeper getShopkeeperImage(Integer id) {
		
		return shopkeeeperDao.findById(id).get();
	}
	

}
