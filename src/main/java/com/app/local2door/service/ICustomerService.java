package com.app.local2door.service;

import java.util.List;

import com.app.local2door.dto.ChangeLocationRequest;
import com.app.local2door.dto.OrderResponseCustomer;
import com.app.local2door.dto.ProductResponse;
import com.app.local2door.dto.ShopResponse;
import com.app.local2door.dto.UserDetails;
import com.app.local2door.pojo.ProductList;

public interface ICustomerService {
	List<ShopResponse> getAllShop(String email);
	List<ProductResponse> getAllProduct(int shopId);
	String placeAnOrder(String status,String payment,int shopkeeperId,String customerEmailString,List<ProductList> productList,double totalPrice);
	List<OrderResponseCustomer> getOrderDetails(String customerEmail);
	OrderResponseCustomer getSingleOrderDetails(int orderId);
	List<ProductResponse> getProductListFromOrderDetails(int orderId);
	String checkProductAvlability(List<ProductList> productLists);
	UserDetails getCustomerInformation(String email);
	String saveCustomerDetails(String email,UserDetails userDetails);
	String changePassword(String email,String oldPassword,String newPassword);
	String changePhone(String email,String phone);
	String changeLocation(String email,ChangeLocationRequest changeLocationRequest);
}
