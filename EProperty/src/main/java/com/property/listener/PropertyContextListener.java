package com.property.listener;

import javax.servlet.ServletContextListener;
import javax.servlet.ServletContextEvent;

import com.property.util.CouchbaseConnectionManager;

public class PropertyContextListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("ServletContextListener destroyed");
	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("ServletContextListener started");	
		CouchbaseConnectionManager.shutDown();
	}
}
