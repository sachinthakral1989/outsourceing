package com.gl.poc.couchbase.dto;

import java.io.Serializable;

public class PaginationDto implements Serializable {

	private static final long serialVersionUID = 188389212718857286L;

	private int offset;
	private int limit;
	private int totalCount;
	private boolean hasNext;

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public boolean hasNext() {
		return hasNext;
	}

	public void setHasNext(boolean hasNext) {
		this.hasNext = hasNext;
	}

	@Override
	public String toString() {
		return "[offset = " + offset + ",limit = " + limit + ",hasNext = "
				+ hasNext + ']';
	}

}
