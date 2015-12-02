package com.property.entity;

import java.io.Serializable;

public class RegisterationDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String type;
	private String fullName;
	private String active;
	private String enKey;
	private String email;
	private String vTokenString;
	private String createdDate;
	private String createdUser;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public String getEnKey() {
		return enKey;
	}

	public void setEnKey(String enKey) {
		this.enKey = enKey;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedUser() {
		return createdUser;
	}

	public void setCreatedUser(String createdUser) {
		this.createdUser = createdUser;
	}

	public String getvTokenString() {
		return vTokenString;
	}

	public void setvTokenString(String vTokenString) {
		this.vTokenString = vTokenString;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
