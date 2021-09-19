package com.app.local2door.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.local2door.pojo.Shopkeeper;

public interface IShopkeeperDao extends JpaRepository<Shopkeeper,Integer>{
	@Query("select u from Shopkeeper u where u.email=:email")
    Shopkeeper findShopkeeperByEmail(String email);
}
