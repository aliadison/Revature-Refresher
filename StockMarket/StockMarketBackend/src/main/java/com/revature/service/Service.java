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
	
	public Stock buyStock(Stock targetStock, int quantity) {
		Stock stock = this.repository.findById(targetStock.getId());
		if(quantity <= stock.getAvailable_shares() && targetStock.getPrice() >= stock.getPrice()) {
			stock.setAvailable_shares(stock.getAvailable_shares()-quantity);
			stock.setPrice(targetStock.getPrice());
			stock.setMarket_cap(stock.getPrice()*stock.getTotal_supply());
			return this.repository.save(stock);
		}
		return null;
	}
}
