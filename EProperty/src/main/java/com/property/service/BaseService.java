package com.property.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import com.gl.poc.couchbase.dto.CategoryDto;


@Transactional
public interface BaseService {
	
	public  List<CategoryDto> getAllCategories() throws Exception;
	

}
