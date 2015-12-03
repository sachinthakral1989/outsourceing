package com.property.dao.impl;

import java.util.UUID;

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
import com.property.entity.UserRequestDto;
import com.property.util.CouchbaseConnectionManager;
import com.property.util.JsonUtil;

public class GetPropertyDataDaoImpl implements GetPropertyDataDao {

	public UserDTO loadUserByUserName(String userName) throws Exception {
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
		System.out.println(response);
		for (ViewRow row : response) {

			String valueTemp[] = row.getValue().replaceAll("\\[|\\]|\"", "")
					.split(",");
			passwordDb = valueTemp[0];
			role = valueTemp[1];

			userDTO.setUsername(userName);
			userDTO.setPassword(passwordDb);
			userDTO.setRole(role);
			System.out.println(userDTO.getUsername());
			System.out.println(userDTO.getRole());
			System.out.println("passwordDb " + passwordDb);
		}
		return userDTO;
	}

	public void sendUserProperty(UserRequestDto userRequestDto) throws Exception {
		System.out.println("Entered into sendUserProperty() "+userRequestDto.getSaleOrRent()+userRequestDto.getBerooms());
		userRequestDto.setId(UUID.randomUUID().toString());
		String userRequestDoc = JsonUtil.marshal(userRequestDto);
		CouchbaseClient couchbaseClient = CouchbaseConnectionManager
				.getConnection();
		couchbaseClient.add(userRequestDto.getId(), userRequestDoc);

		System.out.println("<<<<<<<<<<<<<<<<sendUserProperty()>>>>>>>>>>>>>>>>>>>>>>>>>>");
	}


	public void sendBrokerProperty(BrokerRequestDto brokerRequestDto) throws Exception {
		
		//brokerRequestDto.setId(UUID.randomUUID().toString());
		String brokerRequestDoc = JsonUtil.marshal(brokerRequestDto);
		CouchbaseClient couchbaseClient = CouchbaseConnectionManager
				.getConnection();
		couchbaseClient.add(brokerRequestDto.getNetwork().getNetwork_id(), brokerRequestDoc);

	}
	
	public void addUser(RegisterationDTO registerationDTO) throws Exception {
		String registrationRequestDoc = JsonUtil.marshal(registerationDTO);
		CouchbaseClient couchbaseClient = CouchbaseConnectionManager
				.getConnection();
		
		couchbaseClient.add(registerationDTO.getUserName(), registrationRequestDoc);
		createVerificationTokenKey(registerationDTO.getUserName(),registerationDTO.getvTokenString());

	}
	
	public String verifyToken(String  token) throws Exception {
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
				System.out.println("Active "+ registerDto.getActive());
				registerDto.setActive(EntityTypeConstants.IS_ACTIVE_Y);
				String registerDtoDoc = JsonUtil.marshal(registerDto);
				couchbaseClient.set(registerDto.getUserName(),registerDtoDoc);
				System.out.println("deleting the token ");
				couchbaseClient.delete(token);
			}
		}
		return code;

	}
	
	public String getUserByUserName(String userName) {
		CouchbaseClient couchbaseClient = CouchbaseConnectionManager
				.getConnection();
		String doc=(String)couchbaseClient.get(userName);
		return doc;
		
		
	}
	
	private boolean createVerificationTokenKey(String email,String verificationToken) throws Exception {
		
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