package com.cg.service;

import java.util.List;

import com.cg.beans.Product;
import com.cg.dao.IProductDAO;
import com.cg.dao.ProductDAOImpl;
import com.cg.service.IProductService;

public class ProductServiceImpl implements IProductService {
	IProductDAO dao;
	public ProductServiceImpl() {
		dao = new ProductDAOImpl();
	}
	@Override
	public List<Product> getAllProducts() {
		
		return dao.getAllProducts();
	}
	@Override
	public Product getProduct(int id) {
		
		return dao.getProduct(id);
	}
	@Override
	public Product addProduct(Product product) {
		
		return dao.addProduct(product);
	}
	@Override
	public Product deleteProduct(int id) {
		
		return dao.deleteProduct(id);
	}
	@Override
	public Product updateProduct(Product product) {
		
		return dao.updateProduct(product);
	}
}
