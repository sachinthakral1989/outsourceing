package com.property.util;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.couchbase.client.CouchbaseClient;
import com.property.bo.Bucket;
import com.property.constants.ApplicationConstants;

public class CouchbaseConnectionManager {

	private static CouchbaseClient couchbaseClient = null;
	private static final Object _lock = new Object(); 
	private static final Logger logger = Logger.getLogger(CouchbaseConnectionManager.class);

	
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
			logger.info("Connection closed successfully.");
		}
	}

	private static void initializeConnection() {
		String bucketName = null;
		try {
			List<URI> connectionURIs = getConnectionURIs();
			Bucket bucket = getBucketInfo();
			bucketName = bucket.getBucketName();
			System.setProperty("viewmode", "production");
			couchbaseClient = new CouchbaseClient(connectionURIs, bucketName, bucket.getBucketPassword());
			logger.info("Connection created successfully.");
		} catch (Exception e) {
			String errMsg = "Error occurred in initializing Couchbase connection,with bucket = " + bucketName;
			logger.fatal(errMsg, e);
			throw new ExceptionInInitializerError(errMsg);
		}

	}
	
	
	private static List<URI> getConnectionURIs() throws Exception {
		String connectionUrl = ApplicationConstants.CONNECTION_URL_TEMPLATE;
		
		String hostNamesInfo = PropertiesReader.getPropertyValue(ApplicationConstants.DB_HOST_NAMES);
		System.out.println(hostNamesInfo);
		String port = PropertiesReader.getPropertyValue(ApplicationConstants.DB_HOST_PORT).trim();
		connectionUrl = connectionUrl.replace("{PORT}", port);
		String[] hostNames = hostNamesInfo.split(",");
		List<URI> connectionURIs = new ArrayList<>();
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
