package com.app.local2door.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;


import javax.transaction.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.local2door.custom_excpt.IncorrectPasswordException;
import com.app.local2door.custom_excpt.NumberAlreadyInUseException;
import com.app.local2door.custom_excpt.ProductNotAvailableException;
import com.app.local2door.custom_excpt.SamePasswordException;
import com.app.local2door.dao.ICustomerDao;
import com.app.local2door.dao.IOrderDetailsDao;
import com.app.local2door.dao.IShopkeeperDao;
import com.app.local2door.dto.ChangeLocationRequest;
import com.app.local2door.dto.OrderResponseCustomer;
import com.app.local2door.dto.ProductResponse;
import com.app.local2door.dto.ShopResponse;
import com.app.local2door.dto.UserDetails;
import com.app.local2door.pojo.Customer;
import com.app.local2door.pojo.OrderDetails;
import com.app.local2door.pojo.Product;
import com.app.local2door.pojo.ProductList;
import com.app.local2door.pojo.Shopkeeper;

@Service
@Transactional
public class CustomerService implements ICustomerService{
	@Autowired
	IShopkeeperDao shopkeeperDao;
	@Autowired
	ICustomerDao customerDao;
	@Autowired
	IOrderDetailsDao orderDetailsDao;
	@Override
	public List<ShopResponse> getAllShop(String email) {
		Customer customer = customerDao.findByEmail(email);
		return shopkeeperDao.getAllShop(customer.getLongi()+0.005, customer.getLongi()-0.005, customer.getLati()+0.005, customer.getLati()-0.005);
		
	}
	@Override
	public List<ProductResponse> getAllProduct(int shopId) {
		
		return shopkeeperDao.getAllProduct(shopId);
	}
	@Override
	public String placeAnOrder(String staus,String payment ,int shopkeeperId, String customerEmail, List<ProductList> productList,double totalPrice) {
		Shopkeeper shopkeeper=shopkeeperDao.findById(shopkeeperId).get();
		Customer customer=customerDao.findByEmail(customerEmail);
		OrderDetails orderDetails=new OrderDetails();
		orderDetails.setCustomerId(customer);
		orderDetails.setShopkeeperId(shopkeeper);
		orderDetails.setProductLists(productList);
		orderDetails.setPayment(payment);
		orderDetails.setStatus(staus);
		orderDetails.setTotalPrice(totalPrice);
		orderDetails.setOrderDate(LocalDate.now());
		orderDetails.setOrderTime(LocalTime.now());
		orderDetailsDao.save(orderDetails);
		return "Added";
	}
	@Override
	public List<OrderResponseCustomer> getOrderDetails(String customerEmail) {
		Customer customer = customerDao.findByEmail(customerEmail);
		return orderDetailsDao.getOrderDetailsForCustomer(customer.getId());
	}
	@Override
	public OrderResponseCustomer getSingleOrderDetails(int orderId) {
		return orderDetailsDao.getSingleOrderDetailsForCustomer(orderId);
	}
	@Override
	public List<ProductResponse> getProductListFromOrderDetails(int orderId) {
		
		return orderDetailsDao.getAllProductFromOrderDetails(orderId);
	}
	@Override
	
	public String checkProductAvlability(List<ProductList> productLists) {
		productLists.stream().forEach(temp->{
			Product product = shopkeeperDao.getProductById(temp.getProductId());
			if(product.getProductQuantity()<temp.getProductQunatity()) {
				throw new ProductNotAvailableException("Product not avaliable");
			}
			else {
				product.setProductQuantity(product.getProductQuantity()-temp.getProductQunatity());
			}
		});
		return "Avilable";
	}
	@Override
	public UserDetails getCustomerInformation(String email) {
		return customerDao.getUserInformation(email);
	}
	@Override
	public String saveCustomerDetails(String email, UserDetails userDetails) {
		Customer customer=customerDao.findByEmail(email);
		customer.setName(userDetails.getName());
		customer.setFullAddreas(userDetails.getFullAdd());
		customer.setHouseNo(userDetails.getHouseNo());
		customerDao.save(customer);
		return "done";
	}
	@Override
	public String changePassword(String email, String oldPassword, String newPassword) {
		Customer customer = customerDao.findByEmail(email);
		if(customer.getPassword().equals(oldPassword)) {
			if(oldPassword.equals(newPassword)) {
				throw new SamePasswordException("You have entered the same password");
			}
			else {
				customer.setPassword(newPassword);
				customerDao.save(customer);
				return "done";
			}
		}else {
			throw new IncorrectPasswordException("Incorrect Password");
		}
	}
	@Override
	public String changePhone(String email, String phone) {
		Customer customer = customerDao.findByEmail(email);
		
		Customer temp=customerDao.findByMobileNo(Long.parseLong(phone.substring(0, 10)));
		Shopkeeper shopkeeper = shopkeeperDao.findByMobileNo(Long.parseLong(phone.substring(0, 10)));
		if(temp==null&&shopkeeper==null) {
			customer.setMobileNo(Long.parseLong(phone.substring(0, 10)));
		}
		else {
			throw new NumberAlreadyInUseException("Number is already in use");
		}
		return null;
		
	}
	@Override
	public String changeLocation(String email, ChangeLocationRequest changeLocationRequest) {
		Customer customer = customerDao.findByEmail(email);
		customer.setLati(changeLocationRequest.getLati());
		customer.setLongi(changeLocationRequest.getLongi());
		customerDao.save(customer);
		return "done";
	}

}
