package com.app.local2door.controller;


import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;


import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import com.app.local2door.config.JWTTokenHelper;

import com.app.local2door.service.IFileStorageService;

import com.app.local2door.pojo.Shopkeeper;

@RestController
@CrossOrigin("*")
@RequestMapping("/filehandler")
public class FileHandler {
	@Autowired
	IFileStorageService storageService;
	@Autowired
	JWTTokenHelper jwtTokenHelper;
	@PostMapping("/profileimage/{user}/{id}")
	public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file,@PathVariable int id,@PathVariable String user)  {
		
		if(user.equals("customer"))
			return new ResponseEntity<>(storageService.storeCustomerProfile(file,id),HttpStatus.OK);
		else {
			return new ResponseEntity<>(storageService.storeShopkeeperProfile(file, id),HttpStatus.OK);
		}
	}
	@GetMapping("/shopkeeper/profile/{id}")
	public ResponseEntity<byte[]> getShopkeeperImage(@PathVariable Integer id) {
		Shopkeeper shopkeeper=storageService.getShopkeeperImage(id);
		System.out.println("inside profile");
		if(shopkeeper.getProfileImage()==null) {
			BufferedImage bImage;
			try {
				bImage = ImageIO.read(new File("sample.jpg"));
				ByteArrayOutputStream bos = new ByteArrayOutputStream();
			    ImageIO.write(bImage, "jpg", bos );
			    byte [] data = bos.toByteArray();
			    return ResponseEntity.ok().body(data);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		    
		}
		return ResponseEntity.ok().body(shopkeeper.getProfileImage());
	}

			

		
	
	
}
