package com.gl.poc.couchbase.dto;

public class CartItemBean {
	private String documetId;
	private int Quantity;
	private double unitCost;
	private double TotalCost;
	private double dblTotalCost;
	private String image;
	private String productTitle;

	public int getQuantity() {
		return Quantity;
	}

	public void setQuantity(int quantity) {
		Quantity = quantity;
	}

	public double getUnitCost() {
		return unitCost;
	}

	public void setUnitCost(double dblUnitCost) {
		this.unitCost = dblUnitCost;
	}

	public double getTotalCost() {
		return TotalCost;
	}

	public void setTotalCost(double dblTotalCost2) {
		TotalCost = dblTotalCost2;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDocumetId() {
		return documetId;
	}

	public void setDocumetId(String documetId) {
		this.documetId = documetId;
	}

	public double getDblTotalCost() {
		return dblTotalCost;
	}

	public void setDblTotalCost(double dblTotalCost) {
		this.dblTotalCost = dblTotalCost;
	}

	public String getProductTitle() {
		return productTitle;
	}

	public void setProductTitle(String productTitle) {
		this.productTitle = productTitle;
	}

}