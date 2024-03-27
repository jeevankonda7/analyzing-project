package com.onetomany.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onetomany.dao.PriceRepository;
import com.onetomany.dao.TypeRepository;
import com.onetomany.model.Price;
import com.onetomany.model.ProductType;

@Service
public class DropdownService {

	@Autowired
	private TypeRepository typerepo;
	
	@Autowired
	private PriceRepository pricerepo;
	
	public ProductType savedata(ProductType type) {
	    ProductType savedProductType = typerepo.save(type);
	    for (Price p : type.getPrice()) {
	        p.setProductType(savedProductType);
	        pricerepo.save(p);
	    }
	    return savedProductType;
	}

	
	public List<ProductType> gettype() {
		return typerepo.findAll();
	}
	public ProductType getPricebytypeid(Integer id){
		return typerepo.findById(id).get();
	}
}
