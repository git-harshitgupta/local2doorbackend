package com.app.local2door.dao;



import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


import com.app.local2door.pojo.Product;


@Repository
public interface IProductDao extends JpaRepository<Product, Integer>{
	
}
 