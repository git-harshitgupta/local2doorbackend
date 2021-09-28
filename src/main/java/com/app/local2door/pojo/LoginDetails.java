package com.app.local2door.pojo;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.DynamicUpdate;
@MappedSuperclass
@DynamicUpdate
public class LoginDetails implements Serializable {
	
	 	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	    private double longi;
	    private double lati;
	  

	    public LoginDetails() {
	    }

	    public Integer getId() {
	        return id;
	    }
	    

	    

		public double getLongi() {
			return longi;
		}

		public void setLongi(double longi) {
			this.longi = longi;
		}

		public double getLati() {
			return lati;
		}

		public void setLati(double lati) {
			this.lati = lati;
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

	    
}
