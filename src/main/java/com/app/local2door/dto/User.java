package com.app.local2door.dto;


import lombok.ToString;



import java.io.Serializable;

@ToString
public class User implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
    private String email;
    private String password;
    private double longi;
    private double lati;
    private String houseNo;
    private String fullAddreas;
    private String mobileNo;
    private String user;
    private String shopRegId;
    private String shopName;
    public User() {
    }

    public String getShopRegId() {
        return shopRegId;
    }
    
    

	public void setShopRegId(String shopRegId) {
        this.shopRegId = shopRegId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

 
    public String getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }

    public String getFullAddreas() {
        return fullAddreas;
    }

    public void setFullAddreas(String fullAddreas) {
        this.fullAddreas = fullAddreas;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
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
}
