package com.cg.staticdb;

import java.util.HashMap;

import com.cg.beans.ProductV1;

public class ProductDBV1 {
	static HashMap<Integer, ProductV1> ProductV1IdMapv1 = getProductV1IdMap();

	static {
		if (ProductV1IdMapv1 == null) {
			ProductV1IdMapv1 = new HashMap<Integer, ProductV1>();
			ProductV1 car = new ProductV1(1, "car");
			ProductV1 bus = new ProductV1(4, "Bus");
			ProductV1 ly = new ProductV1(3, "Lorry");
			ProductV1 flight = new ProductV1(2, "Flight");

			ProductV1IdMapv1.put(1, car);
			ProductV1IdMapv1.put(4, bus);
			ProductV1IdMapv1.put(3, ly);
			ProductV1IdMapv1.put(2, flight);
		}

	}
	
	public static HashMap<Integer, ProductV1> getProductV1IdMap() {
		return ProductV1IdMapv1;
	}
}
