package com.property.dao;

import com.couchbase.client.protocol.views.ViewResponse;
import com.property.entity.UserDTO;


public interface GetPropertyDataDao {

	public UserDTO authenticateUser(String userName) throws Exception;
	
}
