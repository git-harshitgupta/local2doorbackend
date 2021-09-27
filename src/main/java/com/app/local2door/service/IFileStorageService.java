package com.app.local2door.service;


import org.springframework.web.multipart.MultipartFile;

import com.app.local2door.pojo.Shopkeeper;

public interface IFileStorageService {
	String storeCustomerProfile(MultipartFile file,int id);
	String storeShopkeeperProfile(MultipartFile file,int id);
	Shopkeeper getShopkeeperImage(Integer id);
	
	
}
