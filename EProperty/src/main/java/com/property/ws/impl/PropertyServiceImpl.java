package com.property.ws.impl;

import java.util.List;

import com.gl.poc.couchbase.dto.CategoryDto;
import com.gl.poc.couchbase.dto.LandingScreenDetailDTO;
import com.property.service.BaseService;
import com.property.service.impl.GetPropertyServiceImpl;
import com.property.ws.PropertyServiceApi;


public class PropertyServiceImpl implements PropertyServiceApi {

	BaseService getPropertyService = GetPropertyServiceImpl.getInstance();

	public LandingScreenDetailDTO getAllCategories() throws Exception {
		LandingScreenDetailDTO landingScreenDetailDTO = new LandingScreenDetailDTO();
		List<CategoryDto> categoriesDto = getPropertyService.getAllCategories();
		landingScreenDetailDTO.getCategoryList().addAll(categoriesDto);
		return landingScreenDetailDTO;
	}

	
}