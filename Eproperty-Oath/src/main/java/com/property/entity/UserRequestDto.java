package com.property.entity;

import java.io.Serializable;


public class UserRequestDto implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String id;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	private String saleOrRent;
	private String propertyType;
	private String image;
	private int berooms;
	private String Address;
	private String propertyDesc;
	private double price;
	private String contractPeriod;
	
	public String getSaleOrRent() {
		return saleOrRent;
	}
	public void setSaleOrRent(String saleOrRent) {
		this.saleOrRent = saleOrRent;
	}
	public String getPropertyType() {
		return propertyType;
	}
	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getBerooms() {
		return berooms;
	}
	public void setBerooms(int berooms) {
		this.berooms = berooms;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getPropertyDesc() {
		return propertyDesc;
	}
	public void setPropertyDesc(String propertyDesc) {
		this.propertyDesc = propertyDesc;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getContractPeriod() {
		return contractPeriod;
	}
	public void setContractPeriod(String contractPeriod) {
		this.contractPeriod = contractPeriod;
	}
	

}
