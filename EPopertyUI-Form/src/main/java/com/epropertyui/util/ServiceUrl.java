package com.epropertyui.util;

import java.util.HashMap;
import java.util.Map;

import com.epropertyui.constants.ApplicationConstants;

public class ServiceUrl {

	private static ServiceUrl serviceUrl = new ServiceUrl();
	private static Object _monitor = new Object();

	public static ServiceUrl getInstance() {
		return serviceUrl;
	}


	public static  String getPropertyServiceUrl() throws Exception {
		System.out.println("Inside serviceUrl");
		String host = PropertiesReader.getPropertyValue(ApplicationConstants.PROPERTY_SERVICE_HOST_NAME);
		String port = PropertiesReader.getPropertyValue(ApplicationConstants.PROPERTY_SERVICE_HOST_PORT);
		String propertyUrl = ApplicationConstants.PROPERTY_URL_TEMPLATE.replace("{HOST_NAME}", host).replace("{PORT}", port);

		return propertyUrl;

	}

}
