package com.cg.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.cg.beans.Product;
import com.cg.beans.ProductV1;
import com.cg.staticdb.ProductDB;
import com.cg.staticdb.ProductDBV1;


@Repository
public class ProductDAOImpl implements IProductDAO {
	static HashMap<Integer, Product> productIdMap = ProductDB.getProductIdMap();
	static HashMap<Integer, ProductV1> productIdMapV1 = ProductDBV1.getProductV1IdMap();

	@Override
	public List<Product> getAllProducts() {
		List<Product> products = new ArrayList<Product>(productIdMap.values());
		return products;
	}
	@Override
	public List<ProductV1> getAllProductsV1() {
		List<ProductV1> productsv1 = new ArrayList<ProductV1>(productIdMapV1.values());
		return productsv1;
	}
	@Override
	public Product addProduct(Product product) {
		productIdMap.put(product.getProductId(), product);
		return product;
	}
	@Override
	public Product getProductById(int id) {
		Product product = productIdMap.get(id);
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
