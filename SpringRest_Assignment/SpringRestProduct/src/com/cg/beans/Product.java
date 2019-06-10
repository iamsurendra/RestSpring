package com.cg.beans;

/**
 * 
 * @author yvalecha
 * Country bean with getters and setters and default and parametarized constructor
 */
public class Product {
	private int ProductId;
	private String ProductName;
	private long price;

	public Product() {

	}

	public Product(int productId, String productName, long price) {
		super();
		ProductId = productId;
		ProductName = productName;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [ProductId=" + ProductId + ", ProductName="
				+ ProductName + ", price=" + price + "]";
	}

	public int getProductId() {
		return ProductId;
	}

	public void setProductId(int productId) {
		ProductId = productId;
	}

	public String getProductName() {
		return ProductName;
	}

	public void setProductName(String productName) {
		ProductName = productName;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	

}
