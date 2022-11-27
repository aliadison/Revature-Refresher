package com.revature.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.model.Stock;

@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<Stock, Integer>{
	
	ArrayList<Stock> findAll();
	
	Stock findById(int id);
	

}
