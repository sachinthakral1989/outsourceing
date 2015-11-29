package com.property.util;


import com.property.constants.ApplicationConstants;


public class ServiceUrl {

	private static ServiceUrl serviceUrl = new ServiceUrl();

	public static ServiceUrl getInstance() {
		return serviceUrl;
	}
	
	/*private String readRetailServiceUrlFromResources(String urltemplate) throws Exception {
		String hostName = PropertiesReader.getPropertyValue(
				ApplicationConstants.RETAIL_SERVICE_HOST).trim();
		String port = PropertiesReader.getPropertyValue(
				ApplicationConstants.RETAIL_SERVICE_HOST_PORT).trim();
		String serviceUrl = urltemplate.replace("{HOST_NAME}", hostName);
		serviceUrl = serviceUrl.replace("{PORT}", port);
		return serviceUrl;

	}*/

	public String getRetailServiceUrl() throws Exception {
		String retailUrl = null;
		retailUrl = ApplicationConstants.PROPERTY_TOKEN_URL;
		return retailUrl;

	}

}
