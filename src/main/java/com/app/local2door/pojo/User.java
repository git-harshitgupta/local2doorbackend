package com.app.local2door.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;


public class User implements Serializable {
    private String name;
    private String email;
    private String password;
    private String location;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
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
}
