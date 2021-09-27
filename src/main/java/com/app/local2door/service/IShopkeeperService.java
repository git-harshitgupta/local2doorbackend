package com.app.local2door.service;

import java.util.List;

import com.app.local2door.dto.OrderResponseShopkeeper;
import com.app.local2door.dto.ProductResponse;
import com.app.local2door.dto.ShopkeeperDetailsRequest;
import com.app.local2door.dto.ShopkeeperOrderResponse;
import com.app.local2door.pojo.Product;


public interface IShopkeeperService {
	String getShopkeeperName(String email);
	String addProduct(String email,Product product);
	List<ProductResponse> getAllProduct(String email);
	ProductResponse getProduct(int productId);
	String removeProduct(String email,int productId);
	String updateProductItem(String email,Product product);
	List<ShopkeeperOrderResponse> getOrders(String email);
	String acceptOrder(int orderId);
	public List<OrderResponseShopkeeper> getOrderDetails(String shopkeeperEmail);
	ShopkeeperOrderResponse getSingleOrderDetails(int orderId);
	List<ProductResponse> getProductListFromOrderDetails(int orderId);
	ShopkeeperOrderResponse updateOrderStatusToDelivered(int orderId);
	String openClose(String email);
	String checkOrder(String email);
	String closeStore(String email);
	ShopkeeperDetailsRequest getShopkeeperDetails(String email);
	String updateShopkeeperDetails(String email,ShopkeeperDetailsRequest shopkeeperDetailsRequest);
	String changePassword(String email,String oldPassword,String newPassword);
}
