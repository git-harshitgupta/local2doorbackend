package com.app.local2door.pojo;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@DynamicUpdate
public class Shopkeeper extends LoginDetails implements Serializable{
	
	@Column(name="shop_name")
    private String shopName;
    @Column(name = "shop_addreas")
    private String shopAddreas;
    @Column(name = "shop_registeration_id")
    private String shopRegisterationId;
    @Enumerated(EnumType.STRING)
    private Type type;
    @Column(name = "shop_image")
    private String shopImage;
    @Column(name="join_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate joinDate;
    @OneToMany(mappedBy = "shopkeeperId")
    List<Product> productList = new ArrayList<>();
    @OneToMany(mappedBy = "shopkeeperId")
    List<OrderDetails> orderDetailsList = new ArrayList<>();
    @ElementCollection
    @CollectionTable(name = "feed",joinColumns = @JoinColumn(name="feed_id"))
    private List<ShopkeeperFeed> feeds = new ArrayList<>();
    public Shopkeeper() {
    }

    public LocalDate getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(LocalDate joinDate) {
        this.joinDate = joinDate;
    }

    public String getShopImage() {
        return shopImage;
    }

    public void setShopImage(String shopImage) {
        this.shopImage = shopImage;
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

    public void setOrderDetails(OrderDetails orderDetails){
        orderDetailsList.add(orderDetails);
        orderDetails.setShopkeeperId(this);
    }

    public List<ShopkeeperFeed> getFeeds() {
        return feeds;
    }

    public void setFeeds(List<ShopkeeperFeed> feeds) {
        this.feeds = feeds;
    }
}
