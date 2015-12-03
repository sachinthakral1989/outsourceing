package com.epropertyui.service;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
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
import com.epropertyui.util.EncryptionUtil;
import com.epropertyui.util.ServiceUrl;

@Repository
public class EpropertyUIDao {

	RestTemplate restTemplate;
	ObjectMapper mapper;
	HttpSession session;
	String propertyServiceUrl;

	public EpropertyUIDao() throws Exception {

		restTemplate = new RestTemplate();
		mapper = new ObjectMapper();
		propertyServiceUrl = ServiceUrl.getInstance().getPropertyServiceUrl();
		
	}

	public void init() throws Exception {
		System.out.println("Init method after properties are set :");
		

	}

	public HttpSession getSession() {
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
			System.out.println("Url " + url);
			String tokenJson = restTemplate.getForObject(url, String.class);

			try {
				response = mapper.readValue(tokenJson, Response.class);
			} catch (Exception ex) {
				ex.printStackTrace();
			}

			user = new User();
			user.setFirstName("a");
			user.setLastName("a");
			user.setUsername(response.getUsername());
			user.setPassword(EncryptionUtil.Decode(response.getEnKey().trim()));
			Role role = new Role();
			System.out.println("Role name is " + response.getRole().trim());
			role.setName(response.getRole().trim());
			List<Role> roles = new ArrayList<Role>();
			roles.add(role);
			user.setAuthorities(roles);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;

	}

	public Token getAuthenticatedToken() {
		Token token = new Token();
		String url = propertyServiceUrl
				+ "oauth/token?grant_type=client_credentials&client_id=test&client_secret=test";
		try {
			String tokenJson = restTemplate.getForObject(url, String.class);
			token = mapper.readValue(tokenJson, Token.class);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return token;
	}
	
	public boolean addUser(Registeration register) {
		System.out.println("Inside addUser ");
		HttpSession session=getSession();
		String accessToken = (String) session.getAttribute("accessToken");
		String url = propertyServiceUrl+"api"+"/addUser";
		try {
			restTemplate.postForEntity(url, register,String.class);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return true;
	}

	public String sendUserProperty(String property) {
		session = getSession();
		String accessToken = (String) session.getAttribute("accessToken");
		String url = propertyServiceUrl + "secure/" + "sendUserProperty?"
				+ "?access_token=" + accessToken;
		System.out.println("Url with token is " + url);
		return url;
		/* restTemplate.postForEntity(url, request, responseType) */
	}
	
	public String verifyToken(String token) {
		String url = propertyServiceUrl + "api/verifyToken/" + token;
		System.out.println("Url " + url);
		String response = restTemplate.getForObject(url, String.class);
		System.out.println(response);
        return response;
		
		
		
	}
}
