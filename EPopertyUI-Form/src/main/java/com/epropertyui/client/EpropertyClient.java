package com.epropertyui.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.epropertyui.model.BrokerDto;
import com.epropertyui.model.Registeration;
import com.epropertyui.model.Response;
import com.epropertyui.model.Role;
import com.epropertyui.model.SearchProperty;
import com.epropertyui.model.Token;
import com.epropertyui.model.User;
import com.epropertyui.model.UserProperty;
import com.epropertyui.util.EncryptionUtil;
import com.epropertyui.util.ServiceUrl;


@Repository
public class EpropertyClient {

	RestTemplate restTemplate;
	ObjectMapper mapper;
	HttpSession session;
	String propertyServiceUrl;
	
	private static final Logger logger = Logger.getLogger(EpropertyClient.class);

	public EpropertyClient() throws Exception {

		restTemplate = new RestTemplate();
		mapper = new ObjectMapper();
		propertyServiceUrl = ServiceUrl.getInstance().getPropertyServiceUrl();
		logger.info("-----------Property Service Url is -"+ propertyServiceUrl+"-------------");
		
	}

	

	public HttpSession getSession() {
		logger.info("Request for GetSession");
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder
				.currentRequestAttributes();
		session = attr.getRequest().getSession();
		return session;
	}

	public User loadUserByUsername(final String username) {
		User user = null;
		
		try {
			
			Response response = new Response();
			String url = propertyServiceUrl + "api/login/" + username+"/";
			logger.info("-----------Sending Request with loadUserByUsername Url -" + url+"----------------");
			String tokenJson = restTemplate.getForObject(url, String.class);

			try {
				response = mapper.readValue(tokenJson, Response.class);
			} catch (Exception ex) {
				logger.info("Exception has occured "+ex);
			}

			user = new User();
			user.setUsername(response.getUsername());
			user.setPassword(EncryptionUtil.Decode(response.getEnKey().trim()));
			Role role = new Role();
			logger.info("Role name is " + response.getRole().trim());
			role.setName(response.getRole().trim());
			List<Role> roles = new ArrayList<Role>();
			roles.add(role);
			user.setAuthorities(roles);
		} catch (Exception e) {
			logger.info("Exception has occured "+e);
			user.setErrMsg(e.getMessage());
		}
		return user;

	}

	public Token getAuthenticatedToken() throws Exception  {
		Token token = new Token();
		String url = propertyServiceUrl
				+ "oauth/token?grant_type=client_credentials&client_id=test&client_secret=test";
		try {
			logger.info("-----------Sending Request with getAuthenticatedToken Url -" + url+"----------------");
			String tokenJson = restTemplate.getForObject(url, String.class);
			token = mapper.readValue(tokenJson, Token.class);
		} catch (Exception ex) {
			logger.info("Exception has occured "+ex);
			String errorMsg="Rest Client Exception has occured";
			throw new Exception(errorMsg);
		}

		return token;
	}
	
	public boolean addUser(Registeration register) throws Exception {
		System.out.println("Inside addUser ");
		String url = propertyServiceUrl+"api"+"/addUser";
		try {
			logger.info("-----------Sending Request with addUser Url -" + url+"----------------");
			logger.info("------Sending data as-------");
			logger.info("Name :"+register.getFullName());
			logger.info("Password :"+register.getEnKey());
			logger.info("UserName :"+register.getUserName());
			logger.info(register.getActive()+" "+register.getCreatedDate()+" "+register.getCreatedUser()+" "+register.getRole()+" "+register.getType()+" "+register.getvTokenString());
			restTemplate.postForEntity(url, register,String.class);
		} catch (Exception ex) {
			logger.info("Exception has occured "+ex);
			String errorMsg="Rest Client Exception has occured";
			throw new Exception(errorMsg);
		}
		return true;
	}

	public String sendUserProperty(UserProperty userProperty) throws Exception {
		logger.info("Inside sendUserProperty "+ userProperty);
		try {
		session = getSession();
		String accessToken = (String) session.getAttribute("accessToken");
		String url = propertyServiceUrl + "secure/" + "sendUserProperty"
				+ "?access_token=" + accessToken;
		logger.info("-----------Sending Request with Url with token is -" + url+"----------------");
		 restTemplate.postForEntity(url, userProperty, String.class);
		} catch(Exception ex) {
			logger.info("Exception has occured "+ex);
			String errorMsg="Rest Client Exception has occured";
			throw new Exception(errorMsg);
		}
		 return "true";
	}
	
