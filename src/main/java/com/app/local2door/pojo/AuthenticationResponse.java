package com.app.local2door.pojo;

import java.io.Serializable;

public class AuthenticationResponse implements Serializable{
	private final String jwt;
    private final String type;

    public AuthenticationResponse(String jwt,String type) {
        this.jwt = jwt;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public String getJwt() {
        return jwt;
    }
}
