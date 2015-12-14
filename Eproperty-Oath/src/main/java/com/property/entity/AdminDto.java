/**
 * 
 */
package com.property.entity;

import java.io.Serializable;

/**
 * @author DevD
 *
 */
public class AdminDto implements Serializable {

	/**
	 * 
	 */

	private static final long serialVersionUID = -402208782495210053L;
	private String fullName;
	private String userName;
	private String type;
	private int age;
	private long createdTym;
	private String enKey;
	private boolean activeStatus;
	private String role;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public long getCreatedTym() {
		return createdTym;
	}

	public void setCreatedTym(long createdTym) {
		this.createdTym = createdTym;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(boolean activeStatus) {
		this.activeStatus = activeStatus;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEnKey() {
		return enKey;
	}

	public void setEnKey(String enKey) {
		this.enKey = enKey;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
