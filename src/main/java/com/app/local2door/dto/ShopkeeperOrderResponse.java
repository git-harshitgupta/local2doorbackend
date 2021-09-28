package com.app.local2door.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data

@NoArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class ShopkeeperOrderResponse implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int orderId;
	private String customerName;
	private String customerAdd;
	private String customerHouseNo;
	private double totalPrice;
	private String payment;
	private String status;
	private LocalDate orderDate;
	private LocalTime orderTime;
	private long mobileNo;
	public ShopkeeperOrderResponse(int orderId, String customerName, String customerAdd, String customerHouseNo, double totalPrice,
			String payment, String status, LocalDate orderDate, LocalTime orderTime,long mobile) {
		super();
		this.orderId=orderId;
		this.customerName = customerName;
		this.customerAdd = customerAdd;
		this.customerHouseNo = customerHouseNo;
		this.totalPrice = totalPrice;
		this.payment = payment;
		this.status = status;
		this.orderDate = orderDate;
		this.orderTime = orderTime;
		this.mobileNo=mobile;
	}
	
	
}
