package com.property.dao.impl;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.log4j.Logger;

import com.couchbase.client.CouchbaseClient;
import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.CouchbaseCluster;
import com.couchbase.client.java.document.JsonDocument;
import com.couchbase.client.java.document.json.JsonObject;
import com.couchbase.client.protocol.views.ComplexKey;
import com.couchbase.client.protocol.views.Query;
import com.couchbase.client.protocol.views.Stale;
import com.couchbase.client.protocol.views.View;
import com.couchbase.client.protocol.views.ViewResponse;
import com.couchbase.client.protocol.views.ViewRow;
import com.google.gson.Gson;
import com.property.constants.EntityTypeConstants;
import com.property.constants.ViewConstants;
import com.property.dao.GetPropertyDataDao;
import com.property.entity.AdminDto;
import com.property.entity.BrokerDto;
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
		String key="";
		
		if(userRequestDto.getPropertyForEx().equals("Sale")) {
			if(userRequestDto.getPropertyTypeEx().equals("House")) {
				key=key+userRequestDto.getLocality()+"_"+userRequestDto.getPropertyForEx()+"_"+userRequestDto.getPropertyTypeEx()+"_"+userRequestDto.getBhk()+"_"+userRequestDto.getHouseNumber();
			} else if(userRequestDto.getPropertyTypeEx().equals("Land")) {
				key=key+userRequestDto.getLocality()+"_"+userRequestDto.getPropertyForEx()+"_"+userRequestDto.getPropertyTypeEx()+"_"+userRequestDto.getHouseNumber();
			} else {
				if(userRequestDto.getPropertyTypeEx().equals("House")) {
					key=key+userRequestDto.getLocality()+"_"+userRequestDto.getPropertyForEx()+"_"+userRequestDto.getPropertyTypeEx()+"_"+userRequestDto.getBhk()+"_"+userRequestDto.getHouseNumber();
				} else if(userRequestDto.getPropertyTypeEx().equals("Land")) {
					key=key+userRequestDto.getLocality()+"_"+userRequestDto.getPropertyForEx()+"_"+userRequestDto.getPropertyTypeEx()+"_"+userRequestDto.getHouseNumber();
				}
			}
		}
		
		userRequestDto.setId(key);
		logger.info("Send User Property Key is"+key);
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
	
	public ViewResponse senPropertyCall(String request) throws Exception {
		System.out.println("Request is " + request);
		CouchbaseClient couchbaseClient = CouchbaseConnectionManager
				.getConnection();
		View view = couchbaseClient.getView(
				ViewConstants.PROPERTY_DESIGN_DOCUMENT,
				ViewConstants.PROPERTY_FILTER_CATEGORIES_VIEW);
		Query query = new Query();
		query.setIncludeDocs(true);
		ViewResponse response = couchbaseClient.query(view, query);
		System.out.println(response);
		return response;
	}

	public static JsonObject setProperty(Object obj) throws Exception {
		JsonObject userInObject = null;
		try {
			HashMap<String, Object> map = new HashMap<>();
			for (Field field : obj.getClass().getDeclaredFields()) {

				field.setAccessible(true);
				Object value = field.get(obj);
				if (!Collection.class.isInstance(value)
						&& !Map.class.isInstance(value)) {
					if (value != null && !field.getName().equalsIgnoreCase("serialVersionUID")) {
						map.put(field.getName(), value);
					}

				}
			}
			userInObject = JsonObject.empty();
			for (Map.Entry<String, Object> entry : map.entrySet()) {
				userInObject.put(entry.getKey(), entry.getValue());
			}
		}

		catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
		return userInObject;

	}
	
	public static boolean createDbCalls(String indexKey, JsonObject jsonObj)
			throws Exception {
		Cluster cluster = CouchbaseCluster.create();
		try {
			Bucket bucket = cluster.openBucket();
			JsonDocument doc = JsonDocument.create(indexKey, jsonObj);
			JsonDocument response = bucket.upsert(doc);
			if (response != null) {
				if (!response.content().isEmpty())
					System.out.println("response: " + response.toString());
				return true;
			}

		} catch (Exception ex) {
			throw ex;
		} finally {
			cluster.disconnect();
		}
		return false;
	}

	@Override
	public boolean createAdmin(AdminDto adminDto) throws Exception {

		try {

			JsonObject userInObject = setProperty(adminDto);
			return createDbCalls(adminDto.getAdminId(), userInObject);

		} catch (Exception ex) {
			throw ex;
		}

	}



	@Override
	public boolean createBroker(BrokerDto brokerDto) throws Exception {
		try {
			JsonObject brokerObject = setProperty(brokerDto);
			return createDbCalls(brokerDto.getBrokerId(), brokerObject);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
	}



	@Override
	public List<BrokerDto> viewBrokers() throws Exception {
		 List<BrokerDto> brokerDtos =null;
		try {
			CouchbaseClient couchbaseClient = CouchbaseConnectionManager
					    .getConnection();
					  View view = couchbaseClient.getView(
					    ViewConstants.PROPERTY_DESIGN_DOCUMENT,
					    ViewConstants.PROPERTY_FILTER_BROKERS_VIEW);
					  Query query = new Query();
					  query.setIncludeDocs(true);
					  query.setStale(Stale.FALSE);
					 // activeStatus="true";
					String type="Broker";
					query.setKey(ComplexKey.of(type.trim()));
					  ViewResponse response = couchbaseClient.query(view, query);
					  brokerDtos = new ArrayList<BrokerDto>();
					  Gson gson = new Gson();
					  for (ViewRow row : response) {
						  brokerDtos.add(gson.fromJson((String) row.getDocument(), BrokerDto.class))	;		
						  }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return brokerDtos;
	}



	@Override
	public BrokerDto viewBroker(String brokerId) throws Exception {
		 BrokerDto brokerDto= null;
		try {
			CouchbaseClient couchbaseClient = CouchbaseConnectionManager
					    .getConnection();
					  View view = couchbaseClient.getView(
					    ViewConstants.PROPERTY_DESIGN_DOCUMENT,
					    ViewConstants.PROPERTY_FILTER_BROKER_VIEW_BY_ID);
					  Query query = new Query();
					  query.setIncludeDocs(true);
					  //query.setStale(Stale.FALSE);
					 // activeStatus="true";
				//String type="Broker";
					query.setKey(ComplexKey.of(brokerId.trim()));
					  ViewResponse response = couchbaseClient.query(view, query);
					  Gson gson = new Gson();
					  for (ViewRow row : response) {
						  brokerDto= gson.fromJson((String) row.getDocument(), BrokerDto.class);		
						  }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return brokerDto;
	}
	
	
		

}