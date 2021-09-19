package com.app.local2door.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.local2door.dao.IShopkeeperDao;
@Service
@Transactional
public class ShopkeeperService implements IShopkeeperService{
	@Autowired
	IShopkeeperDao shopkeeperDao;
	@Override
	public String getShopkeeperName(String email) {
		return shopkeeperDao.findShopkeeperByEmail(email).getShopName();
	}

}
