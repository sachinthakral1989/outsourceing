package com.gl.poc.couchbase.dto;

public class ProductMetaData {

	private String id;
	private String title;
	private String image;
	private float price;

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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}


	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "[id = " + id + ",title = " + title + ",price = " + price
				+  ",image = " + image + ']';
	}

}
