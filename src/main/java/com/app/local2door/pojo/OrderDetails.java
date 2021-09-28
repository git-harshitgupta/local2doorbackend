package com.app.local2door.pojo;

import java.io.Serializable;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;


@Entity
public class OrderDetails implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Integer orderId;
    @Column(name = "order_time")
    private LocalTime orderTime;
    @Column(name = "order_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate orderDate;
//    @OneToMany(mappedBy = "shopkeeperId",cascade = CascadeType.ALL, orphanRemoval = true)
//    List<Product> productList = new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name="order_id")
    private List<ProductList> productLists;
    @OneToOne
    @JoinColumn(name ="customer_id")
    private Customer customerId;

    @OneToOne
    @JoinColumn(name = "shopkeeper_id")
    private Shopkeeper shopkeeperId;
    @Column(name = "total_price")
    private double totalPrice;
    
    private String payment;
    private String status;
	public LocalTime getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(LocalTime orderTime) {
		this.orderTime = orderTime;
	}
	public LocalDate getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}
	public List<ProductList> getProductLists() {
		return productLists;
	}
	public void setProductLists(List<ProductList> productLists) {
		this.productLists = productLists;
	}
	public Customer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Customer customerId) {
		this.customerId = customerId;
	}
	public Shopkeeper getShopkeeperId() {
		return shopkeeperId;
	}
	public void setShopkeeperId(Shopkeeper shopkeeperId) {
		this.shopkeeperId = shopkeeperId;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	public String getPayment() {
		return payment;
	}
	public void setPayment(String payment) {
		this.payment = payment;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
    
}
