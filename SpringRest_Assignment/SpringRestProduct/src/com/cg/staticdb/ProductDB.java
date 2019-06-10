package com.cg.staticdb;

import java.util.HashMap;

import com.cg.beans.Product;


public class ProductDB {
	static HashMap<Integer, Product> productIdMap = getProductIdMap();

	static {
		if (productIdMap == null) {
			productIdMap = new HashMap<Integer, Product>();
			Product car = new Product(1, "car", 10000);
			Product bus = new Product(4, "Bus", 20000);
			Product ly = new Product(3, "Lorry", 8000);
			Product flight = new Product(2, "Flight", 7000);

			productIdMap.put(1, car);
			productIdMap.put(4, bus);
			productIdMap.put(3, ly);
			productIdMap.put(2, flight);
		}

	}
	
	public static HashMap<Integer, Product> getProductIdMap() {
		return productIdMap;
	}
}
