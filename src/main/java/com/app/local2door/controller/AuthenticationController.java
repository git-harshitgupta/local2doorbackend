package com.app.local2door.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.local2door.config.JWTTokenHelper;
import com.app.local2door.dto.AuthenticationRequest;
import com.app.local2door.dto.AuthenticationResponse;
import com.app.local2door.service.ILoginAndSignUpService;
import com.app.local2door.service.MyCustomerDetailsService;

@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class AuthenticationController {
	@Autowired
	private JWTTokenHelper jwtTokenHelper;
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private MyCustomerDetailsService myUserDetailsService;
	@Autowired
	private ILoginAndSignUpService loginAndSignupService;
	
	@PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        System.out.println(authenticationRequest.getUsername()+" "+authenticationRequest.getPassword());
		try{
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );
        }
        catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }	
        final UserDetails userDetails = myUserDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());

        final String jwt = jwtTokenHelper.generateToken(userDetails);
        String userType=loginAndSignupService.getCustomer(authenticationRequest.getUsername());
        return ResponseEntity.ok(new AuthenticationResponse(jwt,userType,authenticationRequest.getUsername()));
    }
}
