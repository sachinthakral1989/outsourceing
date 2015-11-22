package com.property.ws.impl;




import com.property.service.BaseService;
import com.property.service.impl.GetPropertyServiceImpl;
import com.property.ws.PropertyServiceApi;
import com.property.ws.Request;


public class PropertyServiceImpl implements PropertyServiceApi {

	BaseService getPropertyService = GetPropertyServiceImpl.getInstance();

	
	public void authenticateUser(String userName, String Password) throws Exception {
		getPropertyService.getAllCategories();
	}

	
	public void sendPropertyCall( Request request) {
		System.out.println("Request Info "+request.getNetworkId()+" "+request.getBranch()+" "+request.getNetworkId());
	
	}

	

	
}