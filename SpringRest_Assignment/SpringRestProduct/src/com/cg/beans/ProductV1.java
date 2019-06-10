package com.cg.beans;

public class ProductV1 {
	private int PId;
	private String PName;
	
	
	public ProductV1() {
		
	}
	public ProductV1(int pId, String pName) {
		super();
		PId = pId;
		PName = pName;
	}
	public int getPId() {
		return PId;
	}
	public void setPId(int pId) {
		PId = pId;
	}
	public String getPName() {
		return PName;
	}
	public void setPName(String pName) {
		PName = pName;
	}
	@Override
	public String toString() {
		return "ProductV1 [PId=" + PId + ", PName=" + PName + "]";
	}
	
}
