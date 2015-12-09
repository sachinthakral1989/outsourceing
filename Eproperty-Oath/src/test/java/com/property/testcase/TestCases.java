/*package com.property.testcase;

import org.junit.Test;

import com.property.dao.impl.GetPropertyDataDaoImpl;
import com.property.entity.SearchPropertyDTO;
import com.property.service.impl.GetPropertyServiceImpl;

public class TestCases {

	@Test
	public void authenticateUser() {
		GetPropertyDataDaoImpl getRetailServiceImpl = new GetPropertyDataDaoImpl();
        SearchPropertyDTO searchRequestDto = new SearchPropertyDTO();
        searchRequestDto.setPropertySearchFor("Sale");
        searchRequestDto.setPropertySearchType("House");
        searchRequestDto.setLocality("Shipra Suncity");
        searchRequestDto.setMinPrice(10000);
        searchRequestDto.setMaxPrice(50000);
        searchRequestDto.setBhk("2BHK");
		try {
			getRetailServiceImpl.searchProperty(searchRequestDto);			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
}*/
