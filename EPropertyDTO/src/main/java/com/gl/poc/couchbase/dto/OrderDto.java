package com.gl.poc.couchbase.dto;

import java.io.Serializable;
import java.util.List;
import com.gl.poc.couchbase.dto.CartItemBean;

public class OrderDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1143081556439133801L;
	private List<CartItemBean> products;
	private String OrderStatus;
	private long orderCommitedDate;
	private UserInfoDto userInfo;
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<CartItemBean> getProducts() {
		return products;
	}

	public void setProducts(List<CartItemBean> products) {
		this.products = products;
	}

	public String getOrderStatus() {
		return OrderStatus;
	}

	public long getOrderCommitedDate() {
		return orderCommitedDate;
	}

	public void setOrderCommitedDate(long orderCommitedDate) {
		this.orderCommitedDate = orderCommitedDate;
	}

	public void setOrderStatus(String orderStatus) {
		OrderStatus = orderStatus;
	}

	public UserInfoDto getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfoDto userInfo) {
		this.userInfo = userInfo;
	}

}
