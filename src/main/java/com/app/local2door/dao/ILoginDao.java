package com.app.local2door.dao;

import com.app.local2door.pojo.Customer;
import com.app.local2door.pojo.Shopkeeper;

public interface ILoginDao {
    Customer getCustomerDetails(String email);
    Shopkeeper getShopKeeperDetails(String email);
}
