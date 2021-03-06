package com.property.entity;

import java.io.Serializable;


public class UserPropertyDTO implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;
	private String userName;
	private String type;
	private String propertyForEx;
	private String propertyTypeEx;
	private String bhk;
	private double price;
	private int contractPeriod;
	private double securityAmount;
	private String address;
	private String propertyDescription;
	private String locality;
	private String houseNumber;
	private String imagePublicId;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getLocality() {
		return locality;
	}
	public void setLocality(String locality) {
		this.locality = locality;
	}
	public String getHouseNumber() {
		return houseNumber;
	}
	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPropertyForEx() {
		return propertyForEx;
	}
	public void setPropertyForEx(String propertyForEx) {
		this.propertyForEx = propertyForEx;
	}
	public String getPropertyTypeEx() {
		return propertyTypeEx;
	}
	public void setPropertyTypeEx(String propertyTypeEx) {
		this.propertyTypeEx = propertyTypeEx;
	}
	public String getBhk() {
		return bhk;
	}
	public void setBhk(String bhk) {
		this.bhk = bhk;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getContractPeriod() {
		return contractPeriod;
	}
	public void setContractPeriod(int contractPeriod) {
		this.contractPeriod = contractPeriod;
	}
	public double getSecurityAmount() {
		return securityAmount;
	}
	public void setSecurityAmount(double securityAmount) {
		this.securityAmount = securityAmount;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPropertyDescription() {
		return propertyDescription;
	}
	public void setPropertyDescription(String propertyDescription) {
		this.propertyDescription = propertyDescription;
	}
	public String getImagePublicId() {
		return imagePublicId;
	}
	public void setImagePublicId(String imagePublicId) {
		this.imagePublicId = imagePublicId;
	}

}
