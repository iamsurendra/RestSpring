package com.cg.learning.webservice;

import javax.jws.WebService;

/**
 * The @WebService property endpointInterface links the SIB (this class) to the
 * SEI (com.cg.learning.webservice). Note that the method implementations are
 * not annotated as @WebMethods.
 */
@WebService(endpointInterface = "com.cg.learning.webservice.ProductServer")
public class ProductService {
	public String searchById(String name) {
		if(name.equalsIgnoreCase("Car")){
			System.out.println("price is 1000000");
		}else{
			System.out.println("product is not found");
		}
		return name;

	}

}
