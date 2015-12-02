package com.property.ws;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.epropertyui.model.Registeration;
import com.property.entity.Response;
import com.property.service.impl.GetPropertyServiceImpl;

@Controller
@RequestMapping("/api")
public class RestServiceApi {
	
	@Autowired
	GetPropertyServiceImpl getPropertyService;

	@RequestMapping(value = "/login/{username}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Response login(@PathVariable String username) throws Exception {
		
		Response response = new Response();
		response =getPropertyService.login(username.trim(),response);

		return response;

	}
	
	@RequestMapping(value = "/addUser", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public @ResponseBody Response addUser(@RequestBody Registeration register) throws Exception {

		System.out.println("Inside create user Controller");
		getPropertyService.addUser(register);
			return null;
		
		}
	
	@RequestMapping(value = "/verifyToken/{token}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String verifyToken(@PathVariable String token) throws Exception {
		
		String response =getPropertyService.verifyToken(token.trim());
		return response;

	}

}
