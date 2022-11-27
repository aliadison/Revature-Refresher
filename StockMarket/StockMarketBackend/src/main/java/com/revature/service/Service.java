package com.revature.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.revature.model.Stock;
import com.revature.repository.Repository;

@org.springframework.stereotype.Service
public class Service {
	
	@Autowired
	private Repository repository;
	
	public ArrayList<Stock> findAll(){
		return this.repository.findAll();
	}
	
	public Stock findById(int id) {
		return this.repository.findById(id);
	}
}
