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
public class OrderResponseShopkeeper implements Serializable{
	private static final long serialVersionUID = 1L;
	private int orderId;
	private String customerName;
	private double totalPrice;
	private String payment;
	private LocalDate orderDate;
	private LocalTime localTime;
	private String status;
	public OrderResponseShopkeeper(int orderId, String customerName, double totalPrice, String payment, LocalDate orderDate,
			LocalTime localTime, String status) {
		super();
		this.orderId = orderId;
		this.customerName = customerName;
		this.totalPrice = totalPrice;
		this.payment = payment;
		this.orderDate = orderDate;
		this.localTime = localTime;
		this.status = status;
	}
}
