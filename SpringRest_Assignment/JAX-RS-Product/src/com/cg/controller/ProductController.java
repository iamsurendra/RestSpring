package com.cg.controller;

import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.cg.beans.Product;
import com.cg.service.IProductService;
import com.cg.service.ProductServiceImpl;



@Path("products")
public class ProductController {
	IProductService productService;

	public ProductController() {
		productService = new ProductServiceImpl();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Product> getProducts() {
		List<Product> listOfProducts = productService.getAllProducts();
		return listOfProducts;
	}


	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Product getProductById(@PathParam("id") int id) {
		return productService.getProduct(id);
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Product addProduct(@FormParam("txtId") int txtId,
			@FormParam("txtName") String txtName,
			@FormParam("txtPrice") long txtPrice) {
		Product product = new Product();
		product.setProductId(txtId);
		product.setProductName(txtName);
		product.setPrice(txtPrice); 
		System.out.println(product);
		return productService.addProduct(product);
	}


	@POST
	@Path("/delete")
	@Produces(MediaType.APPLICATION_JSON)
	public Product deleteProduct(@FormParam("txtId") int id) {
		Product product = productService.deleteProduct(id);
		// if valid country Id is existing then country gets deleted; otherwise
		// returning a JSON object with default (null) values
		if (product != null) {
			return product;
		} else {
			return new Product();
		}

	}
	@POST
	@Path("/update")
	@Produces(MediaType.APPLICATION_JSON)
	public Product updateProduct(@FormParam("txtId") int txtId,
			@FormParam("txtName") String txtName,
			@FormParam("txtPrice") long txtPrice) {

		// if valid country Id is existing then country gets updated; otherwise
		// returning a JSON object with default (null) values

		Product product = new Product();
		product.setProductId(txtId);
		product.setProductName(txtName);
		product.setPrice(txtPrice); 
		System.out.println(product);
		return productService.updateProduct(product);


	}

}
