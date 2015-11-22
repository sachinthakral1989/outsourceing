package com.gl.poc.couchbase.dto;

public class OrderSearchDto {

	private String orderId;
	private String emailId;
	private long startOrderDate;
	private long orderEndDate;
	private PaginationDto pagination;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public long getStartOrderDate() {
		return startOrderDate;
	}

	public void setStartOrderDate(long startOrderDate) {
		this.startOrderDate = startOrderDate;
	}

	public long getOrderEndDate() {
		return orderEndDate;
	}

	public void setOrderEndDate(long orderEndDate) {
		this.orderEndDate = orderEndDate;
	}

	public PaginationDto getPagination() {
		return pagination;
	}

	public void setPagination(PaginationDto pagination) {
		this.pagination = pagination;
	}
	
	@Override
	public String toString(){
		return "[orderId = " + orderId + ",emailid = " + emailId + ",startOrderDate = " + startOrderDate + ",orderEndDate = " + orderEndDate + ']';
		
	}

}
