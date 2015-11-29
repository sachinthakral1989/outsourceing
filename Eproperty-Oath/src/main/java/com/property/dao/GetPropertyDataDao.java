package com.property.dao;

import com.property.entity.Response;
import com.property.entity.UserDTO;


public interface GetPropertyDataDao {

	public UserDTO login(String userName) throws Exception;
	
}
