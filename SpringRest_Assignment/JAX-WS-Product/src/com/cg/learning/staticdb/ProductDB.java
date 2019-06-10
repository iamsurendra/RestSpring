package com.cg.learning.staticdb;

import java.util.HashMap;



public class ProductDB {
	static HashMap<Integer, Product> productIdMap = getProductIdMap();

	static {
		if (productIdMap == null) {
			productIdMap = new HashMap<Integer, Product>();
			Product price1 = new Product("pen", 10);
			Product price2 = new Product("pencil",5);
			

			productIdMap.put(1, price1);
			productIdMap.put(4, price1);
			
		}

	}
	
	public static HashMap<Integer, Product> getProductIdMap() {
		return productIdMap;
	}
}
