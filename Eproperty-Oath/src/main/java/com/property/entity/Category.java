package com.property.entity;

import java.util.List;

import com.property.constants.EntityTypeConstants;

public final class Category {

	private String id;
	private String title;
	public final String type = EntityTypeConstants.CATEGORY_TYPE;
	private List<String> types;

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

	public List<String> getTypes() {
		return types;
	}

	public void setTypes(List<String> types) {
		this.types = types;
	}

	@Override
	public String toString() {
		return "[id = " + id + ",title = " + title + ",type = " + type
				+ ",types = " + types + ']';
	}

}
