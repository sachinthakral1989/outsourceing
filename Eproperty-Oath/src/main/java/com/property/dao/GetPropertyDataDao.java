package com.property.dao;

import com.property.entity.BrokerRequestDto;
import com.property.entity.RegisterationDTO;
import com.property.entity.UserDTO;
import com.property.entity.UserRequestDto;


public interface GetPropertyDataDao {

	public UserDTO loadUserByUserName(String userName) throws Exception;
	
	public void sendUserProperty(UserRequestDto userRequestDto) throws Exception;

	public void sendBrokerProperty(BrokerRequestDto brokerRequestDto) throws Exception;

    public void addUser(RegisterationDTO registerationDTO) throws Exception;
    
    public String verifyToken(String token) throws Exception;
}
