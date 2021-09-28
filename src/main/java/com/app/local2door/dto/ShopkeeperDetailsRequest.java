package com.app.local2door.dto;

import java.io.Serializable;

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
public class ShopkeeperDetailsRequest implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String shopName;
	private String add;
	private String registerationId;
	private long mobileNo;
	public ShopkeeperDetailsRequest(String shopName, String add, String registerationId, long mobileNo) {
		super();
		this.shopName = shopName;
		this.add = add;
		this.registerationId = registerationId;
		this.mobileNo = mobileNo;
	}
	
	
}
