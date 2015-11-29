package com.property.ws;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.property.entity.Request;
import com.property.entity.Response;

@Controller
@RequestMapping("/secure")
public class PropertyServiceApi {

	@RequestMapping(value = "/sendUserProperty", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public @ResponseBody Response sendUserProperty(@RequestBody Request request) throws Exception {

			System.out.println(request.getUsername());
			return null;
		
		}

}
