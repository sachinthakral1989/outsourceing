package com.property.entity;

public class SearchProperty {

	private String propertySearchFor;
	private String propertySearchType;
	private String locality;
	private String bhk;
	private double minPrice;
	private double maxPrice;
	
	public String getPropertySearchFor() {
		return propertySearchFor;
	}
	public void setPropertySearchFor(String propertySearchFor) {
		this.propertySearchFor = propertySearchFor;
	}
	public String getPropertySearchType() {
		return propertySearchType;
	}
	public void setPropertySearchType(String propertySearchType) {
		this.propertySearchType = propertySearchType;
	}
	public String getLocality() {
		return locality;
	}
	public void setLocality(String locality) {
		this.locality = locality;
	}
	public String getBhk() {
		return bhk;
	}
	public void setBhk(String bhk) {
		this.bhk = bhk;
	}
	public double getMinPrice() {
		return minPrice;
	}
	public void setMinPrice(double minPrice) {
		this.minPrice = minPrice;
	}
	public double getMaxPrice() {
		return maxPrice;
	}
	public void setMaxPrice(double maxPrice) {
		this.maxPrice = maxPrice;
	}
	
}
