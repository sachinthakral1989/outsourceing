package com.property.service.impl;

import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.epropertyui.model.BrokerRequest;
import com.epropertyui.model.Token;
import com.epropertyui.model.UserRequest;
import com.property.constants.EntityTypeConstants;
import com.property.dao.GetPropertyDataDao;
import com.property.entity.BrokerRequestDto;
import com.property.entity.RegisterationDTO;
import com.property.entity.Response;
import com.property.entity.UserDTO;
import com.property.entity.UserRequestDto;
import com.property.service.BaseService;
import com.property.util.BeanUtil;
import com.property.util.ServiceUrl;
import com.epropertyui.model.Registeration;

public class GetPropertyServiceImpl implements BaseService {

	private final String retailServiceUrl;
	private final RestTemplate restTemplate;

	private static final Logger logger = Logger.getLogger(GetPropertyServiceImpl.class);

	@Autowired
	GetPropertyDataDao getPropertyDao;
	
	public GetPropertyServiceImpl() throws Exception {

		restTemplate = new RestTemplate();
		retailServiceUrl = ServiceUrl.getInstance().getRetailServiceUrl();
	}

	

	public Response login(String username, Response response) throws Exception {
		System.out.println("<<<<<<<<<<<Entered into authenticate()>>>>>>>>>>>");

		Token token = new Token();
		ObjectMapper mapper1 = new ObjectMapper();

		// Get data based on username
		UserDTO userDTO = getPropertyDao.loadUserByUserName(username);

		// Set username and role in response
		response.setUsername(userDTO.getUsername());
		response.setEnKey(userDTO.getPassword());
		response.setRole(userDTO.getRole());

		String tokenJson = restTemplate.getForObject(retailServiceUrl,
				String.class);

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
			logger.error("jsonparsingException occured " + e);

		} catch (JsonMappingException e) {
			logger.error("JsonMappingException has occured " + e);

		} catch (Exception e) {
			logger.error("Exception has occured " + e);

		}
		return response;

	}

	public void sendUserProperty(UserRequest userRequest) {
		System.out.println("Entered into sendUserProperty "+ userRequest);
		UserRequestDto userRequestDto = new UserRequestDto();
		populateUserRequestDto(userRequest, userRequestDto);
		try {
			getPropertyDao.sendUserProperty(userRequestDto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("sendUserProperty");
	}
	
	/*public void createUser(Registeration register) {
		System.out.println("Entered into sendUserProperty "+ register);
		UserRequestDto userRequestDto = new UserRequestDto();
		populateUserRequestDto(userRequest, userRequestDto);
		try {
			getPropertyDao.sendUserProperty(userRequestDto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("sendUserProperty");
	}*/
	
	
	public void sendBrokerProperty(BrokerRequest brokerRequest) {
		System.out.println("Entered into sendUserProperty "+ brokerRequest);
		BrokerRequestDto brokerRequestDto = new BrokerRequestDto();
		populateUserRequestDto(brokerRequest, brokerRequestDto);
		try {
			getPropertyDao.sendBrokerProperty(brokerRequestDto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("sendUserProperty");
	}
	
	public void addUser(Registeration register) {
		System.out.println("Entered into sendUserProperty "+ register);
		RegisterationDTO registerationDto = new RegisterationDTO();
		populateRegisterationDto(register, registerationDto);
		try {
			getPropertyDao.addUser(registerationDto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("sendUserProperty");
	}
	
	

	private UserRequestDto populateUserRequestDto(UserRequest userRequest,
			UserRequestDto userRequestDto) {
		BeanUtil.copyProperties(userRequest,userRequestDto );
		return userRequestDto;

	}
	
	private RegisterationDTO populateRegisterationDto(Registeration register,
			RegisterationDTO registerationDTO) {
		BeanUtil.copyProperties(register,registerationDTO );
		return registerationDTO;

	}
	
	private BrokerRequestDto populateUserRequestDto(BrokerRequest brokerRequest,
			BrokerRequestDto brokerRequestDto) {
		BeanUtil.copyProperties(brokerRequest,brokerRequestDto );
		return brokerRequestDto;

	}
	
	public String verifyToken(String token) throws Exception {
		return getPropertyDao.verifyToken(token);
	}


}
