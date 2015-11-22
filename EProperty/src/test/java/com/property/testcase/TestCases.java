package com.property.testcase;

import org.junit.Test;

import com.property.service.impl.GetPropertyServiceImpl;

public class TestCases {
	
	@Test
	public void getAllCategories() {
		GetPropertyServiceImpl getRetailServiceImpl=new GetPropertyServiceImpl();
		try {
			getRetailServiceImpl.getAllCategories();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
