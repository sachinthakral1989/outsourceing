package com.property.entity;



public class ProductVirtual {
	
	private String id;
	private String url;
	private String title;
	private String topic;
	private String type;
	private String price;
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	private String imagePublicId;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public String getImagePublicId() {
		return imagePublicId;
	}
	public void setImagePublicId(String imagePublicId) {
		this.imagePublicId = imagePublicId;
	}
	;
	@Override
	public String toString() {
		return "ProductVirtual [id=" + id + ", url=" + url + ", title=" + title
				+ ", topic=" + topic + ", type=" + type + ", price=" + price
				+ ", imagePublicId=" + imagePublicId + "]";
	}

}
