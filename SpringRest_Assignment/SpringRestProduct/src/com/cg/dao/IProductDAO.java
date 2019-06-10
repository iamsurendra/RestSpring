package com.cg.dao;

import java.util.List;

import com.cg.beans.Product;
import com.cg.beans.ProductV1;

public interface IProductDAO {
	public List<Product> getAllProducts();
	public List<ProductV1> getAllProductsV1();
	public Product addProduct(Product product);
	public Product getProductById(int id);
	
	public Product updateProduct(Product product);
	public Product deleteProduct(int id);
}
