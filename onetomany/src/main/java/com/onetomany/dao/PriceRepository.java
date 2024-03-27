package com.onetomany.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onetomany.model.Price;

@Repository
public interface PriceRepository extends JpaRepository<Price,Integer>{

}
