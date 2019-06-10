package com.cg.dao;

import java.util.List;

import com.cg.beans.Product;

public interface IProductDAO {
	public List<Product> getAllProducts();
	public Product getProduct(int id);
	public Product addProduct(Product product);
	public Product updateProduct(Product product);
	public Product deleteProduct(int id);
}
