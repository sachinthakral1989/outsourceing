package com.property.dao;

import java.util.List;

import com.gl.poc.couchbase.dto.AdminDto;
import com.gl.poc.couchbase.dto.BrokerDto;
import com.property.entity.BrokerRequestDto;
import com.property.entity.RegisterationDTO;
import com.property.entity.SearchPropertyDTO;
import com.property.entity.UserDTO;
import com.property.entity.UserPropertyDTO;

public interface GetPropertyDataDao {

	public UserDTO loadUserByUserName(String userName) throws Exception;

	public void sendUserProperty(UserPropertyDTO userRequestDto)
			throws Exception;

	public void sendBrokerProperty(BrokerRequestDto brokerRequestDto)
			throws Exception;

	public boolean createAdmin(AdminDto adminDto) throws Exception;

	public boolean createBroker(BrokerDto brokerDto) throws Exception;

	public boolean addUser(RegisterationDTO registerationDTO) throws Exception;

	public String verifyToken(String token) throws Exception;

	public List<BrokerDto> viewBrokers() throws Exception;

	public BrokerDto viewBroker(String brokerId) throws Exception;

	public boolean updateBroker(BrokerDto brokerDto) throws Exception;

	public List<UserPropertyDTO> searchProperty(
			SearchPropertyDTO searchRequestDto) throws Exception;

	public List<UserPropertyDTO> viewUserProperties() throws Exception;

	public boolean updateUser(UserPropertyDTO propertyDTO) throws Exception;
}
