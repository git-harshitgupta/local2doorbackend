package com.app.local2door.pojo;
import lombok.AllArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@DynamicUpdate
public class Customer extends LoginDetails implements Serializable  {
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

    @Column(name = "profile_image")
    private String profileImage;
    @OneToMany(mappedBy = "customerId")
    private List<OrderDetails> orderDetailsList = new ArrayList<>();


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

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public void addOrderDetails(OrderDetails orderDetails){
        orderDetailsList.add(orderDetails);
        orderDetails.setCustomerId(this);
    }

}
