package com.property.ws;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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

}
