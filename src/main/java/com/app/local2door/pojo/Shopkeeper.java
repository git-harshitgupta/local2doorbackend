package com.app.local2door.pojo;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.ToString;

import javax.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@ToString
@DynamicUpdate
public class Shopkeeper extends LoginDetails implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name="shop_name")
    private String shopName;
    @Column(name = "shop_addreas")
    private String shopAddreas;
    @Column(name = "shop_registeration_id")
    private String shopRegisterationId;
    @Enumerated(EnumType.STRING)
    private Type type;
    @Lob
    private byte[] profileImage;
    private String status;
    @Column(name="join_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate joinDate;
    @OneToMany(mappedBy = "shopkeeperId",cascade = CascadeType.ALL, orphanRemoval = true)
    List<Product> productList = new ArrayList<>();
    
    public Shopkeeper() {
    }
    

    public LocalDate getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(LocalDate joinDate) {
        this.joinDate = joinDate;
    }

    

    public byte[] getProfileImage() {
		return profileImage;
	}

	public void setProfileImage(byte[] profileImage) {
		this.profileImage = profileImage;
	}

	public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopAddreas() {
        return shopAddreas;
    }

    public void setShopAddreas(String shopAddreas) {
        this.shopAddreas = shopAddreas;
    }

    public String getShopRegisterationId() {
        return shopRegisterationId;
    }

    public void setShopRegisterationId(String shopRegisterationId) {
        this.shopRegisterationId = shopRegisterationId;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void setProductList(Product product){
        productList.add(product);
        product.setShopkeeperId(this);
    }

    public void removeProduct(Product product){
        productList.remove(product);
        product.setShopkeeperId(null);
    }
    
    public List<Product> getProductList() {
    	return productList;
    }	
   

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
