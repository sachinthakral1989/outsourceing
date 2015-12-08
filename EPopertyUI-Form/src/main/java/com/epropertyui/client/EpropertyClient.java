package com.epropertyui.client;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import com.epropertyui.model.Registeration;
import com.epropertyui.model.Response;
import com.epropertyui.model.Role;
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
				ex.printStackTrace();
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
			logger.error(ex);
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
			restTemplate.postForEntity(url, register,String.class);
		} catch (Exception ex) {
			logger.error(ex);
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
			logger.error(ex);
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
			logger.error(ex);
			String errorMsg="Rest Client Exception has occured";
			throw new Exception(errorMsg);
		}
        return response;
		
		
		
	}
}
