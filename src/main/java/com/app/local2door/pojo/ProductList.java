package com.app.local2door.pojo;

import java.io.Serializable;


import javax.persistence.*;

import org.hibernate.annotations.DynamicUpdate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ordered_product_list")
@NoArgsConstructor
@Setter
@Getter
@DynamicUpdate
public class ProductList implements Serializable{
	 	
	private static final long serialVersionUID = 1L;
		@Id
	 	@GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer id;
	    @Column(name = "product_id")
	    private int productId;
	    @Column(name = "product_name")
	    private String productName;
	    @Column(name = "product_quantity")
	    private double productQunatity;
	    @Column(name = "product_price")
	    private double productPrice;
	    @Column(name="total_price")
	    private double productTotalPrice;

		@Column(name = "product_unit")
		@Enumerated(EnumType.STRING)
	    private Unit productUnit;

		
	    
	    
	    
}
