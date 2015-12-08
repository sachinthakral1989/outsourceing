package com.property.service.impl;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.epropertyui.model.BrokerRequest;
import com.epropertyui.model.Token;
import com.epropertyui.model.UserRequest;
import com.property.dao.GetPropertyDataDao;
import com.property.entity.AdminDto;
import com.property.entity.BrokerDto;
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
	
	public enum Mode {
		ENCRYPT_MODE, DECRYPT_MODE
	}

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
				/*logger.info("<<<<<<<<<<<Sevice call for getting token>>>>>>>>>>>");
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

				}*/
				return response;
			}

		};
		Future<Response> asyncResult = AsyncExecutor.queueAndExecute(asyncTask);
		return asyncResult.get();
	}

	public void sendUserProperty(UserProperty userProperty) {
		logger.info("Entered into sendUserProperty "
				+ userProperty.getPropertyForEx());
		userProperty.setType("UserProperty");
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
	
	public boolean createAdmin(AdminDto adminDto) throws Exception {
		try {
			return getPropertyDao.createAdmin(adminDto);
		} catch (Exception ex) {
			throw ex;
		}
	}

	public boolean createBroker(BrokerDto brokerDto) throws Exception {
		// TODO Auto-generated method stub
		try {
			brokerDto
					.setPwd(enDeCryption(brokerDto.getPwd(), Mode.ENCRYPT_MODE));
			return getPropertyDao.createBroker(brokerDto);
		} catch (Exception ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
			throw ex;
		}
	}

	public static String enDeCryption(String str, Mode mode) throws Exception {

		try {
			/*
			 * KeyPairGenerator keygenerator =
			 * KeyPairGenerator.getInstance("RSA"); SecureRandom random =
			 * SecureRandom.getInstance("SHA1PRNG", "SUN");
			 * keygenerator.initialize(1024, random);s
			 * 
			 * KeyPair keypair = keygenerator.generateKeyPair(); PrivateKey
			 * privateKey = keypair.getPrivate(); PublicKey publicKey =
			 * keypair.getPublic(); Cipher cipher = Cipher.getInstance("RSA");
			 */

			switch (mode) {
			case ENCRYPT_MODE:
				byte[] encoded = Base64.encodeBase64(str.getBytes());
				return new String(encoded);
				/*
				 * byte[] cleartext = null; cleartext = str.getBytes("UTF8");
				 * cipher.init(Cipher.ENCRYPT_MODE, publicKey); byte[]
				 * ciphertext = null; ciphertext = cipher.doFinal(cleartext);
				 * System.out.println("the encrypted text is: " +
				 * org.apache.commons
				 * .codec.binary.Base64.decodeBase64(ciphertext));
				 */
			case DECRYPT_MODE:
				/*
				 * byte[] buffer =
				 * org.apache.commons.codec.binary.Base64.decodeBase64
				 * (str.getBytes()) ; cipher.init(Cipher.DECRYPT_MODE,
				 * privateKey); byte[] cleartext1 = cipher.doFinal(buffer);
				 * System.out.println("the decrypted cleartext is: " + new
				 * String(cleartext1));
				 */
				byte[] decoded = Base64.decodeBase64(str);
				return new String(decoded);
			}

		} catch (Exception ex) {
			throw ex;
		}
		return str;

	}

	public List<BrokerDto> viewBrokers() throws Exception {
		return getPropertyDao.viewBrokers();
	}

	public BrokerDto viewBroker(String brokerId) throws Exception {
		return getPropertyDao.viewBroker(brokerId);
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
