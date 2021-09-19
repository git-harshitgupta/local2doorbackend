package com.app.local2door.pojo;

import java.io.Serializable;
import javax.persistence.*;
@MappedSuperclass
public class LoginDetails implements Serializable {
	
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer id;
	    @Column(unique = true)
	    private String email;
	    private String password;
	    @Column(name = "mobile_no",unique = true)
	    private long mobileNo;
	    @Enumerated(EnumType.STRING)
	    private Type user;
	    private String location;

	    public LoginDetails() {
	    }

	    public Integer getId() {
	        return id;
	    }

	    public void setId(Integer id) {
	        this.id = id;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

	    public String getPassword() {
	        return password;
	    }

	    public void setPassword(String password) {
	        this.password = password;
	    }

	    public long getMobileNo() {
	        return mobileNo;
	    }

	    public void setMobileNo(long mobileNo) {
	        this.mobileNo = mobileNo;
	    }

	    public Type getUser() {
	        return user;
	    }

	    public void setUser(Type user) {
	        this.user = user;
	    }

	    public String getLocation() {
	        return location;
	    }

	    public void setLocation(String location) {
	        this.location = location;
	    }
}
