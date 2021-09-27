package com.app.local2door.controller;


import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.app.local2door.config.JWTTokenHelper;

import com.app.local2door.service.IFileStorageService;
import com.app.local2door.dto.*;
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
		}
		return ResponseEntity.ok().body(shopkeeper.getProfileImage());
	}
//				map(dbFile -> {
//			String fileDownloadUrl = ServletUriComponentsBuilder.fromCurrentContextPath() // Prepares a URL from the
//																							// host, port, scheme, and
//					// context path of the given HttpServletRequest.eg : http://localhost:8080/
//					.path("/shopkeeper/files/")// apends the resource name eg : http://localhost:8080/files
//					.path(dbFile.getId().toString()) // appends file id(resource id) http://localhost:8080/files/1
//					.toUriString();
//			System.out.println("url " + fileDownloadUrl);

			

		
	
	
}
