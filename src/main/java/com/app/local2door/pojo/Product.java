package com.app.local2door.pojo;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@ToString
@DynamicUpdate
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Integer productId;
    @Column(name = "product_name")
    private String productName;
    @Column(name = "product_quantity")
    private double productQuantity;
    @Column(name = "product_unit")
    @Enumerated(EnumType.STRING)
    private Unit productUnit;
    @Column(name = "product_price")
    private double productPrice;
    
    
    @Column(name = "added_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate addedDate;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shopkeeper_id")
    private Shopkeeper shopkeeperId;
    @Version
    private long version;
    
    public LocalDate getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(LocalDate addedDate) {
        this.addedDate = addedDate;
    }

    

    public Shopkeeper getShopkeeperId() {
        return shopkeeperId;
    }

    public void setShopkeeperId(Shopkeeper shopkeeperId) {
        this.shopkeeperId = shopkeeperId;
    }

    public Product() {
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(double productQuantity) {
        this.productQuantity = productQuantity;
    }

    public Unit getProductUnit() {
        return productUnit;
    }

    public void setProductUnit(Unit productUnit) {
        this.productUnit = productUnit;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    

   
	

	public Product(String productName, double productQuantity, Unit productUnit, double productPrice, 
			LocalDate addedDate) {
		super();
		this.productName = productName;
		this.productQuantity = productQuantity;
		this.productUnit = productUnit;
		this.productPrice = productPrice;
		
		this.addedDate = addedDate;
	}
	
	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}
}
