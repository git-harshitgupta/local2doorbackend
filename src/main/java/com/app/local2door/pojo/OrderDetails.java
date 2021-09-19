package com.app.local2door.pojo;

import java.io.Serializable;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class OrderDetails implements Serializable{
	@Id
    @Column(name = "order_id")
    Integer orderId;
    @Column(name = "order_time")
    private LocalTime orderTime;
    @Column(name = "order_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate orderDate;
    @OneToMany(mappedBy = "orderDetails")
    private List<ProductList> productLists=new ArrayList<>();
    @ManyToOne
    @JoinColumn(name ="customer_id")
    private Customer customerId;

    @ManyToOne
    @JoinColumn(name = "shopkeeper_id")
    private Shopkeeper shopkeeperId;
    private double totalPrice;
    public OrderDetails() {
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

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

    public List<ProductList> getProductLists() {
        return productLists;
    }

    public void setProductLists(ProductList productList) {
        productLists.add(productList);
        productList.setOrderDetails(this);
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
