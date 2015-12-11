package com.property.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.epropertyui.model.BrokerRequest;
import com.gl.poc.couchbase.dto.BrokerDto;
import com.property.entity.Response;
import com.property.entity.UserProperty;
import com.property.entity.UserPropertyDTO;
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
	public @ResponseBody Response sendUserProperty(@RequestBody UserProperty userProperty) throws Exception {

		System.out.println("Inside userPrperty Controller");
		
		getPropertyService.sendUserProperty(userProperty);
			return null;
		
		}
	
	/*@RequestMapping(value ="/viewBrokerDetails",method = RequestMethod.POST,produces = "application/json", consumes = "application/json")
	public @ResponseBody boolean viewBrokerDetails (@RequestBody Request request) throws Exception{
		return false;
		
	}*/

	@RequestMapping(value ="/createBroker", method= RequestMethod.POST, produces="application/json", consumes="application/json")
		public @ResponseBody boolean createBroker(@RequestBody BrokerDto brokerDto) throws Exception{
			
			return getPropertyService.createBroker(brokerDto);
		
	}

	@RequestMapping(value = "/viewbrokers", method = RequestMethod.GET, produces = "application/json")
		public @ResponseBody List<BrokerDto> viewBrokers() throws Exception {

			return getPropertyService.viewBrokers();
		}

	@RequestMapping(value = "/viewbroker/{brokerId}", method = RequestMethod.GET, produces = "application/json")
		public @ResponseBody BrokerDto viewBroker(@PathVariable String brokerId)
				throws Exception {

			return getPropertyService.viewBroker(brokerId.trim());

	}
@RequestMapping(value ="/updateBroker", method= RequestMethod.POST, produces="application/json", consumes="application/json")
public @ResponseBody boolean updateBroker(@RequestBody BrokerDto brokerDto) throws Exception{
	
	return getPropertyService.updateBroker(brokerDto);

}

@RequestMapping(value ="/updateUserProperty", method= RequestMethod.POST, produces="application/json", consumes="application/json")
public @ResponseBody boolean updateUserProperty(@RequestBody UserPropertyDTO userPropertyDTO) throws Exception{
	
	return getPropertyService.updateUserProperty(userPropertyDTO);

}

@RequestMapping(value = "/viewUserProperties", method = RequestMethod.GET, produces = "application/json")
public @ResponseBody List<UserPropertyDTO> viewUsers() throws Exception {

	return getPropertyService.viewUserProperties();
}

}
