package com.gl.poc.couchbase.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LandingScreenDetailDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<CategoryDto> categoryList = new ArrayList();
	
	public List<CategoryDto> getCategoryList(){
		return categoryList;
	}
	
	private Map<String, Object> popularProductMap = new HashMap<String, Object>();
	
	public Map<String, Object> getPopularProductMap(){
		return popularProductMap;
	}
}
