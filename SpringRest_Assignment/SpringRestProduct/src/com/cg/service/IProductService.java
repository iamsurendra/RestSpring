package com.cg.service;

import java.util.List;

import com.cg.beans.Product;
import com.cg.beans.ProductV1;

public interface IProductService {
	
	public List<Product> getAllProducts();
	public Product getProductById(int id);
	public List<ProductV1> getAllProductsV1();
	public Product addProduct(Product product);
	public Product updateProduct(Product product);
	public Product deleteProduct(int id);
}
