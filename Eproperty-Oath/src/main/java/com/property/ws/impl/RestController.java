package com.property.ws.impl;

import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import com.epropertyui.model.Token;
import com.property.dao.GetPropertyDataDao;
import com.property.dao.impl.GetPropertyDataDaoImpl;
import com.property.entity.Request;
import com.property.entity.Response;
import com.property.entity.UserDTO;

@Controller
@RequestMapping("/api")
public class RestController {

	@RequestMapping(value = "/login/{username}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody
	Response login(@PathVariable String username) throws Exception {
		System.out.println("Request is " + username);
		String url = null;
		Token token = null;
		UserDTO userDTO = null;
		Response response = new Response();

		GetPropertyDataDao getProperty = new GetPropertyDataDaoImpl();
		userDTO = getProperty.authenticateUser(username.trim());

			// Set username and role in response

			response.setUsername(userDTO.getUsername());
			response.setEnKey(userDTO.getPassword());
			response.setRole(userDTO.getRole());

			RestTemplate restTemplate = new RestTemplate();
			url = "http://localhost:8080/oauth2-auth-server/oauth/token?grant_type=client_credentials&client_id=test&client_secret=test";
			System.out.println("Url " + url);
			String tokenJson = restTemplate.getForObject(url, String.class);
			ObjectMapper mapper1 = new ObjectMapper();
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
				e.printStackTrace();

			} catch (JsonMappingException e) {
				e.printStackTrace();

			} catch (Exception e) {
				e.printStackTrace();

			}
		
		return response;

	}
	
	@RequestMapping(value = "/sendProperty", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public @ResponseBody
	Response sendProperty(@RequestBody Request request) throws Exception {
		System.out.println(request.getUsername());
		return null;
	
	}

	
}
