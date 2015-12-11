package com.property.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.gl.poc.couchbase.dto.AdminDto;
import com.gl.poc.couchbase.dto.BrokerDto;
import com.property.entity.Response;
import com.property.entity.UserPropertyDTO;

@Transactional
public interface BaseService {
	
	public  Response login(String username,Response response) throws Exception;
	
	public boolean createAdmin(AdminDto adminDto) throws Exception;
	
	public boolean createBroker(BrokerDto brokerDto) throws Exception;

	public List<BrokerDto> viewBrokers() throws Exception;

	public BrokerDto viewBroker(String brokerId) throws Exception;
	
	public boolean updateBroker(BrokerDto brokerDto) throws Exception;
	
	public boolean updateUserProperty(UserPropertyDTO propertyDTO) throws Exception;
	
	public List<UserPropertyDTO> viewUserProperties() throws Exception;
}
