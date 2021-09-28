package com.app.local2door.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.app.local2door.config.JWTTokenHelper;
import com.app.local2door.dto.PasswordChangeRequest;
import com.app.local2door.dto.ProductResponse;
import com.app.local2door.dto.ShopkeeperDetailsRequest;
import com.app.local2door.pojo.Product;
import com.app.local2door.service.IFileStorageService;
import com.app.local2door.service.IShopkeeperService;

@RestController
@CrossOrigin("*")
@RequestMapping("/shopkeeper")
public class ShopkeeperController {
	@Autowired
	IFileStorageService storageService;
	@Autowired
	JWTTokenHelper jwtTokenHelper;
	@Autowired
	IShopkeeperService shopkeeperService;
	@GetMapping("/name")
	public String getShopName(@RequestHeader("Authorization") String authorization){
		String jwt = authorization.substring(7);
		System.out.println(jwt);
        String username = jwtTokenHelper.extractUsername(jwt);
		
		return shopkeeperService.getShopkeeperName(username); 
	}
	@PostMapping("/addproduct")
	public ResponseEntity<?> addProduct(@RequestHeader("Authorization") String authorization,@RequestBody Product product){
		String jwt = authorization.substring(7);
		System.out.println(jwt);
        String username = jwtTokenHelper.extractUsername(jwt);
        System.out.println(product);
        return new ResponseEntity<>(shopkeeperService.addProduct(username,product),HttpStatus.CREATED);
	}
	@GetMapping("/getallproduct")
	public List<ProductResponse> getAllProduct(@RequestHeader("Authorization") String authorization){
		String jwt = authorization.substring(7);
        String username = jwtTokenHelper.extractUsername(jwt);
		return shopkeeperService.getAllProduct(username);
	}
	@DeleteMapping("/deleteproduct")
	public ResponseEntity<?> deleteProduct(@RequestHeader("ProductId") String productId,@RequestHeader("Authorization") String authorization){
		String jwt = authorization.substring(7);
        String username = jwtTokenHelper.extractUsername(jwt);
        System.out.println(productId);
        return new ResponseEntity<>( shopkeeperService.removeProduct(username,Integer.parseInt(productId)),HttpStatus.OK);

	}
	@GetMapping("/getproduct")
	public ResponseEntity<?> getProduct(@RequestHeader("ProductId") int id){
		return new ResponseEntity<>(shopkeeperService.getProduct(id),HttpStatus.OK);
	}
	@PutMapping("/updateproductitem")
	public ResponseEntity<?> updateProductItem(@RequestHeader("Authorization") String authorization,@RequestBody Product product){
		String jwt = authorization.substring(7);
	    String username = jwtTokenHelper.extractUsername(jwt);
	    return new ResponseEntity<>(shopkeeperService.updateProductItem(username, product),HttpStatus.OK);
	    
	}
	@GetMapping("/getorder")
	public ResponseEntity<?> getAllOrders(@RequestHeader("Authorization") String authorization){
		String jwt = authorization.substring(7);
	    String username = jwtTokenHelper.extractUsername(jwt);
	    return new ResponseEntity<>(shopkeeperService.getOrders(username),HttpStatus.OK);
	}
	@GetMapping("/acceptorder")
	public ResponseEntity<?> accpetOrder(@RequestParam("orderId") int id){
		return new ResponseEntity<>(shopkeeperService.acceptOrder(id),HttpStatus.OK);
	}
	@GetMapping("/getallorders")
	public ResponseEntity<?> getAllOrdersHistory(@RequestHeader("Authorization") String authorization){
		String jwt = authorization.substring(7);
	    String username = jwtTokenHelper.extractUsername(jwt);
	    return new ResponseEntity<>(shopkeeperService.getOrderDetails(username),HttpStatus.OK);
	}
	@GetMapping("/getorderdetails")
	public ResponseEntity<?> getOrderDetails(@RequestParam("orderId") int orderId){
		return new ResponseEntity<>(shopkeeperService.getSingleOrderDetails(orderId),HttpStatus.OK);
	}
	@GetMapping("/getproductlist")
	public ResponseEntity<?> getAllProductFromOrderDetail(@RequestParam("orderId") int orderId){
		return new ResponseEntity<>(shopkeeperService.getProductListFromOrderDetails(orderId),HttpStatus.OK);
	}
	@GetMapping("/productdelivered")
	public ResponseEntity<?> updateStatusToDelivered(@RequestParam("orderId") int orderId){
		return new ResponseEntity<>(shopkeeperService.updateOrderStatusToDelivered(orderId),HttpStatus.OK);
	}
	@GetMapping("/openclose")
	public ResponseEntity<?> openClose(@RequestHeader("Authorization") String authorization){
		String jwt = authorization.substring(7);
	    String username = jwtTokenHelper.extractUsername(jwt);
		return new ResponseEntity<>(shopkeeperService.openClose(username),HttpStatus.OK);
	}
	@GetMapping("/checkorder")
	public ResponseEntity<?> checkNewOrder(@RequestHeader("Authorization") String authorization){
		String jwt = authorization.substring(7);
	    String username = jwtTokenHelper.extractUsername(jwt);
		return new ResponseEntity<>(shopkeeperService.checkOrder(username),HttpStatus.OK);
	}
	@GetMapping("/closeStore")
	public ResponseEntity<?> closeStore(@RequestHeader("Authorization") String authorization){
		String jwt = authorization.substring(7);
	    String username = jwtTokenHelper.extractUsername(jwt);
		return new ResponseEntity<>(shopkeeperService.closeStore(username),HttpStatus.OK);
	
	}
	@GetMapping("/getshopkeeperdetails")
	public ResponseEntity<?> getShopkeeperDetails(@RequestHeader("Authorization") String authorization){
		String jwt = authorization.substring(7);
	    String username = jwtTokenHelper.extractUsername(jwt);
		return new ResponseEntity<>(shopkeeperService.getShopkeeperDetails(username),HttpStatus.OK);
	
	}
	@PostMapping("/updatedetails")
	public ResponseEntity<?> updateShopkeeperDetails(@RequestHeader("Authorization") String authorization,@RequestBody ShopkeeperDetailsRequest shopkeeperDetailsRequest){
		String jwt = authorization.substring(7);
	    String username = jwtTokenHelper.extractUsername(jwt);
		return new ResponseEntity<>(shopkeeperService.updateShopkeeperDetails(username,shopkeeperDetailsRequest),HttpStatus.OK);
	
	}
	@PostMapping("/changepassword")
	public ResponseEntity<?> changePassword(@RequestHeader("Authorization") String authorization,@RequestBody PasswordChangeRequest passwordChangeRequest){
		String jwt = authorization.substring(7);
        String username = jwtTokenHelper.extractUsername(jwt);
        return new ResponseEntity<>(shopkeeperService.changePassword(username,passwordChangeRequest.getOldPassword() ,passwordChangeRequest.getNewPassword()),HttpStatus.OK);
	}
	

}
