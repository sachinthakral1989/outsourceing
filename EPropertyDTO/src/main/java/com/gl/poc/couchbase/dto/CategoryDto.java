package com.gl.poc.couchbase.dto;

import java.io.Serializable;

public class CategoryDto implements Serializable {

	private static final long serialVersionUID = 264068082348994610L;
	private String id;
	private String title;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "[id = " + id + " , title = " + title + ']';

	}

}
