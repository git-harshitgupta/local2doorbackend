package com.app.local2door.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.app.local2door.config.JWTTokenHelper;
import com.app.local2door.dto.ChangeLocationRequest;
import com.app.local2door.dto.PasswordChangeRequest;
import com.app.local2door.dto.UserDetails;
import com.app.local2door.pojo.ProductList;
import com.app.local2door.service.ICustomerService;
import com.app.local2door.service.IFileStorageService;


@RestController
@CrossOrigin("*")
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	ICustomerService customerService;
	@Autowired
	JWTTokenHelper jwtTokenHelper;
	@Autowired
	IFileStorageService storageService;
	
	@GetMapping("/getallshop")
	public ResponseEntity<?> getAllShop(@RequestHeader("Authorization") String authorization){
		String jwt = authorization.substring(7);
        String username = jwtTokenHelper.extractUsername(jwt);
        
        return new ResponseEntity<>(customerService.getAllShop(username),HttpStatus.OK);
	}
	
	@GetMapping("/getallproducts")
	public ResponseEntity<?> getAllProduct(@RequestHeader("shopId") int shopId){
		return new ResponseEntity<>(customerService.getAllProduct(shopId),HttpStatus.OK);
	}
	@PostMapping("/placeorder")
	public ResponseEntity<?> placeOrder(@RequestHeader("order") String status,@RequestHeader("payment") String payment,@RequestHeader("Authorization") String authorization,@RequestHeader("shopId") int shopId,@RequestHeader("totalPrice") double totalPrice,@RequestBody List<ProductList> productLists){
		System.out.println("Inside controller");
		String jwt = authorization.substring(7);
        String username = jwtTokenHelper.extractUsername(jwt);
		return new ResponseEntity<>(customerService.placeAnOrder(status,payment,shopId, username, productLists, totalPrice),HttpStatus.OK);
	}
	@GetMapping("/getallorderdetails")
	public ResponseEntity<?> getAllOrderDetails(@RequestHeader("Authorization") String authorization){
		String jwt = authorization.substring(7);
        String username = jwtTokenHelper.extractUsername(jwt);
        return new ResponseEntity<>(customerService.getOrderDetails(username),HttpStatus.OK);
	}
	@GetMapping("/getorderdetails")
	public ResponseEntity<?> getOrderDetails(@RequestParam("orderId") int orderId){
		return new ResponseEntity<>(customerService.getSingleOrderDetails(orderId),HttpStatus.OK);
	}
	@GetMapping("/getproductlist")
	public ResponseEntity<?> getAllProductFromOrderDetail(@RequestParam("orderId") int orderId){
		return new ResponseEntity<>(customerService.getProductListFromOrderDetails(orderId),HttpStatus.OK);
	}
	@PostMapping("/chackavilability")
	public ResponseEntity<?> checkAvilability(@RequestBody List<ProductList> productLists){
		return new ResponseEntity<>(customerService.checkProductAvlability(productLists),HttpStatus.OK);
	}
	@GetMapping("/getuserdetails")
	public ResponseEntity<?> getUserInformation(@RequestHeader("Authorization") String authorization){
		String jwt = authorization.substring(7);
        String username = jwtTokenHelper.extractUsername(jwt);
        return new ResponseEntity<>(customerService.getCustomerInformation(username),HttpStatus.OK);
	}
	@PostMapping("/saveuserdetails")
	public ResponseEntity<?> saveUserDetails(@RequestHeader("Authorization") String authorization,@RequestBody UserDetails userDetails){
		String jwt = authorization.substring(7);
        String username = jwtTokenHelper.extractUsername(jwt);
        return new ResponseEntity<>(customerService.saveCustomerDetails(username,userDetails),HttpStatus.OK);
	}
	@PostMapping("/changepassword")
	public ResponseEntity<?> changePassword(@RequestHeader("Authorization") String authorization,@RequestBody PasswordChangeRequest passwordChangeRequest){
		String jwt = authorization.substring(7);
        String username = jwtTokenHelper.extractUsername(jwt);
        return new ResponseEntity<>(customerService.changePassword(username,passwordChangeRequest.getOldPassword() ,passwordChangeRequest.getNewPassword()),HttpStatus.OK);
	}
	@PostMapping("/changephone")
	public ResponseEntity<?> changePhone(@RequestHeader("Authorization") String authorization,@RequestBody String phone){
		String jwt = authorization.substring(7);
        String username = jwtTokenHelper.extractUsername(jwt);
        return new ResponseEntity<>(customerService.changePhone(username,phone),HttpStatus.OK);
	}
	@PostMapping("/changelocation")
	public ResponseEntity<?> changeLocation(@RequestHeader("Authorization") String authorization,@RequestBody ChangeLocationRequest changeLocationRequest){
		String jwt = authorization.substring(7);
        String username = jwtTokenHelper.extractUsername(jwt);
        System.out.println(changeLocationRequest);
        return new ResponseEntity<>(customerService.changeLocation(username,changeLocationRequest),HttpStatus.OK);
	}
	
}
