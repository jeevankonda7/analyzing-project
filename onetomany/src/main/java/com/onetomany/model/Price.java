package com.onetomany.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Price {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Integer id;
	private Integer cost;
	
	@ManyToOne
	@JsonIgnoreProperties("price")
    private ProductType productType;
	
	public ProductType getProductType() {
		return productType;
	}
	public void setProductType(ProductType productType) {
		this.productType = productType;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCost() {
		return cost;
	}
	public void setCost(Integer price) {
		this.cost = price;
	}
	@Override
	public String toString() {
		return "Price [id=" + id + ", cost=" + cost + ", productType=" + productType + "]";
	}
	
}
