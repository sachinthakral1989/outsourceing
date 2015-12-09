package com.property.ws;


import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.epropertyui.model.Registeration;
import com.property.entity.Response;
import com.property.entity.SearchProperty;
import com.property.entity.UserProperty;
import com.property.entity.UserPropertyDTO;
import com.property.service.impl.GetPropertyServiceImpl;

@Controller
@RequestMapping("/api")
public class RestServiceApi {
	
	private static final Logger logger = Logger.getLogger(RestServiceApi.class);

	
	@Autowired
	GetPropertyServiceImpl getPropertyService;

	@RequestMapping(value = "/login/{username}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Response login(@PathVariable String username) throws Exception {
		
		logger.info("+++++++RestServiceApi.login username "+ username+" ++++++++++++");
		
		Response response = new Response();
		response =getPropertyService.login(username.trim(),response);

		return response;

	}
	
	@RequestMapping(value = "/addUser", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public @ResponseBody Response addUser(@RequestBody Registeration register) throws Exception {

		logger.info("+++++++RestServiceApi.addUser register "+ register.getFullName()+" ++++++++++++");
		getPropertyService.addUser(register);
			return null;
		
		}
	
	@RequestMapping(value = "/searchProperty", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public @ResponseBody List<UserProperty> searchProperty(@RequestBody SearchProperty searchProperty) throws Exception {

		logger.info("+++++++RestServiceApi.searchProperty searchProperty "+ searchProperty.getPropertySearchFor()+" ++++++++++++");
		return getPropertyService.searchProperty(searchProperty);
		
		}
	
	@RequestMapping(value = "/verifyToken/{token}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String verifyToken(@PathVariable String token) throws Exception {
		
		logger.info("+++++++RestServiceApi.verifyToken token "+ token+" ++++++++++++");
		
		String response =getPropertyService.verifyToken(token.trim());
		return response;

	}

}
