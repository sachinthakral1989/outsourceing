package com.epropertyui.util;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import com.couchbase.client.CouchbaseClient;
import com.epropertyui.bo.Bucket;
import com.epropertyui.constants.ApplicationConstants;

public class CouchbaseConnectionManager {

	private static CouchbaseClient couchbaseClient = null;
	private static final Object _lock = new Object(); 

	
	public static CouchbaseClient getConnection() {
		synchronized (_lock) {
			if (couchbaseClient == null) {
				initializeConnection();
			}
		}
		return couchbaseClient;
	}

	public static void shutDown() {
		if (couchbaseClient != null) {
			couchbaseClient.shutdown();
			couchbaseClient = null;
			System.out.println("Connection closed successfully.");
		}
	}

	private static void initializeConnection() {
		String bucketName = null;
		try {
			List<URI> connectionURIs = getConnectionURIs();
			Bucket bucket = getBucketInfo();
			bucketName = bucket.getBucketName();
			System.setProperty("viewmode", "production");
			System.out.println(connectionURIs+bucketName);
			couchbaseClient = new CouchbaseClient(connectionURIs, bucketName, "");
		} catch (Exception e) {
			String errMsg = "Error occurred in initializing Couchbase connection,with bucket = " + bucketName;
			throw new ExceptionInInitializerError(errMsg);
		}

	}
	
	
	private static List<URI> getConnectionURIs() throws Exception {
		System.out.println("Inside get");
		String connectionUrl = ApplicationConstants.CONNECTION_URL_TEMPLATE;
		
		String hostNamesInfo = PropertiesReader.getPropertyValue(ApplicationConstants.DB_HOST_NAMES);
		System.out.println(hostNamesInfo);
		String port = PropertiesReader.getPropertyValue(ApplicationConstants.DB_HOST_PORT).trim();
		connectionUrl = connectionUrl.replace("{PORT}", port);
		String[] hostNames = hostNamesInfo.split(",");
		List<URI> connectionURIs = new ArrayList<URI>();
		for (String hostName : hostNames) {
			String hostUrl = connectionUrl.replace("{HOST_NAME}",hostName.trim());
			URI hostURI = new URI(hostUrl);
			System.out.println("Host Url is "+hostUrl);
			connectionURIs.add(hostURI);
		}
		return connectionURIs;
	}

	private static Bucket getBucketInfo() throws Exception {
		String bucketName = PropertiesReader.getPropertyValue(ApplicationConstants.DB_BUCKET_NAME);
		String bucketPassword = PropertiesReader.getPropertyValue(ApplicationConstants.DB_BUCKET_PASSWORD);
		Bucket bucketInfo = new Bucket();
		bucketInfo.setBucketName(bucketName);
		bucketInfo.setBucketPassword(bucketPassword);
		return bucketInfo;
	}
	
	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		shutDown();
	}
}
