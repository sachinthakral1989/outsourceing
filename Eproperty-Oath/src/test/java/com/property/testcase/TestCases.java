/*package com.property.testcase;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;


import com.google.gson.Gson;
import com.property.dao.impl.GetPropertyDataDaoImpl;
import com.property.entity.AdminDto;
import com.property.entity.BrokerDto;
import com.property.entity.SearchProperty;
import com.property.entity.SearchPropertyDTO;
import com.property.entity.UserProperty;
import com.property.entity.UserPropertyDTO;
import com.property.service.BaseService;
import com.property.service.impl.GetPropertyServiceImpl;
import com.property.util.Status;

public class TestCases {
	GetPropertyDataDaoImpl getPropertyDataDao = new GetPropertyDataDaoImpl();
	GetPropertyServiceImpl getPropertyService = new GetPropertyServiceImpl();
	@Ignore
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
	@Ignore
	@Test
	public void testCreateB() throws Exception{
		BrokerDto brokerDto = new BrokerDto();
		brokerDto.setActiveStatus(true);
		brokerDto.setAge(25);
		brokerDto.setBranchId("Sec_62");
		brokerDto.setBrokerId("Deep21");
		brokerDto.setChannelId("TV_12");
		getPropertyService.viewBrokers();
		getPropertyService.createBroker(brokerDto);
	}

	@Test
	@Ignore
	public void testFilterPropertyByStatus() throws Exception {
		getPropertyDataDao.getUserPropertyDocByStaus(Status.APPROVED);

	}
	@Test
	@Ignore
	public void viewUserPropertyByDocId() throws Exception {
		UserPropertyDTO userProperty= getPropertyDataDao.viewUserPropertyByDocId("Noida_Sale_House_3BHK_20247");
		System.out.println(userProperty.getHouseNumber());
		System.out.println(userProperty.getId());
	}
	@Test
	public void searchProperty() throws Exception {
		SearchProperty searchProperty = new SearchProperty();
		searchProperty.setLocality("Ashoka Road");
		searchProperty.setPropertySearchFor("Rent");
		searchProperty.setPropertySearchType("House");
		searchProperty.setBhk("2BHK");
		searchProperty.setMinPrice(10000);
		searchProperty.setMaxPrice(20000);
		List<UserProperty> userPropertyList = getPropertyService.searchProperty(searchProperty);
		for(UserProperty userProperty : userPropertyList){
			System.out.println(userProperty.getHouseNumber());
			System.out.println(userProperty.getId());
		}
	}
	@Ignore
	@Test
	public void propertyByUser() throws Exception {
		List<UserPropertyDTO> userPropertyDTOs = getPropertyService.propertyByUser("sachinthakral1989@gmail.com");
		for(UserPropertyDTO userPropertyDTO : userPropertyDTOs){
			System.out.println(userPropertyDTO.getId());
		}
		
	}
}
*/