	public String verifyToken(String token) throws Exception {
		logger.info("VerifyToken "+ token);
		String url;
		String response="";
		try {
		 url = propertyServiceUrl + "api/verifyToken/" + token;
		logger.info("-----------Sending Request with Verify Token Url -" + url+"----------------");
		response = restTemplate.getForObject(url, String.class);
		System.out.println(response);
		} catch(Exception ex) {
			logger.info("Exception has occured "+ex);
			String errorMsg="Rest Client Exception has occured";
			throw new Exception(errorMsg);
		}
        return response;
		
		
		
	}



	public List<UserProperty> searchProperty(SearchProperty searchProperty) throws Exception {
		logger.info("Inside searchProperty ");
		logger.info(searchProperty.getPropertySearchFor()+" "+searchProperty.getPropertySearchType()+" "+searchProperty.getBhk()+" "+searchProperty.getLocality()+" "+searchProperty.getMinPrice()+" "+searchProperty.getMaxPrice());
		String url = propertyServiceUrl+"api"+"/searchProperty";
		UserProperty[] userPropertyArr = null;
		try {
			logger.info("-----------Sending Request with searchProperty Url -" + url+"----------------");
			//String response = restTemplate.postForObject(url, searchProperty, String.class);
			ResponseEntity<UserProperty[]> responseEntity = restTemplate.postForEntity(url, searchProperty, UserProperty[].class);
            userPropertyArr = responseEntity.getBody();
		} catch (Exception ex) {
			logger.info("Exception has occured "+ex);
			String errorMsg="Rest Client Exception has occured";
			throw new Exception(errorMsg);
		}
		logger.info(userPropertyArr[0].getPropertyForEx()+" "+userPropertyArr[0].getPropertyTypeEx()+" "+userPropertyArr[0].getHouseNumber()+" "+userPropertyArr[1].getHouseNumber());
		return Arrays.asList(userPropertyArr);
	}
	
	
	public boolean createBroker(BrokerDto brokerDto) throws Exception {
		try {
			session = getSession();
			String accessToken = (String) session.getAttribute("accessToken");
			String url = propertyServiceUrl + "secure/" + "createbroker"
					+ "?access_token=" + accessToken;
			System.out.println("Url with token is " + url);
			restTemplate.postForEntity(url, brokerDto, BrokerDto.class);
			return true;
		} catch (RestClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
		 
	}
	public BrokerDto viewBroker(String brokerId) {
		BrokerDto brokerDto = new BrokerDto();
		
		String accessToken = (String) session.getAttribute("accessToken");
		String url = propertyServiceUrl + "secure/" + "viewbroker"
				+ "?access_token=" + accessToken+"/"+brokerId+"/";
		System.out.println("Url with token is " + url);
		String brokerDtoJson= restTemplate.getForObject(url, String.class);
		try {
			brokerDto= mapper.readValue(brokerDtoJson, BrokerDto.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return brokerDto;
	}
	
	public List<BrokerDto> viewBrokers(){
		logger.info("Inside viewBroker()");
		 BrokerDto[] brokerDto=null;
		 session = getSession();
		logger.info("Get session object "+ session );
		String accessToken = (String) session.getAttribute("accessToken");
		String url = propertyServiceUrl + "secure/" + "viewbrokers"
				+ "?access_token=" + accessToken;
		logger.info("Url with token is " + url);
		ResponseEntity<BrokerDto[]> responseEntity = restTemplate.getForEntity(url, BrokerDto[].class);
		brokerDto = responseEntity.getBody();
		
		 return Arrays.asList(brokerDto);
	}
	
	public List<UserProperty> viewUsersProperties(){
		 UserProperty[] userProperty=null;
		 	session = getSession();
			logger.info("Get session object "+ session );
		String accessToken = (String) session.getAttribute("accessToken");
		String url = propertyServiceUrl + "secure/" + "viewUserProperties"
				+ "?access_token=" + accessToken;
		System.out.println("Url with token is " + url);
		/*String UserPropertyJsons= restTemplate.getForObject(url, String.class);*/
		ResponseEntity<UserProperty[]> responseEntity = restTemplate.getForEntity(url, UserProperty[].class);
		userProperty = responseEntity.getBody();
		/*try {
			userProperties= (List<UserProperty>) mapper.readValue(UserPropertyJsons, UserProperty.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		 return Arrays.asList(userProperty);
	}
	
	
	public boolean viewUserProperty(UserProperty userProperty){
		
		String accessToken = (String) session.getAttribute("accessToken");
		String url = propertyServiceUrl + "secure/" + "updateUserProperty"
				+ "?access_token=" + accessToken;
		System.out.println("Url with token is " + url);
		
		try {
			restTemplate.postForEntity(url, userProperty, UserProperty.class);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return false;
	}
	
	
	
}
