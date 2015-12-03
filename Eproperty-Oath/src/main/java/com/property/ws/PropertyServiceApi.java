package com.property.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.epropertyui.model.BrokerRequest;
import com.epropertyui.model.Registeration;
import com.epropertyui.model.UserRequest;
import com.property.entity.Response;
import com.property.service.impl.GetPropertyServiceImpl;

@Controller
@RequestMapping("/secure")
public class PropertyServiceApi {
	
	@Autowired
	GetPropertyServiceImpl getPropertyService;

	@RequestMapping(value = "/sendBrokerProperty", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public @ResponseBody Response sendBrokerProperty(@RequestBody BrokerRequest request) throws Exception {
		
		System.out.println("Inside Broker");
		getPropertyService.sendBrokerProperty(request);
			
			return null;
		
		}
	
	@RequestMapping(value = "/sendUserProperty", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public @ResponseBody Response sendUserProperty(@RequestBody UserRequest request) throws Exception {

		System.out.println("Inside userPrperty Controller");
		getPropertyService.sendUserProperty(request);
			return null;
		
		}
	

}
