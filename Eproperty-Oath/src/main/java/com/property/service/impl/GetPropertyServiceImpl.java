package com.property.service.impl;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.epropertyui.model.BrokerRequest;
import com.epropertyui.model.Token;
import com.epropertyui.model.UserRequest;
import com.property.dao.GetPropertyDataDao;
import com.property.entity.BrokerRequestDto;
import com.property.entity.RegisterationDTO;
import com.property.entity.Response;
import com.property.entity.UserDTO;
import com.property.entity.UserProperty;
import com.property.entity.UserPropertyDTO;
import com.property.service.BaseService;
import com.property.util.AsyncExecutor;
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

	public Response login(final String username, final Response response)
			throws Exception {
		logger.info("<<<<<<<<<<<Entered into login()>>>>>>>>>>>");

		Callable<Response> asyncTask = new Callable<Response>() {

			@Override
			public Response call() throws Exception {
				Token token = new Token();
				ObjectMapper mapper1 = new ObjectMapper();

				// Get data based on username
				UserDTO userDTO = getPropertyDao.loadUserByUserName(username);

				// Set username and role in response
				response.setUsername(userDTO.getUsername());
				response.setEnKey(userDTO.getPassword());
				response.setRole(userDTO.getRole());
				logger.info("<<<<<<<<<<<Sevice call for getting token>>>>>>>>>>>");
				String tokenJson = restTemplate.getForObject(retailServiceUrl,
						String.class);

				try {
					token = mapper1.readValue(tokenJson, Token.class);
					if (token.getAccess_token() != null) {
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

		};
		Future<Response> asyncResult = AsyncExecutor.queueAndExecute(asyncTask);
		return asyncResult.get();
	}

	public void sendUserProperty(UserProperty userProperty) {
		logger.info("Entered into sendUserProperty "
				+ userProperty.getPropertyForEx());
		UserPropertyDTO userPropertyDto = new UserPropertyDTO();
		populateUserRequestDto(userProperty, userPropertyDto);
		try {
			getPropertyDao.sendUserProperty(userPropertyDto);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/*
	 * public void createUser(Registeration register) {
	 * System.out.println("Entered into sendUserProperty "+ register);
	 * UserRequestDto userRequestDto = new UserRequestDto();
	 * populateUserRequestDto(userRequest, userRequestDto); try {
	 * getPropertyDao.sendUserProperty(userRequestDto); } catch (Exception e) {
	 * e.printStackTrace(); }
	 * 
	 * System.out.println("sendUserProperty"); }
	 */

	public void sendBrokerProperty(BrokerRequest brokerRequest) {
		logger.info("Entered into sendUserProperty " + brokerRequest);
		BrokerRequestDto brokerRequestDto = new BrokerRequestDto();
		populateUserRequestDto(brokerRequest, brokerRequestDto);
		try {
			getPropertyDao.sendBrokerProperty(brokerRequestDto);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void addUser(final Registeration register) throws Exception {

		logger.info("Entered into addUser " + register);

		Callable<String> asyncTask = new Callable<String>() {

			@Override
			public String call() throws Exception {
				boolean success = false;
				RegisterationDTO registerationDto = new RegisterationDTO();
				populateRegisterationDto(register, registerationDto);
				try {
					success = getPropertyDao.addUser(registerationDto);
				} catch (Exception e) {
					e.printStackTrace();
				}

				return Boolean.toString(success);
			}
		};
		Future<String> asyncResult = AsyncExecutor.queueAndExecute(asyncTask);
		asyncResult.get();
	}

	private UserPropertyDTO populateUserRequestDto(UserProperty userRequest,
			UserPropertyDTO userRequestDto) {
		BeanUtil.copyProperties(userRequest, userRequestDto);
		return userRequestDto;

	}

	private RegisterationDTO populateRegisterationDto(Registeration register,
			RegisterationDTO registerationDTO) {
		BeanUtil.copyProperties(register, registerationDTO);
		return registerationDTO;

	}

	private BrokerRequestDto populateUserRequestDto(
			BrokerRequest brokerRequest, BrokerRequestDto brokerRequestDto) {
		BeanUtil.copyProperties(brokerRequest, brokerRequestDto);
		return brokerRequestDto;

	}

	public String verifyToken(String token) throws Exception {
		return getPropertyDao.verifyToken(token);
	}

}
