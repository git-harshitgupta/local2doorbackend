package com.app.local2door.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.local2door.pojo.Customer;
import com.app.local2door.pojo.Shopkeeper;

import javax.persistence.EntityManager;
@Repository
public class LoginDao implements ILoginDao {
    @Autowired
    private EntityManager entityManager;

    @Override
    public Customer getCustomerDetails(String email) {

        String jpql="select c from Customer c where c.email=:email";
        try{
        return entityManager.createQuery(jpql,Customer.class).setParameter("email",email).getSingleResult();}catch (Exception e){
            return null;
        }

    }


    @Override
    public Shopkeeper getShopKeeperDetails(String email){
        String jpql="select s from Shopkeeper s where s.email=:email";
        try {
            return entityManager.createQuery(jpql,Shopkeeper.class).setParameter("email",email).getSingleResult();
        }catch (Exception e){
            return null;
        }

    }
}
