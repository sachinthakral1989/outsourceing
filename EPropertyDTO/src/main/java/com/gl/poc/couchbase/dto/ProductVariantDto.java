package com.gl.poc.couchbase.dto;

import java.util.Map;

public class ProductVariantDto {

	private String id;
	private String title;
	private String category;
	private float price;
	private int quantity;
	private String image;
	private Map<String, String> featureList;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Map<String, String> getFeatureList() {
		return featureList;
	}

	public void setFeatureList(Map<String, String> featureList) {
		this.featureList = featureList;
	}

	@Override
	public String toString() {
		return "[id = " + id + ",title = " + title + ",category = " + category
				+ ",price = " + price + ",quantity = " + quantity + ",image = "
				+ image + ",featureList = " + featureList + ']';
	}

}
