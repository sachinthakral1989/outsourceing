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

		System.out.println(response);
		return response;
	}

	public ViewResponse authenticateUser(String userName, String Password)
			throws Exception {
		CouchbaseClient couchbaseClient = CouchbaseConnectionManager
				.getConnection();
		View view = couchbaseClient.getView(
				ViewConstants.RETAIL_DESIGN_DOCUMENT,
				ViewConstants.RETAIL_FILTER_CATEGORIES_VIEW);
		Query query = new Query();
		System.out.println(userName);
		query.setKey(userName.trim());
		query.setIncludeDocs(true);
		ViewResponse response = couchbaseClient.query(view, query);
		System.out.println(response);
		return response;
	}

	public ViewResponse senPropertyCall(String request) throws Exception {
		System.out.println("Request is "+ request);
		CouchbaseClient couchbaseClient = CouchbaseConnectionManager
				.getConnection();
		View view = couchbaseClient.getView(
				ViewConstants.RETAIL_DESIGN_DOCUMENT,
				ViewConstants.RETAIL_FILTER_CATEGORIES_VIEW);
		Query query = new Query();
		query.setIncludeDocs(true);
		ViewResponse response = couchbaseClient.query(view, query);
		System.out.println(response);
		return response;
	}

}