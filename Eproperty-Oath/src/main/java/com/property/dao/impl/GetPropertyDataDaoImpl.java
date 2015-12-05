package com.property.dao.impl;

import java.util.UUID;

import org.apache.log4j.Logger;

import com.couchbase.client.CouchbaseClient;
import com.couchbase.client.protocol.views.ComplexKey;
import com.couchbase.client.protocol.views.DesignDocument;
import com.couchbase.client.protocol.views.Query;
import com.couchbase.client.protocol.views.Stale;
import com.couchbase.client.protocol.views.View;
import com.couchbase.client.protocol.views.ViewResponse;
import com.couchbase.client.protocol.views.ViewRow;
import com.property.constants.EntityTypeConstants;
import com.property.constants.ViewConstants;
import com.property.dao.GetPropertyDataDao;
import com.property.entity.BrokerRequestDto;
import com.property.entity.RegisterationDTO;
import com.property.entity.Response;
import com.property.entity.UserDTO;
import com.property.entity.UserPropertyDTO;
import com.property.service.impl.GetPropertyServiceImpl;
import com.property.util.CouchbaseConnectionManager;
import com.property.util.JsonUtil;

public class GetPropertyDataDaoImpl implements GetPropertyDataDao {
	
	private static final Logger logger = Logger.getLogger(GetPropertyDataDaoImpl.class);

	public UserDTO loadUserByUserName(String userName) throws Exception {
		
		logger.info("GetPropertyDataDaoImpl.loadUserByUserName "+userName);
		
		String passwordDb = "";
		String role = "";
		UserDTO userDTO = new UserDTO();
		CouchbaseClient couchbaseClient = CouchbaseConnectionManager
				.getConnection();
		View view = couchbaseClient.getView(
				ViewConstants.PROPERTY_DESIGN_DOCUMENT,
				ViewConstants.PROPERTY_FILTER_CATEGORIES_VIEW);
		Query query = new Query();
		query.setIncludeDocs(false);
		query.setStale(Stale.FALSE);
		query.setKey(ComplexKey.of(userName.trim(), EntityTypeConstants.IS_ACTIVE_Y.trim()));
		ViewResponse response = couchbaseClient.query(view, query);
		logger.info("response for loadUserByUser "+ response);
		for (ViewRow row : response) {

			String valueTemp[] = row.getValue().replaceAll("\\[|\\]|\"", "")
					.split(",");
			passwordDb = valueTemp[0];
			role = valueTemp[1];

			userDTO.setUsername(userName);
			userDTO.setPassword(passwordDb);
			userDTO.setRole(role);
			
		}
		return userDTO;
	}

	public void sendUserProperty(UserPropertyDTO userRequestDto) throws Exception {
		logger.info("Entered into sendUserProperty() "+userRequestDto.getPropertyForEx()+userRequestDto.getBhk());
		userRequestDto.setId(UUID.randomUUID().toString());
		String userRequestDoc = JsonUtil.marshal(userRequestDto);
		CouchbaseClient couchbaseClient = CouchbaseConnectionManager
				.getConnection();
		couchbaseClient.add(userRequestDto.getId(), userRequestDoc);
	}


	public void sendBrokerProperty(BrokerRequestDto brokerRequestDto) throws Exception {
		
		//brokerRequestDto.setId(UUID.randomUUID().toString());
		String brokerRequestDoc = JsonUtil.marshal(brokerRequestDto);
		CouchbaseClient couchbaseClient = CouchbaseConnectionManager
				.getConnection();
		couchbaseClient.add(brokerRequestDto.getNetwork().getNetwork_id(), brokerRequestDoc);

	}
	
	public boolean addUser(RegisterationDTO registerationDTO) throws Exception {
		
		logger.info("Entered into addUser() "+registerationDTO.getUserName());
		
		boolean success;
		try {
			
		String registrationRequestDoc = JsonUtil.marshal(registerationDTO);
		CouchbaseClient couchbaseClient = CouchbaseConnectionManager
				.getConnection();
		
		couchbaseClient.add(registerationDTO.getUserName(), registrationRequestDoc);
		createVerificationTokenKey(registerationDTO.getUserName(),registerationDTO.getvTokenString());
		success=true;
		} catch(Exception ex) {
			throw new Exception("Couchbase Exception has occurred "+ ex);
		}
		return success;

	}
	
	public String verifyToken(String  token) throws Exception {
		
		logger.info("Entered into verifyToken(),Token "+token);
		
		CouchbaseClient couchbaseClient = CouchbaseConnectionManager
				.getConnection();
		String code="";
		synchronized (this) {
			code=(String)couchbaseClient.get(token);
			if( code!=null ) {
				JsonUtil<RegisterationDTO> jsonUtil = new JsonUtil<>();
				//Load UserByUserName
				String doc=getUserByUserName(code);
				RegisterationDTO registerDto=jsonUtil.unmarshal(doc, RegisterationDTO.class);
				logger.info("Active "+ registerDto.getActive());
				registerDto.setActive(EntityTypeConstants.IS_ACTIVE_Y);
				String registerDtoDoc = JsonUtil.marshal(registerDto);
				couchbaseClient.set(registerDto.getUserName(),registerDtoDoc);
				logger.info("deleting the token ");
				couchbaseClient.delete(token);
			}
		}
		return code;

	}
	
	public String getUserByUserName(String userName) {
		
		logger.info("Entered into getUserByUserName");
		
		CouchbaseClient couchbaseClient = CouchbaseConnectionManager
				.getConnection();
		String doc=(String)couchbaseClient.get(userName);
		return doc;
		
		
	}
	
	private boolean createVerificationTokenKey(String email,String verificationToken) throws Exception {
		
		logger.info("Entered into createVerificationTokenKey");
		
		boolean success=true;
		CouchbaseClient couchbaseClient = CouchbaseConnectionManager
				.getConnection();
		try {
		couchbaseClient.add(verificationToken, email);
		} catch(Exception ex) {
			success=false;
			throw new Exception(ex.getMessage());
			
		}
		return success;

	}
	
	
		

}