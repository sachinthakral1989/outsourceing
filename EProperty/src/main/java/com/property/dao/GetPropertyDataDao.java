package com.property.dao;

import com.couchbase.client.protocol.views.ViewResponse;


public interface GetPropertyDataDao {

	public ViewResponse getAllCategories() throws Exception;
	
}
