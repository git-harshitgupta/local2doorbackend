package com.app.local2door.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.app.local2door.pojo.Product;


@Repository
public interface IProductDao extends JpaRepository<Product, Integer>{
	
}
 