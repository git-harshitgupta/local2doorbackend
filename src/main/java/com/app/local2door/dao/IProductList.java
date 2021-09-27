package com.app.local2door.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.local2door.pojo.ProductList;

@Repository
public interface IProductList extends JpaRepository<ProductList, Integer>{

}
