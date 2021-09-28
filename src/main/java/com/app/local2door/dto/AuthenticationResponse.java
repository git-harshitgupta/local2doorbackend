package com.app.local2door.dto;

import java.io.Serializable;

public class AuthenticationResponse implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final String jwt;
    private final String type;
    private final String email;

    public AuthenticationResponse(String jwt,String type,String email) {
        this.jwt = jwt;
        this.type = type;
        this.email=email;
    }

    public String getType() {
        return type;
    }

    public String getJwt() {
        return jwt;
    }

	public String getId() {
		return email;
	}
    
    
}
