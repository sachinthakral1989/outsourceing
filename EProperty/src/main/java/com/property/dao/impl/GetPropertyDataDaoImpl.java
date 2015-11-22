package com.property.dao.impl;

import java.util.Date;

import com.couchbase.client.CouchbaseClient;
import com.couchbase.client.protocol.views.Query;
import com.couchbase.client.protocol.views.View;
import com.couchbase.client.protocol.views.ViewResponse;
import com.property.constants.ViewConstants;
import com.property.dao.GetPropertyDataDao;
import com.property.util.CouchbaseConnectionManager;


public class GetPropertyDataDaoImpl implements GetPropertyDataDao {

	public ViewResponse getAllCategories() throws Exception {
		CouchbaseClient couchbaseClient = CouchbaseConnectionManager
				.getConnection();
		View view = couchbaseClient.getView(
				ViewConstants.RETAIL_DESIGN_DOCUMENT,
				ViewConstants.RETAIL_FILTER_CATEGORIES_VIEW);
		Query query = new Query();
		ViewResponse response = couchbaseClient.query(view, query);
		return response;
	}


}