package com.property.dao;

import java.util.List;


import com.property.entity.AdminDto;
import com.property.entity.BrokerDto;
import com.property.entity.BrokerRequestDto;
import com.property.entity.RegisterationDTO;
import com.property.entity.UserDTO;
import com.property.entity.UserPropertyDTO;


public interface GetPropertyDataDao {

	public UserDTO loadUserByUserName(String userName) throws Exception;
	
	public void sendUserProperty(UserPropertyDTO userRequestDto) throws Exception;

	public void sendBrokerProperty(BrokerRequestDto brokerRequestDto) throws Exception;

    public boolean addUser(RegisterationDTO registerationDTO) throws Exception;
    
    public String verifyToken(String token) throws Exception;
    
    public List<BrokerDto> viewBrokers() throws Exception;

	public BrokerDto viewBroker(String brokerId) throws Exception;

	public boolean createAdmin(AdminDto adminDto) throws Exception;

	public boolean createBroker(BrokerDto brokerDto) throws Exception;
}
