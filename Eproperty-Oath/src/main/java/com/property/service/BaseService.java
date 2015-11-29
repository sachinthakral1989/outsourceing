package com.property.service;


import org.springframework.transaction.annotation.Transactional;

import com.property.entity.Response;


@Transactional
public interface BaseService {
	
	public  Response login(String username,Response response) throws Exception;
	

}
