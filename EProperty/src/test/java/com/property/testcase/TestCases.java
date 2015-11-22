package com.property.testcase;

import org.junit.Test;

import com.property.dao.impl.GetPropertyDataDaoImpl;
import com.property.service.impl.GetPropertyServiceImpl;

public class TestCases {
	
	@Test
	public void getAllCategories() {
		GetPropertyDataDaoImpl getRetailServiceImpl=new GetPropertyDataDaoImpl();
		
			try {
				getRetailServiceImpl.authenticateUser("deepak.giri@outlook.com".trim(), "!snap@123Q");
			} catch (Exception e) {
				e.printStackTrace();
			}
	
	}
}
