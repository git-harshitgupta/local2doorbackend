package com.app.local2door.pojo;

import javax.persistence.*;

@Entity
public class ProductList {
	 	@Id
	    private Integer id;
	    @Column(name = "product_id")
	    private int productId;
	    @Column(name = "product_name")
	    private String productName;
	    private double quantity;
	    private int price;
	    @Column(name = "product_unit")
	    @Enumerated(EnumType.STRING)
	    private Unit productUnit;
	    @ManyToOne
	    @JoinColumn(name = "order_id")
	    private OrderDetails orderDetails;
	    public ProductList() {
	    }

	    public int getProductId() {
	        return productId;
	    }

	    public void setProductId(int productId) {
	        this.productId = productId;
	    }

	    public String getProductName() {
	        return productName;
	    }

	    public void setProductName(String productName) {
	        this.productName = productName;
	    }

	    public double getQuantity() {
	        return quantity;
	    }

	    public void setQuantity(double quantity) {
	        this.quantity = quantity;
	    }

	    public int getPrice() {
	        return price;
	    }

	    public void setPrice(int price) {
	        this.price = price;
	    }

	    public Unit getProductUnit() {
	        return productUnit;
	    }

	    public void setProductUnit(Unit productUnit) {
	        this.productUnit = productUnit;
	    }

	    public Integer getId() {
	        return id;
	    }

	    public void setId(Integer id) {
	        this.id = id;
	    }

	    public OrderDetails getOrderDetails() {
	        return orderDetails;
	    }

	    public void setOrderDetails(OrderDetails orderDetails) {
	        this.orderDetails = orderDetails;
	    }
}
