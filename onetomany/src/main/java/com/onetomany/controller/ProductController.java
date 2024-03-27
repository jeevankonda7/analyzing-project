package com.onetomany.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onetomany.model.Order;
import com.onetomany.model.Product;
import com.onetomany.model.ProductType;
import com.onetomany.service.DropdownService;
import com.onetomany.service.ProductService;

@RestController
@RequestMapping("api/products")
@CrossOrigin(origins = "*")
public class ProductController {
	@Autowired
	private ProductService service;
	
	@Autowired
	private DropdownService dropdownservice;
	
	@GetMapping
	public List<Product> getAllProducts(){
		return service.getAllProduct();
	}
	@GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Integer id) {
        Product product = service.getbyproductId(id);
        return ResponseEntity.ok(product);
    }	
	@GetMapping("order/{id}")
	public ResponseEntity<Order> getOrderById(@PathVariable Integer id){
		Order order = service.gtbyorderId(id);
		return ResponseEntity.ok(order);
	}
	@PostMapping
	public ResponseEntity<Product> createorupdate(@RequestBody Product product){
		 Product saveorupdate = service.createorupdate(product);
		 if (saveorupdate != null) {
		        return ResponseEntity.ok(saveorupdate);
		    } else {
		        return null;
		    }
	}
	@DeleteMapping("/{id}")
    public ResponseEntity<Product> deleteproduct(@PathVariable Integer id){
    	Product product = service.getbyproductId(id);
    	boolean deleted=service.deleteproduct(id);
    	if(deleted) {
    		return ResponseEntity.ok(product);
    	}else {
    		return null;
    	}
    }
	
	@PostMapping("/data")
	public ResponseEntity<ProductType> save(@RequestBody ProductType type){
		 ProductType save = dropdownservice.savedata(type);
		 if (save!= null) {
		        return ResponseEntity.ok(save);
		    } else {
		        return null;
		    }
	}
	
	@GetMapping("/getproducttype")
	public List<ProductType> getProductType(){
		return dropdownservice.gettype();
	}
	@GetMapping("/getpricebytype/{id}")
	public ResponseEntity<ProductType> getpricebytype(@PathVariable Integer id){
		ProductType price= dropdownservice.getPricebytypeid(id);
		return new ResponseEntity<>(price,HttpStatus.OK);
	}
	

}

