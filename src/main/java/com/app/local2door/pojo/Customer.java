package com.app.local2door.pojo;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@DynamicUpdate
public class Customer extends LoginDetails implements Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
    @Column(name = "full_addreas")
    private String fullAddreas;
    @Column(name = "house_no")
    private String houseNo;

    @Enumerated(EnumType.STRING)
    private Type type;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "join_date")
    private LocalDate joinDate;

    @Lob
    private byte[] profileImage;
    


    public Customer() {
    }

    public LocalDate getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(LocalDate joinDate) {
        this.joinDate = joinDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String namme) {
        this.name = namme;
    }

    public String getFullAddreas() {
        return fullAddreas;
    }

    public void setFullAddreas(String fullAddreas) {
        this.fullAddreas = fullAddreas;
    }

    public String getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }



    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

	public byte[] getProfileImage() {
		return profileImage;
	}

	public void setProfileImage(byte[] profileImage) {
		this.profileImage = profileImage;
	}

    

   

}
