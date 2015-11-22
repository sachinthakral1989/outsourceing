package com.gl.poc.couchbase.response;

import java.io.Serializable;
import java.util.List;

import com.gl.poc.couchbase.dto.OrderMetaDto;
import com.gl.poc.couchbase.dto.PaginationDto;

public class GetOrderInfoByLimitResponse implements Serializable {

	private static final long serialVersionUID = 188389212718857286L;
	List<OrderMetaDto> orderInfoList;
	private PaginationDto pagination;

	public List<OrderMetaDto> getOrderInfoList() {
		return orderInfoList;
	}

	public void setOrderInfoList(List<OrderMetaDto> orderInfoList) {
		this.orderInfoList = orderInfoList;
	}

	public PaginationDto getPagination() {
		return pagination;
	}

	public void setPagination(PaginationDto pagination) {
		this.pagination = pagination;
	}

}
