package com.gl.poc.couchbase.dto;

import java.io.Serializable;

public class UserInfoDto implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2444089818422149469L;
	
	private String firstName;
	private String lastName;
	private String email;
	private String telephone;
	private String userAddress;
	private String shippingAddress;
	private String shippingCity;
	private String shippingPinCode;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	public String getShippingAddress() {
		return shippingAddress;
	}
	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	public String getShippingCity() {
		return shippingCity;
	}
	public void setShippingCity(String shippingCity) {
		this.shippingCity = shippingCity;
	}
	public String getShippingPinCode() {
		return shippingPinCode;
	}
	public void setShippingPinCode(String shippingPinCode) {
		this.shippingPinCode = shippingPinCode;
	}
	
}
