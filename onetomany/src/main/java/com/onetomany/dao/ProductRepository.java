package com.onetomany.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onetomany.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

}
