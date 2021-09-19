package com.app.local2door.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.local2door.config.JWTTokenHelper;
import com.app.local2door.service.IShopkeeperService;

@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*")
@RequestMapping("/shopkeeper")
public class ShopkeeperController {
	@Autowired
	JWTTokenHelper jwtTokenHelper;
	@Autowired
	IShopkeeperService shopkeeperService;
	@GetMapping
	public ResponseEntity<?> getShopName(@RequestParam("authorization") String authorization){
		
        String username = jwtTokenHelper.extractUsername(authorization);
		return new ResponseEntity(shopkeeperService.getShopkeeperName(username),HttpStatus.OK);
	}
}
