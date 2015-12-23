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
import com.gl.poc.couchbase.dto.CategoryDto;
import com.gl.poc.couchbase.dto.LandingScreenDetailDTO;
import com.gl.poc.couchbase.dto.PaginationDto;
//import com.gl.poc.couchbase.response.GetProductByLimitResponse;
import com.property.entity.AdminDto;
import com.property.entity.BrokerDto;
import com.property.entity.GetProductByLimitResponse;
import com.property.entity.Response;
import com.property.entity.SearchProperty;
import com.property.entity.UserProperty;
import com.property.entity.UserPropertyDTO;
import com.property.service.impl.GetPropertyServiceImpl;
import com.property.util.JsonUtil;




@Controller
@RequestMapping("/api")
public class RestServiceApi {
	
	private static final Logger logger = Logger.getLogger(RestServiceApi.class);

	
	@Autowired
	GetPropertyServiceImpl getPropertyService;
	
	
	public LandingScreenDetailDTO getAllCategories() throws Exception {
		LandingScreenDetailDTO landingScreenDetailDTO = new LandingScreenDetailDTO();
		List<CategoryDto> categoriesDto = getPropertyService.getAllCategories();
		landingScreenDetailDTO.getCategoryList().addAll(categoriesDto);
		return landingScreenDetailDTO;
	}
	
	@RequestMapping(value = "/getProductsByLimit/{category}/{offset}/{limit}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody GetProductByLimitResponse getProductsByLimit(@PathVariable String category,
			@PathVariable int offset, @PathVariable int limit) throws Exception {
		PaginationDto pagination = new PaginationDto();
		pagination.setOffset(offset);
		pagination.setLimit(limit);
		GetProductByLimitResponse response = getPropertyService
				.getProductsByLimit(category, pagination);
		//String sResponse = JsonUtil.marshal(response);
		return response;
	}
  

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

@RequestMapping(value = "/createadmin", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public @ResponseBody boolean createAdmin(@RequestBody AdminDto adminDto)
			throws Exception {
		return getPropertyService.createAdmin(adminDto);

	}

	@RequestMapping(value = "/createbroker", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public @ResponseBody boolean createBroker(@RequestBody BrokerDto brokerDto)
			throws Exception {

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

	@RequestMapping(value = "/updatebroker", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public @ResponseBody boolean updateBroker(@RequestBody BrokerDto brokerDto)
			throws Exception {

		return getPropertyService.updateBroker(brokerDto);

	}
	
}
