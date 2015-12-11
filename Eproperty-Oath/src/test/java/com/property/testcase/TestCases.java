package com.property.testcase;

import org.junit.Test;

import com.gl.poc.couchbase.dto.AdminDto;
import com.gl.poc.couchbase.dto.BrokerDto;
import com.google.gson.Gson;
import com.property.dao.impl.GetPropertyDataDaoImpl;

public class TestCases {
	GetPropertyDataDaoImpl getPropertyService = new GetPropertyDataDaoImpl();
	@Test
	public void authenticateUser() throws Exception {
		
		AdminDto adminDto = new AdminDto();
		adminDto.setActiveStatus(true);
		adminDto.setCreatedTym(System.currentTimeMillis());
		adminDto.setAge(50);
		adminDto.setFullName("Deepak Giri");
		adminDto.setRole("ROLE_ADMIN");
		adminDto.setType("User");
		adminDto.setUserName("deep@xyz.com");
		Gson gson = new Gson();
		System.out.println("Json : "+gson.toJson(adminDto).toString());
		getPropertyService.createAdmin(adminDto);
	}
	@Test
	
	public void testCreateB() throws Exception{
		BrokerDto brokerDto = new BrokerDto();
		brokerDto.setActiveStatus(true);
		brokerDto.setAge(25);
		brokerDto.setBranchId("Sec_62");
		brokerDto.setBrokerId("Deep21");
		brokerDto.setChannelId("TV_12");
		getPropertyService.createBroker(brokerDto);
	}
}
