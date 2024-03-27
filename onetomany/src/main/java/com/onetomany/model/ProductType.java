package com.onetomany.model;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class ProductType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Integer id;
	private String name;
	
	@JsonIgnoreProperties("productType")
	@OneToMany(mappedBy = "productType")
	private List<Price> price;
	
	
	public List<Price> getPrice() {
		return price;
	}
	public void setPrice(List<Price> price) {
		this.price = price;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "ProductType [id=" + id + ", name=" + name + "]";
	}
	
	
}
