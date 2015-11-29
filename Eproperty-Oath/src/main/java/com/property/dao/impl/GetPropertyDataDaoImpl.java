package com.property.dao.impl;

import com.couchbase.client.CouchbaseClient;
import com.couchbase.client.protocol.views.ComplexKey;
import com.couchbase.client.protocol.views.Query;
import com.couchbase.client.protocol.views.Stale;
import com.couchbase.client.protocol.views.View;
import com.couchbase.client.protocol.views.ViewResponse;
import com.couchbase.client.protocol.views.ViewRow;
import com.property.constants.ViewConstants;
import com.property.dao.GetPropertyDataDao;
import com.property.entity.Response;
import com.property.entity.UserDTO;
import com.property.util.CouchbaseConnectionManager;

public class GetPropertyDataDaoImpl implements GetPropertyDataDao {

	public UserDTO login(String userName)
			throws Exception {
		String isActive = "Y";
		String passwordDb = "";
		String role = "";
		UserDTO userDTO = new UserDTO();
		CouchbaseClient couchbaseClient = CouchbaseConnectionManager.getConnection();
		View view = couchbaseClient.getView(
				ViewConstants.PROPERTY_DESIGN_DOCUMENT,
				ViewConstants.PROPERTY_FILTER_CATEGORIES_VIEW);
		Query query = new Query();
		query.setIncludeDocs(false);
		query.setStale(Stale.FALSE);
		query.setKey(ComplexKey.of(userName.trim(), isActive.trim()));
		ViewResponse response = couchbaseClient.query(view, query);
		System.out.println(response);
		for (ViewRow row : response) {

			String valueTemp[] = row.getValue().replaceAll("\\[|\\]|\"", "").split(",");
			passwordDb = valueTemp[0];
			role = valueTemp[1];
			
				userDTO.setUsername(userName);
				userDTO.setPassword(passwordDb);
				userDTO.setRole(role);
				System.out.println(userDTO.getUsername());
				System.out.println(userDTO.getRole());
				System.out.println("passwordDb "+passwordDb);
			} 
			return userDTO;
		}
	


	private boolean checkAuthentication(String password, String passwordDb) {
		if (password.equals(passwordDb)) {
			return true;
		}
		return false;

	}

	public ViewResponse senPropertyCall(String request) throws Exception {
		System.out.println("Request is " + request);
		CouchbaseClient couchbaseClient = CouchbaseConnectionManager
				.getConnection();
		View view = couchbaseClient.getView(
				ViewConstants.PROPERTY_DESIGN_DOCUMENT,
				ViewConstants.PROPERTY_FILTER_CATEGORIES_VIEW);
		Query query = new Query();
		query.setIncludeDocs(true);
		ViewResponse response = couchbaseClient.query(view, query);
		System.out.println(response);
		return response;
	}

}