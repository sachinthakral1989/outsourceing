package com.gl.poc.couchbase.response;

import java.util.List;

import com.gl.poc.couchbase.dto.PaginationDto;
import com.gl.poc.couchbase.dto.ProductVariantDto;

public class GetProductVariantsResponse {

	private List<ProductVariantDto> products;
	private PaginationDto pagination;

	public List<ProductVariantDto> getProducts() {
		return products;
	}

	public void setProducts(List<ProductVariantDto> products) {
		this.products = products;
	}

	public PaginationDto getPagination() {
		return pagination;
	}

	public void setPagination(PaginationDto pagination) {
		this.pagination = pagination;
	}

}
