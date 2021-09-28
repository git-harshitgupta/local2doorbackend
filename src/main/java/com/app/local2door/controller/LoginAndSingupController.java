package com.app.local2door.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.app.local2door.dto.User;
import com.app.local2door.pojo.Type;
import com.app.local2door.service.ILoginAndSignUpService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class LoginAndSingupController {
    @Autowired
    ILoginAndSignUpService iLoginAndSignupService;
    @GetMapping("/emailexist/{email}")
    public ResponseEntity<?> getEmailIfExist(@PathVariable String email){
    	System.err.println(email);
    	return new ResponseEntity<> (iLoginAndSignupService.emailExist(email),HttpStatus.OK);
    }
    @GetMapping("/phoneexist/{phone}")
    public ResponseEntity<?> getPhoneIfExist(@PathVariable long phone) {
    	return new ResponseEntity<> (iLoginAndSignupService.phoneExist(phone),HttpStatus.OK);
    }

    @PostMapping("/adduser")
    public ResponseEntity<?> saveUser(@RequestBody User user)  {

       
        if(user.getUser().equals(Type.CUSTOMER.name()))
            return new ResponseEntity<>(iLoginAndSignupService.saveUserDetails(user), HttpStatus.CREATED);
        else
            return new ResponseEntity<>(iLoginAndSignupService.saveShopkeeperDetails(user), HttpStatus.CREATED);
    }

    

}
