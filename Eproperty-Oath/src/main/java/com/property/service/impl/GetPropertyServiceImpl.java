package com.property.service.impl;



import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.epropertyui.model.Token;
import com.property.dao.GetPropertyDataDao;
import com.property.entity.Response;
import com.property.entity.UserDTO;
import com.property.service.BaseService;
import com.property.util.ServiceUrl;

public class GetPropertyServiceImpl implements BaseService {

	private final String retailServiceUrl;
	private final RestTemplate restTemplate;
	
	private static final Logger logger = Logger.getLogger(GetPropertyServiceImpl.class);
	
	public GetPropertyServiceImpl() throws Exception {
		
		restTemplate = new RestTemplate();
		retailServiceUrl = ServiceUrl.getInstance().getRetailServiceUrl();
	}

	@Autowired
	GetPropertyDataDao getPropertyDao;

	public Response login(String username, Response response) throws Exception {
		System.out.println("<<<<<<<<<<<Entered into authenticate()>>>>>>>>>>>");
		
		Token token = new Token();
		ObjectMapper mapper1 = new ObjectMapper();
		
		//Get data based on username
		UserDTO userDTO = getPropertyDao.login(username);

		// Set username and role in response
		response.setUsername(userDTO.getUsername());
		response.setEnKey(userDTO.getPassword());
		response.setRole(userDTO.getRole());

		String tokenJson = restTemplate.getForObject(retailServiceUrl, String.class);
		
		try {
			token = mapper1.readValue(tokenJson, Token.class);
			if (token.getAccess_token() != null) {
				System.out.println("inside");
				response.setAccess_token(token.getAccess_token());
				response.setToken_type(token.getToken_type());
				response.setScope(token.getScope());
				response.setExpires_in((token.getExpires_in()));

			}

		} catch (JsonParseException e) {
			logger.error("jsonparsingException occured "+ e);

		} catch (JsonMappingException e) {
			logger.error("JsonMappingException has occured "+ e);

		} catch (Exception e) {
			logger.error("Exception has occured "+ e);

		}
		return response;

	}

	

}
