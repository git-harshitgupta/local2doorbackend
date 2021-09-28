package com.app.local2door.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.local2door.dto.ProductResponse;
import com.app.local2door.dto.ShopResponse;
import com.app.local2door.pojo.Product;
import com.app.local2door.pojo.Shopkeeper;



@Repository
public interface IShopkeeperDao extends JpaRepository<Shopkeeper, Integer>{
	@Query("select s from Shopkeeper s where s.id=:id")
	Shopkeeper getById(int id);
    Shopkeeper findByEmail(String email);
	@Query("select new com.app.local2door.dto.ProductResponse(p.productId,p.productName,p.productQuantity,p.productUnit,p.productPrice) from Shopkeeper s join s.productList p where s.id=:id")
	List<ProductResponse> getAllProduct(@Param("id") int id);
	@Query("select p from Shopkeeper s join s.productList p where p.productId=:id")
	Product getProductById(@Param("id") int productId);	
	@Query("select new com.app.local2door.dto.ShopResponse(s.id,s.shopName,s.shopAddreas,s.profileImage) from Shopkeeper s where s.longi<:longihigh and s.longi>:longilow and s.lati<:latihigh and s.lati>:latilow and s.status='OPEN'")
	List<ShopResponse> getAllShop(@Param("longihigh") double longiHigh,@Param("longilow") double longiLow,@Param("latihigh") double latiHigh,@Param("latilow") double latiLow);
	Shopkeeper findByMobileNo(long mobileNo);
}
