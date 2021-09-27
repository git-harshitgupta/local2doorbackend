package com.app.local2door.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.app.local2door.pojo.Type;
import com.app.local2door.pojo.User;
import com.app.local2door.service.ILoginAndSignUpService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class LoginAndSingupController {
    @Autowired
    ILoginAndSignUpService iLoginAndSignupService;
    @GetMapping("/emailexist/{email}")
    public String getEmailIfExist(@PathVariable String email){
    	System.err.println(email);
        return iLoginAndSignupService.emailExist(email);
    }
    @GetMapping("/phoneexist/{phone}")
    public String getPhoneIfExist(@PathVariable long phone) {
    	return iLoginAndSignupService.phoneExist(phone);
    }

    @PostMapping("/adduser")
    public ResponseEntity<?> saveUser(@RequestBody User user)  {

        System.out.println("in save user "+user);// user : not null , except id
        if(user.getUser().equals(Type.CUSTOMER.name()))
            return new ResponseEntity<>(iLoginAndSignupService.saveUserDetails(user), HttpStatus.CREATED);
        else
            return new ResponseEntity<>(iLoginAndSignupService.saveShopkeeperDetails(user), HttpStatus.CREATED);
    }

    

}
