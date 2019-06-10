package com.cg.controller;

import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.cg.beans.Product;
import com.cg.beans.ProductV1;
import com.cg.service.IProductService;

@CrossOrigin(origins = "http://localhost:8086")
@RestController
public class ProductController {
	@Autowired
	IProductService productService;



	@GetMapping("/allproducts")
	public List<Product> getProducts() {
		List<Product> listOfProducts = productService.getAllProducts();
		return listOfProducts;
	}
	@GetMapping("V1/allproducts")
	public List<ProductV1> getProductsV1() {
		List<ProductV1> listOfProducts = productService.getAllProductsV1();
		return listOfProducts;
	}
	@PostMapping("/addproduct")
	public List<Product> createProduct(@RequestParam int txtId,
			@RequestParam String txtName,
			@RequestParam long txtPrice,ModelAndView model) {
		Product product = new Product();
		product.setProductId(txtId);
		product.setProductName(txtName);
		product.setPrice(txtPrice); 
		System.out.println(product);
		productService.addProduct(product);
		return productService.getAllProducts();
	}
	
	@ResponseStatus(value=HttpStatus.NOT_FOUND,reason="product with id not found")
	@ExceptionHandler(Exception.class)
	public void handleException(){

	}

	@GetMapping("/products/search/{txtId}")
	public Product getProductById(@PathParam("id") int txtId) {
		return productService.getProductById(txtId);
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
