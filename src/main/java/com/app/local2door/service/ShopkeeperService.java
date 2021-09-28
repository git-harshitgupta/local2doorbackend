package com.app.local2door.service;

import java.time.LocalDate;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.local2door.custom_excpt.IncorrectPasswordException;
import com.app.local2door.custom_excpt.NumberAlreadyInUseException;
import com.app.local2door.custom_excpt.SamePasswordException;
import com.app.local2door.dao.ICustomerDao;
import com.app.local2door.dao.IOrderDetailsDao;
import com.app.local2door.dao.IProductDao;
import com.app.local2door.dao.IShopkeeperDao;
import com.app.local2door.dto.OrderResponseShopkeeper;
import com.app.local2door.dto.ProductResponse;
import com.app.local2door.dto.ShopkeeperDetailsRequest;
import com.app.local2door.dto.ShopkeeperOrderResponse;
import com.app.local2door.pojo.Customer;
import com.app.local2door.pojo.OrderDetails;
import com.app.local2door.pojo.Product;
import com.app.local2door.pojo.Shopkeeper;
@Service
@Transactional
public class ShopkeeperService implements IShopkeeperService{
	@Autowired
	IShopkeeperDao shopkeeperDao;
	@Autowired
	IProductDao productDao;
	@Autowired
	IOrderDetailsDao orderDetailsDao;
	@Autowired
	ICustomerDao customerDao;
	@Override
	public String getShopkeeperName(String email) {
		return shopkeeperDao.findByEmail(email).getShopName();
	}
	@Override
	public String addProduct(String email, Product product) {
		System.out.println(email);
		Shopkeeper shopkeeper=shopkeeperDao.findByEmail(email);
		product.setAddedDate(LocalDate.now());
		shopkeeper.setProductList(product);
		shopkeeperDao.save(shopkeeper); 
		return "Added";
	}
	public List<ProductResponse> getAllProduct(String email){
		Shopkeeper shopkeeper=shopkeeperDao.findByEmail(email);
		return shopkeeperDao.getAllProduct(shopkeeper.getId());
	}
	@Override
	public String removeProduct(String email,int productId) {
		Shopkeeper shopkeeper=shopkeeperDao.findByEmail(email);
		Product product=shopkeeperDao.getProductById(productId);
		shopkeeper.removeProduct(product);
		shopkeeperDao.save(shopkeeper);
		return "Deleted";
	}
	@Override
	public ProductResponse getProduct(int productId) {
		Product product= shopkeeperDao.getProductById(productId);
		return new ProductResponse(product.getProductId(), product.getProductName(), product.getProductQuantity(), product.getProductUnit(), product.getProductPrice());
		
	}
	@Override
	public String updateProductItem(String email, Product product) {
		Shopkeeper shopkeeper=shopkeeperDao.findByEmail(email);
		Product productTemProduct=shopkeeperDao.getProductById(product.getProductId());
		product.setAddedDate(productTemProduct.getAddedDate());
		shopkeeper.setProductList(product);
		shopkeeperDao.save(shopkeeper);
		return "Updated";
		
	}
	@Override
	public List<ShopkeeperOrderResponse> getOrders(String email) {
		Shopkeeper shopkeeper= shopkeeperDao.findByEmail(email);
		return orderDetailsDao.getAllOrders(shopkeeper.getId());
	}
	@Override
	public String acceptOrder(int orderId) {
		OrderDetails orderDetails=orderDetailsDao.findById(orderId).get();
		orderDetails.setStatus("On Progress");
		orderDetailsDao.save(orderDetails);
		return "Done";
	}
	@Override
	public List<OrderResponseShopkeeper> getOrderDetails(String shopkeeperEmail) {
		Shopkeeper shopkeeper = shopkeeperDao.findByEmail(shopkeeperEmail);
		return orderDetailsDao.getOrderDetailsForShopkeeper(shopkeeper.getId());
	}
	@Override
	public ShopkeeperOrderResponse getSingleOrderDetails(int orderId) {
		return orderDetailsDao.getSingleOrderDetailsForShopkeeper(orderId);
	}
	@Override
	public List<ProductResponse> getProductListFromOrderDetails(int orderId) {
		return orderDetailsDao.getAllProductFromOrderDetails(orderId);
	}
	@Override
	public ShopkeeperOrderResponse updateOrderStatusToDelivered(int orderId) {
		OrderDetails orderDetails = orderDetailsDao.findById(orderId).get();
		orderDetails.setStatus("Delivered");
		orderDetails.setPayment("true");
		orderDetailsDao.save(orderDetails);
		return orderDetailsDao.getSingleOrderDetailsForShopkeeper(orderId);
	}
	@Override
	public String openClose(String email) {
		Shopkeeper shopkeeper = shopkeeperDao.findByEmail(email);
		if(shopkeeper.getStatus().equals("OPEN"))
			shopkeeper.setStatus("CLOSED");
		else {
			shopkeeper.setStatus("OPEN");
		}
		shopkeeperDao.save(shopkeeper);
		return shopkeeper.getStatus();
	}
	@Override
	public String checkOrder(String email) {
		Shopkeeper shopkeeper = shopkeeperDao.findByEmail(email);
		
			List<String> orders=orderDetailsDao.checkOrder(shopkeeper.getId());
			if(orders.isEmpty()) {
				return "false";
			}
			else {
				return "true";
			}
		
		}
	@Override
	public String closeStore(String email) {
		Shopkeeper shopkeeper = shopkeeperDao.findByEmail(email);
		shopkeeper.setStatus("CLOSED");
		shopkeeperDao.save(shopkeeper);
		return "done";
	}
	@Override
	public ShopkeeperDetailsRequest getShopkeeperDetails(String email) {
		Shopkeeper shopkeeper = shopkeeperDao.findByEmail(email);
		return new ShopkeeperDetailsRequest(shopkeeper.getShopName(),shopkeeper.getShopAddreas(),shopkeeper.getShopRegisterationId(),shopkeeper.getMobileNo());
	}
	@Override
	public String updateShopkeeperDetails(String email, ShopkeeperDetailsRequest shopkeeperDetailsRequest) {
		Shopkeeper shopkeeper = shopkeeperDao.findByEmail(email);
		Customer customer=customerDao.findByMobileNo(shopkeeperDetailsRequest.getMobileNo());
		Shopkeeper temp = shopkeeperDao.findByMobileNo(shopkeeperDetailsRequest.getMobileNo());
		if(shopkeeperDetailsRequest.getMobileNo()==shopkeeper.getMobileNo()||temp==null&&customer==null) {
			shopkeeper.setShopName(shopkeeperDetailsRequest.getShopName());
			shopkeeper.setShopAddreas(shopkeeperDetailsRequest.getAdd());
			shopkeeper.setMobileNo(shopkeeperDetailsRequest.getMobileNo());
			shopkeeper.setShopRegisterationId(shopkeeperDetailsRequest.getRegisterationId());
			shopkeeperDao.save(shopkeeper);
		}
		else {
			throw new NumberAlreadyInUseException("Number already in use");
		}
		return "Done";
		
	}
	@Override
	public String changePassword(String email, String oldPassword, String newPassword) {
		Shopkeeper shopkeeper = shopkeeperDao.findByEmail(email);
		if(shopkeeper.getPassword().equals(oldPassword)) {
			if(oldPassword.equals(newPassword)) {
				throw new SamePasswordException("You have entered the same password");
			}
			else {
				shopkeeper.setPassword(newPassword);
				shopkeeperDao.save(shopkeeper);
				return "done";
			}
		}else {
			throw new IncorrectPasswordException("Incorrect Password");
		}
	}
	

}
