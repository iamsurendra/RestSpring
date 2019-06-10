package com.cg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.beans.Product;
import com.cg.beans.ProductV1;
import com.cg.dao.IProductDAO;
import com.cg.dao.ProductDAOImpl;
import com.cg.service.IProductService;
@Service
public class ProductServiceImpl implements IProductService {
	@Autowired
	IProductDAO dao;
	
	@Override
	public List<Product> getAllProducts() {
		
		return dao.getAllProducts();
	}
	@Override
	public List<ProductV1> getAllProductsV1() {
		
		return dao.getAllProductsV1();
	}
	@Override
	public Product addProduct(Product product) {
		
		return dao.addProduct(product);
	}
	@Override
	public Product getProductById(int id) {
		
		return dao.getProductById(id);
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
