package com.gl.poc.couchbase.dto;

import java.util.List;
import java.util.Map;

public class ProductVirtualDto {

	private String id;
	private String title;
	private String category;
	private String type;
	private String image;
	private float price;
	private Map<String, List<String>> featureList;

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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	
	public Map<String, List<String>> getFeatureList() {
		return featureList;
	}

	public void setFeatureList(Map<String, List<String>> featureList) {
		this.featureList = featureList;
	}

	
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "[id = " + id + ",title = " + title + ",category = " + category
				+ ",type = " + type + ",price = " + price + ",image = " + image +",featureList = " + featureList + ']';
	}

}
