package com.revature.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Stock {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String stock_name;
	private String symbol;
	private float price;
	private long total_supply;
	private long available_shares;
	private double market_cap;
}
