package com.property.constants;

public class ApplicationConstants {
	
	

	public static final String APPLICATION_PROPERTIES_FILE_NAME = "appConfig/application.properties";
	public static final String CONNECTION_URL_TEMPLATE = "http://{HOST_NAME}:{PORT}/pools";
	public static final String DB_HOST_NAMES = "service.hosts";
	public static final String DB_HOST_PORT = "service.host.port";
	public static final String DB_BUCKET_NAME = "service.bucket";
	public static final String DB_BUCKET_PASSWORD="service.bucket.password";
	public static final String DATE_FORMAT = "yyyy-MM-dd";
	public static final String TIMESTAMP_FORMAT = "yyyy-MM-dd HH:mm:ss";
	
	public static final String CORE_THREAD_POOL_SIZE  = "core.thread.pool.size";
	public static final String MAX_THREAD_POOL_SIZE = "max.thread.pool.size";
	public static final String THREAD_KEEP_ALIVE_MINUTE = "thread.keep.alive.minute";
	public static final String PROPERTY_TOKEN_URL="http://localhost:8080/oauth2-auth-server/oauth/token?grant_type=client_credentials&client_id=test&client_secret=test";
}