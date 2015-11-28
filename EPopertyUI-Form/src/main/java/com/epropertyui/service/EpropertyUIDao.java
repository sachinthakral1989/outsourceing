package com.epropertyui.service;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.couchbase.client.CouchbaseClient;
import com.couchbase.client.protocol.views.ComplexKey;
import com.couchbase.client.protocol.views.Query;
import com.couchbase.client.protocol.views.Stale;
import com.couchbase.client.protocol.views.View;
import com.couchbase.client.protocol.views.ViewResponse;
import com.couchbase.client.protocol.views.ViewRow;
import com.epropertyui.constants.ViewConstants;
import com.epropertyui.model.Request;
import com.epropertyui.model.Response;
import com.epropertyui.model.Role;
import com.epropertyui.model.Token;
import com.epropertyui.model.User;
import com.epropertyui.model.UserDTO;
import com.epropertyui.util.CouchbaseConnectionManager;
import com.google.gson.Gson;

@Repository
public class EpropertyUIDao {

	public User loadUserByUsername(final String username)  {
		User user = null;
		UserDTO userDTO = null;
		try {
			Request request=new Request();
			Response response =new Response();
			RestTemplate restTemplate = new RestTemplate();
			String url = "http://localhost:8080/oauth2-auth-server/api/login/"+username;
			System.out.println("Url " + url);
			Gson gson = new Gson();
			String jsonRequest=gson.toJson(request);
			String tokenJson = restTemplate.getForObject(url,String.class);
			ObjectMapper mapper1 = new ObjectMapper();
			try {
				response = mapper1.readValue(tokenJson, Response.class);
				System.out.println("Response "+response.getRole());
				System.out.println("Response "+response.getUsername());
				System.out.println("Response "+response.getEnKey());
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			
			/*userDTO = authenticateUser(username);*/

			user = new User();
			user.setFirstName("a");
			user.setLastName("a");
			user.setUsername(response.getUsername());
			user.setPassword(response.getEnKey().trim());
			Role role = new Role();
			role.setName(response.getRole().trim());
			List<Role> roles = new ArrayList<Role>();
			user.setAuthorities(roles);
			user.setAuthorities(roles);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;

	}

	public UserDTO authenticateUser(String userName) throws Exception {
		String isActive = "Y";
		String passwordDb = "";
		String role = "";
		boolean sucessOrFail;
		UserDTO userDTO = new UserDTO();
		CouchbaseClient couchbaseClient = CouchbaseConnectionManager
				.getConnection();
		View view = couchbaseClient.getView(
				ViewConstants.PROPERTY_DESIGN_DOCUMENT,
				ViewConstants.PROPERTY_FILTER_CATEGORIES_VIEW);
		Query query = new Query();
		query.setIncludeDocs(false);
		query.setStale(Stale.FALSE);
		query.setKey(ComplexKey.of(userName.trim(), isActive.trim()));
		ViewResponse response = couchbaseClient.query(view, query);
		System.out.println(response);
		for (ViewRow row : response) {

			String valueTemp[] = row.getValue().replaceAll("\\[|\\]|\"", "")
					.split(",");
			passwordDb = valueTemp[0];
			role = valueTemp[1];
			System.out.println("passwordDB" + passwordDb);
			userDTO.setUsername(userName);
			userDTO.setRole(role);
			userDTO.setPassword(passwordDb);
			/* sucessOrFail = checkAuthentication(password, passwordDb); */
			/* System.out.println("Authentication " + sucessOrFail); */
			/*
			 * if (sucessOrFail) { userDTO.setUsername(userName);
			 * userDTO.setRole(role); System.out.println(userDTO.getUsername());
			 * System.out.println(userDTO.getRole()); return userDTO; } else {
			 * userDTO.setErrorMsg("Invalid Username or password"); }
			 */
		}
		return userDTO;
	}

	/*
	 * private boolean checkAuthentication(String password, String passwordDb) {
	 * if (password.equals(passwordDb)) { return true; } return false;
	 * 
	 * }
	 */

}
