package com.revature.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Stock;
import com.revature.service.Service;

@RestController
@RequestMapping("/stocks")
public class Controller {

	@Autowired
	private Service service;
	
	@GetMapping(path="/all")
	public ArrayList<Stock> findAll(){
		return this.service.findAll();
	}
	
	@GetMapping(path="/id")
	public Stock findById(int id) {
		return this.service.findById(id);
	}
	
	@GetMapping(path="/test")
	public String test() {
		return "All Set!";
	}
}
