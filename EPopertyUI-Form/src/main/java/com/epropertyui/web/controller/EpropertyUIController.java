package com.epropertyui.web.controller;

import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;

import javax.mail.AuthenticationFailedException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;

import com.epropertyui.constants.ApplicationConstants;
import com.epropertyui.constants.EpropertyConstants;
import com.epropertyui.model.BrokerDto;
import com.epropertyui.model.Deal;
/*import com.epropertyui.model.FileUploadForm;*/
import com.epropertyui.model.Registeration;
import com.epropertyui.model.SearchProperty;
import com.epropertyui.model.UploadForm;
import com.epropertyui.model.UserProperty;
import com.epropertyui.service.EpropertyUIService;
import com.epropertyui.util.CloudinayUtil;
import com.epropertyui.util.EmailUtility;
import com.epropertyui.util.EncryptionUtil;
import com.epropertyui.util.PropertiesReader;
import com.epropertyui.util.Status;

@Controller
public class EpropertyUIController {

	@Autowired
	EpropertyUIService ePropertyUIService;

	private static final Logger logger = Logger
			.getLogger(EpropertyUIController.class);
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public ModelAndView search(){
		ModelAndView model = new ModelAndView();
		model.setViewName("searchProperty");
		return model;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(
			@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {
		logger.info("###################Login()###############################");

		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Invalid username and password!");
		}

		if (logout != null) {
			model.addObject("msg", "You've been logged out successfully.");
		}
		model.setViewName("login");

		return model;

	}
	
	@RequestMapping(value = "/accessdenied", method = RequestMethod.POST)
    public String accessDenied(Locale locale, Model model) 
    {

        model.addAttribute("accessDenied", "Session has been Expired.Please login.");

        return "login";
    }

	protected boolean hasRole(String role) {
		// get security context from thread local
		SecurityContext context = SecurityContextHolder.getContext();
		if (context == null)
			return false;

		Authentication authentication = context.getAuthentication();
		if (authentication == null)
			return false;

		for (GrantedAuthority auth : authentication.getAuthorities()) {
			if (role.equals(auth.getAuthority()))
				return true;
		}

		return false;
	}

	@RequestMapping(value = { "/userOrAdmin" }, method = RequestMethod.GET)
	public ModelAndView userOrAdmin(Authentication authenticate) {
		
		logger.info("###################userOrAdmin()###############################");
		
		ModelAndView model = new ModelAndView();

		// String url=ePropertyUIService.sendUserProperty("hello");

		if (hasRole(EpropertyConstants.ROLE_USER)) {
			logger.info("userRole");
			model.setViewName("shareADeal");
		}
		if (hasRole(EpropertyConstants.ROLE_ADMIN)) {
			logger.info("adminRole");
			model.setViewName("adminPage");
		}
		return model;

	}

	@Secured(value = { "ROLE_ADMIN" })
	@RequestMapping(value = { "/adminProperty" }, method = RequestMethod.GET)
	public ModelAndView adminProperty(
			@ModelAttribute Authentication authentication) {
		
		logger.info("###################adminProperty()###############################");
		
		ModelAndView model = new ModelAndView();

		return model;

	}

	/*
	 * @Secured(value = { "ROLE_USER"})
	 * 
	 * @RequestMapping(value = { "/userProperty" }, method = RequestMethod.GET)
	 * public ModelAndView userProperty(@ModelAttribute UserProperty
	 * UserProperty) { System.out.println("user can access it"); ModelAndView
	 * model = new ModelAndView();
	 * 
	 * return model;
	 * 
	 * }
	 */
	
	@RequestMapping(value = "/submitDeal.html", method = RequestMethod.POST)
	public ModelAndView dealRegistration(@ModelAttribute Deal deal,@ ModelAttribute UploadForm uploadForm, Model map ) {
		
		ModelAndView model = new ModelAndView();
		
		logger.info("###################submit deal()###############################");
		logger.info("Property Registration "+deal.getUrl() + " "
				+ deal.getTopic() + " "
				+ deal.getTitle()+ " " 
				+ deal.getPrice() );
		
		try {
			MultipartFile file = uploadForm.getFile();
			if(null != file ) {
	            String fileName = file.getOriginalFilename();
	            logger.info("FIle name is "+fileName);
			}
			
			// Upload image to cloudinary 
		
			CloudinayUtil.uploadImage(uploadForm);
			deal.setImagePublicId(uploadForm.getPublicId());
			logger.info("Image Public Id "+ deal.getImagePublicId());
			ePropertyUIService.sendDeal(deal);
		} catch (Exception e) {
			logger.error("Exception has occured "+e);
			model.addObject("errMsg1",
					"Internal Server error has occured.Please contact Administrator.");
			model.setViewName("shareADeal");
			return model;
		}
		model.addObject("emailMsg",
				"Property Details has been Sumitted successfully.Thank You.");
		model.setViewName("shareADeal");
		return model;
	}
	 
	 
	 
	 

	@Secured(value = { "ROLE_USER" })
	@RequestMapping(value = "/userPropertyRegistration.html", method = RequestMethod.POST)
	public ModelAndView propertyRegistration(@ModelAttribute UserProperty userProperty,@ ModelAttribute UploadForm uploadForm, Model map ) {
		
		ModelAndView model = new ModelAndView();
		
		logger.info("###################propertyRegistration()###############################");
		logger.info("Property Registration "+userProperty.getPropertyForEx() + " "
				+ userProperty.getPropertyTypeEx() + " "
				+ userProperty.getBhk() + " " 
				+ userProperty.getPrice() + " "
				+ userProperty.getContractPeriod() + " "
				+ userProperty.getSecurityAmount() + " "
				+ userProperty.getHouseNumber() + " "
				+ userProperty.getLocality() + " "
				+ userProperty.getAddress() + " "
				+ userProperty.getPropertyDescription());
		
		try {
			MultipartFile file = uploadForm.getFile();
			if(null != file ) {
	            String fileName = file.getOriginalFilename();
	            logger.info("FIle name is "+fileName);
			}
			
			// Upload image to cloudinary 
		
			CloudinayUtil.uploadImage(uploadForm);
			userProperty.setImagePublicId(uploadForm.getPublicId());
			logger.info("Image Public Id "+ userProperty.getImagePublicId());
			ePropertyUIService.sendUserProperty(userProperty);
		} catch (Exception e) {
			logger.error("Exception has occured "+e);
			model.addObject("errMsg1",
					"Internal Server error has occured.Please contact Administrator.");
			model.setViewName("userPropertyRegistration");
			return model;
		}
		model.addObject("emailMsg",
				"Property Details has been Sumitted successfully.Thank You.");
		model.setViewName("userPropertyRegistration");
		return model;
	}

	@Secured(value = { "ROLE_BROKER" })
	@RequestMapping(value = { "/userProperty" }, method = RequestMethod.GET)
	public ModelAndView brokerProperty(
			@ModelAttribute Authentication authenticate) {
		
		logger.info("###################brokerProperty()###############################");
		
		ModelAndView model = new ModelAndView();

		return model;

	}
	
	@ExceptionHandler(Exception.class)
	  public ModelAndView handleException(Exception ex, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
			if(ex instanceof MaxUploadSizeExceededException) {
				logger.error("Exception has occured "+ ex);
		    	mav.addObject("errMsg1","Max Image Upload Size Exceeded.");
		    	mav.setViewName("userPropertyRegistration");
		}
			return mav;
	
	  }
	
	
	@RequestMapping(value="/searchProperty.html", method=RequestMethod.POST)
	public ModelAndView searchProperty(
			@ModelAttribute SearchProperty searchProperty) {
	        
		logger.info("###################searchProperty()###############################");
		logger.info(searchProperty.getMinPrice()+" "+searchProperty.getMaxPrice());
		ModelAndView model = new ModelAndView();
		
		try {
			List<UserProperty> userPropertyList = ePropertyUIService.searchProperty(searchProperty);
			for(UserProperty userProperty:userPropertyList) {
				logger.info(userProperty.getId()+" "+userProperty.getHouseNumber()+" "+userProperty.getImagePublicId());
			}
			model.addObject("userPropertyList", userPropertyList);
			model.setViewName("searchPropertyResult");
			return model;
		} catch (Exception e) {
			logger.error("Exception has occured "+e);
			model.addObject("error", "Internal Error has occured.Please contact Administrator.");
			model.setViewName("searchProperty");
			return model;	
		}

	}

	@RequestMapping(value = "/page/{pagename}")
	public ModelAndView loadProductPage(ModelMap model,
			@PathVariable("pagename") String pagename) {
		model.addAttribute("productname", pagename);
		return new ModelAndView("/" + pagename);
	}

	@RequestMapping(value = "/sendEmailToRecipient.html", method = RequestMethod.POST)
	public ModelAndView sendEmailToRecipient(
			@ModelAttribute Registeration register, HttpServletRequest request)
			throws Exception {
		
		ModelAndView model = new ModelAndView();
		
		logger.info("Adding User " + register.getFullName());
		register=polpulateRegisteration(register);
		ePropertyUIService.addUser(register);
		
		String recipient = register.getUserName();
		String host = PropertiesReader.getPropertyValue(
				ApplicationConstants.EMAIL_SEND_HOST).trim();
		String port = PropertiesReader.getPropertyValue(
				ApplicationConstants.EMAIL_SEND_PORT).trim();
		String user = PropertiesReader.getPropertyValue(
				ApplicationConstants.EMAIL_SEND_USER).trim();
		String pass = PropertiesReader.getPropertyValue(
				ApplicationConstants.EMAIL_SEND_PASS).trim();

		String subject = "EProperty Email Verification mail";

		String content = request.getScheme() + "://" + request.getServerName() + ":"
				+ request.getServerPort() + request.getContextPath() + "/"
				+ "verifyEmail/" + register.getvTokenString();

		logger.info("Content for Email Address " + content);
		@SuppressWarnings("unused")
		String resultMessage = "";
		try {
			request.setCharacterEncoding("UTF-8");
			EmailUtility.sendEmail(host, port, user, pass, recipient, subject,
					content);
			resultMessage = "The e-mail was sent successfully";
			logger.info("The e-mail was sent successfully");
		} catch(AuthenticationFailedException ex){
			logger.error("Exception has occured "+ex);
			model.addObject("error", "Unable to send email. Please contact Administrator");
			model.setViewName("login");
			return model;
		}catch (Exception ex) {
			logger.error("Exception has occured "+ex);
			model.addObject("error", "Internal Error has occured.Please contact Administrator.");
			model.setViewName("login");
			return model;
		} 
		logger.info("Email has been sucessfull sent.Kindly verify to activate the account.");
		model.addObject("emailSentMsg",
				"Email has been sucessfull sent.Kindly verify to activate the account.");
		model.setViewName("login");
		return model;
	}
	
	private Registeration polpulateRegisteration(Registeration register ) {
		
		logger.info("Inside polpulateRegisteration() email id is " + register.getUserName());
		String enkey = EncryptionUtil.Encode(register.getEnKey());
		
		String verifyToken;
		
		 //generate Base64 based verification Token 
		
		verifyToken = UUID.randomUUID().toString();
		register.setEnKey(enkey);
		register.setType("User");
		register.setActive("N");
		register.setvTokenString(verifyToken);
		register.setCreatedDate(new Date().toString());
		register.setCreatedUser("appUser");
		register.setRole(EpropertyConstants.ROLE_USER);
		
		return register;
	}
	

	@RequestMapping(value = "/verifyEmail/{token}", method = RequestMethod.GET)
	public ModelAndView verifyEmail(@PathVariable("token") String token) {
		logger.info("Inside Verify Email for Token " + token);
		ModelAndView model = new ModelAndView();
		try {
			ePropertyUIService.verifyToken(token);
		} catch (Exception e) {
			logger.error("Exception has occured "+e);
			model.addObject("error", "Internal Error has occured.Please contact Administrator.");
			model.setViewName("login");
			return model;
		}

		logger.info("Email has been verified sucessfully " + token);
		model.addObject("", "Email has been sucessfully verified.");
		model.setViewName("login");
		return model;

	}
		@RequestMapping(value = "/createbroker.html", method = RequestMethod.POST)
	public ModelAndView createBroker(@ModelAttribute BrokerDto brokerDto,
			HttpServletRequest request) throws Exception {
		ModelAndView model = new ModelAndView();
		System.out.println("email id is " + brokerDto.getUserName());
		String enkey = EncryptionUtil.Encode(brokerDto.getEnKey());

		brokerDto.setEnKey(enkey);
		brokerDto.setType("User");
		brokerDto.setActiveStatus(true);
		brokerDto.setCreatedTym(System.currentTimeMillis());
		brokerDto.setRole(EpropertyConstants.ROLE_BROKER);
		ePropertyUIService.createBroker(brokerDto);
		model.addObject("successMsg",
				"Broker has been sucessfully Registered !");
		model.setViewName("createbroker");
		return model;
	}
		
		/*@RequestMapping(value = "/viewbrokers", method = RequestMethod.GET, produces = "application/json")
		public @ResponseBody List<BrokerDto> viewBrokers() throws Exception {

			return ePropertyUIService.viewBrokers();
		}*/

		
		
		@RequestMapping(value="/viewBrokers.html", method=RequestMethod.GET)
		public ModelAndView viewBrokers() {
		        
			logger.info("###################viewBroker()###############################");
			
			ModelAndView model = new ModelAndView();
			
			try {
				List<BrokerDto> brokerDtos =ePropertyUIService.viewBrokers();
				for(BrokerDto brokerDto:brokerDtos) {
					logger.info(brokerDto.getUserName()+" "+brokerDto.getBrokerId());
				}
				model.addObject("brokerDtos", brokerDtos);
				model.setViewName("ShowBrokerResult");
				return model;
			} catch (Exception e) {
				logger.error("Exception has occured "+ e);
				model.addObject("error", "Internal Error has occured.Please contact Administrator.");
				model.setViewName("adminLandingPage");
				return model;	
			}

		}
		
		@Secured(value = { "ROLE_ADMIN" })
		@RequestMapping(value="/viewUsers.html", method=RequestMethod.GET)
		public ModelAndView viewUsers() {
		        
			logger.info("###################viewUsers()###############################");
			
			ModelAndView model = new ModelAndView();
			
			try {
				List<UserProperty> userProperties =ePropertyUIService.viewUsers();
				for(UserProperty userProperty:userProperties) {
					logger.info(userProperty.getId()+" "+userProperty.getAddress());
				}
				model.addObject("userProperties", userProperties);
				model.setViewName("showUserResult");
				return model;
			} catch (Exception e) {
				logger.error("Exception has occured "+e);
				model.addObject("error", "Internal Error has occured.Please contact Administrator.");
				model.setViewName("adminLandingPage");
				return model;	
			}

		}
		
		@RequestMapping(value="/approvePost.html/{id}", method=RequestMethod.GET, produces="text/plain")
		public @ResponseBody String approvePost(@PathVariable("id")String id) {
			logger.info("Inside Approve post");
			logger.info("Id to Approve Post is "+id);
			try {
				ePropertyUIService.updatePropertyStatus(id,Status.APPROVED);
				
			} catch (Exception e) {
				logger.error("Error has occured in approving the request "+ e);
			}
			return EpropertyConstants.USER_PROPERTY_APPROVED;
			
		}
		
		@RequestMapping(value="/rejectPost.html/{id}", method=RequestMethod.GET, produces="text/plain")
		public @ResponseBody String rejectPost(@PathVariable("id")String id) {
			logger.info("Id to Approve Post is "+id);
			try {
				ePropertyUIService.updatePropertyStatus(id,Status.REJECTED);
				
			} catch (Exception e) {
				logger.error("Error has occured in approving the request "+ e);
			}
			
			return EpropertyConstants.USER_PROPERTY_REJECTED;
			
		}
	
		@Secured(value = { "ROLE_USER" })
		@RequestMapping(value="/viewPropertyByUser.html", method=RequestMethod.GET)
		public @ResponseBody String viewPropertyByUser() {
		        
			logger.info("###################viewPropertyByUser()###############################");
			
			ModelAndView model = new ModelAndView();
			/*Map<String, UserProperty> userPropertyMap=null;*/
			List<UserProperty> userPropertyList=null;
			String jsonProperty="";
			
			try {
				userPropertyList =ePropertyUIService.viewPropertyByUser();
				/*for(Map.Entry<String, UserProperty> userProperty : userPropertyMap.entrySet()) {
					logger.info(userProperty.getKey());
				}
				*/
				ObjectMapper mapper = new ObjectMapper();
				jsonProperty = "";
		        	jsonProperty = mapper.writeValueAsString(userPropertyList);
		        	System.out.println(jsonProperty);
		        
			 } catch (JsonProcessingException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
		        catch (Exception e) {
				logger.error("Exception has occured "+e);
				model.addObject("error", "Internal Error has occured.Please contact Administrator.");
				model.setViewName("userPropertyRegistration");
				
			}
			return jsonProperty;
		}
		
}