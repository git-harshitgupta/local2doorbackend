package com.app.local2door.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.local2door.dto.OrderResponseCustomer;
import com.app.local2door.dto.OrderResponseShopkeeper;
import com.app.local2door.dto.ProductResponse;
import com.app.local2door.dto.ShopkeeperOrderResponse;
import com.app.local2door.pojo.OrderDetails;

@Repository
public interface IOrderDetailsDao extends JpaRepository<OrderDetails, Integer>{
//	select new com.app.local2door.dto.ProductResponse(p.productId,p.productName,p.productQuantity,p.productUnit,p.productPrice) from Shopkeeper s join s.productList p where s.id=:id"
	@Query("select new com.app.local2door.dto.OrderResponseCustomer(o.orderId,s.shopName,o.totalPrice,o.payment,o.orderDate,o.orderTime,o.status) from OrderDetails o join o.shopkeeperId s where s.id=:id")
	List<OrderResponseCustomer> getOrderDetailsForCustomer(@Param("id") int id);
	@Query("select new com.app.local2door.dto.OrderResponseCustomer(o.orderId,s.shopName,o.totalPrice,o.payment,o.orderDate,o.orderTime,o.status) from OrderDetails o join o.shopkeeperId s where o.orderId=:id")
	OrderResponseCustomer getSingleOrderDetailsForCustomer(@Param("id") int id);
//	int orderId, String shopName, double totalPrice, String payment, LocalDate orderDate,
//	LocalTime localTime, String status
	@Query("select new com.app.local2door.dto.ProductResponse(p.productId,p.productName,p.productQunatity,p.productUnit,p.productPrice) from OrderDetails o join o.productLists p where o.orderId=:id")
	List<ProductResponse> getAllProductFromOrderDetails(@Param("id") int id);
//	int orderId, String customerName, String customerAdd, String customerHouseNo, double totalPrice,String payment, String status, LocalDate orderDate, LocalTime orderTime
	@Query("select new com.app.local2door.dto.ShopkeeperOrderResponse(o.orderId,c.name,c.fullAddreas,c.houseNo,o.totalPrice,o.payment,o.status,o.orderDate,o.orderTime,c.mobileNo) from OrderDetails o join o.customerId c join o.shopkeeperId s where s.id=:id and o.status='pending'")
	List<ShopkeeperOrderResponse> getAllOrders(@Param("id") int id);
	@Query("select new com.app.local2door.dto.OrderResponseShopkeeper(o.orderId,c.name,o.totalPrice,o.payment,o.orderDate,o.orderTime,o.status) from OrderDetails o join o.customerId c where c.id=:id and o.status!='pending'")
	List<OrderResponseShopkeeper> getOrderDetailsForShopkeeper(@Param("id") int id);
	@Query("select new com.app.local2door.dto.ShopkeeperOrderResponse(o.orderId,c.name,c.fullAddreas,c.houseNo,o.totalPrice,o.payment,o.status,o.orderDate,o.orderTime,c.mobileNo) from OrderDetails o join o.customerId c where o.orderId=:id")
	ShopkeeperOrderResponse getSingleOrderDetailsForShopkeeper(@Param("id") int id);
	@Query("select o.status from OrderDetails o join o.shopkeeperId s where o.status='pending' and s.id=:id ")
	List<String> checkOrder(@Param("id") int id);
}
