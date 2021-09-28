package com.app.local2door.dto;

import java.io.Serializable;



import com.app.local2door.pojo.Unit;
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

public class ProductResponse implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Integer productId;
	private String productName;
	private double productQuantity;
	private Unit productUnit;
	private double productPrice;
	public ProductResponse(Integer productId, String productName, double productQuantity, Unit productUnit,
			double productPrice) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productQuantity = productQuantity;
		this.productUnit = productUnit;
		this.productPrice = productPrice;
	}
	
	
	
}
