package com.cg.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cg.beans.Product;
import com.cg.staticdb.ProductDB;



public class ProductDAOImpl implements IProductDAO {
	static HashMap<Integer, Product> productIdMap = ProductDB.getProductIdMap();

	@Override
	public List<Product> getAllProducts() {
		List<Product> products = new ArrayList<Product>(productIdMap.values());
		return products;
	}

	@Override
	public Product getProduct(int id) {
		Product product = productIdMap.get(id);
		return product;
	}

	@Override
	public Product addProduct(Product product) {
		productIdMap.put(product.getProductId(), product);
		return product;
	}

	
	public Product updateProduct(Product product) {
		int id=product.getProductId();
		for (Map.Entry<Integer, Product> p:productIdMap.entrySet()) {
			if (p.getKey()==id){
				Product pro=p.getValue();
				pro.setProductName(product.getProductName());
				pro.setPrice(product.getPrice());
			}
		}

		return product;

	}

	public Product deleteProduct(int id) {
		return productIdMap.remove(id);
	}

}
