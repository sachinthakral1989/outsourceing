package com.property.entity;

import java.io.Serializable;
import com.gl.poc.couchbase.dto.PaginationDto;
//import com.gl.poc.couchbase.dto.ProductMetaData;
import java.util.List;

public class GetProductByLimitResponse implements Serializable {

	private static final long serialVersionUID = 188389212718857286L;
	private List<ProductMetaData> products;
	private PaginationDto pagination;

	public PaginationDto getPagination() {
		return pagination;
	}

	public void setPagination(PaginationDto pagination) {
		this.pagination = pagination;
	}

	public List<ProductMetaData> getProducts() {
		return products;
	}

	public void setProducts(List<ProductMetaData> products) {
		this.products = products;
	}

}