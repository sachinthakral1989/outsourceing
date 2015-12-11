/**
 * 
 */
package com.epropertyui.model;

import java.io.Serializable;

/**
 * @author DevD
 *
 */
public class BrokerDto implements Serializable{

/**
	 * 
	 */
	
/**
	 * 
	 */
	private static final long serialVersionUID = -6039604362073327802L;
/**
	 * 
	 */
	
private String firstName;
private String 	lastName;
private String 	type;
private String 	networkId;
private String 	brokerId;
private String 	branchId;
private String userName;
private long createdTym;
private String role;
private int age ;
private String enKey;
private boolean activeStatus;
private String channelId;
private String channelName;
private String pwd;
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
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public String getNetworkId() {
	return networkId;
}
public void setNetworkId(String networkId) {
	this.networkId = networkId;
}
public String getBrokerId() {
	return brokerId;
}
public void setBrokerId(String brokerId) {
	this.brokerId = brokerId;
}
public String getBranchId() {
	return branchId;
}
public void setBranchId(String branchId) {
	this.branchId = branchId;
}
public long getCreatedTym() {
	return createdTym;
}
public void setCreatedTym(long createdTym) {
	this.createdTym = createdTym;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public boolean isActiveStatus() {
	return activeStatus;
}
public void setActiveStatus(boolean activeStatus) {
	this.activeStatus = activeStatus;
}
public String getChannelId() {
	return channelId;
}
public void setChannelId(String channelId) {
	this.channelId = channelId;
}

public String getPwd() {
	return pwd;
}
public void setPwd(String pwd) {
	this.pwd = pwd;
}
public String getChannelName() {
	return channelName;
}
public void setChannelName(String channelName) {
	this.channelName = channelName;
}

public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
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




}
