package com.gl.poc.couchbase.dto;

public class OrderMetaDto {

	private String orderId;
	private String orderDate;
	private String emailId;
	

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	@Override
	public String toString(){
		return "[orderId = " + orderId + ",orderDate = " + orderDate + ",emailId = " + emailId + ']';
	}

}
