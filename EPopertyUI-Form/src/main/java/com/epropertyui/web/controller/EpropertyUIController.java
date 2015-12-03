package com.epropertyui.web.controller;



import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.epropertyui.constants.ApplicationConstants;
import com.epropertyui.constants.EpropertyConstants;
import com.epropertyui.model.Registeration;
import com.epropertyui.model.UserProperty;
import com.epropertyui.service.EpropertyUIService;
import com.epropertyui.util.EmailUtility;
import com.epropertyui.util.EncryptionUtil;
import com.epropertyui.util.PropertiesReader;

@Controller
public class EpropertyUIController {
	
	@Autowired
	EpropertyUIService ePropertyUIService;
	
	@RequestMapping(value = { "/", "/login" }, method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {

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
	

	@RequestMapping(value = {  "/userOrAdmin" }, method = RequestMethod.GET)
	public ModelAndView userOrAdmin(Authentication authenticate) {
		ModelAndView model = new ModelAndView();
		
		//String url=ePropertyUIService.sendUserProperty("hello");
		
		if (hasRole(EpropertyConstants.ROLE_USER)) {
			System.out.println("userRole");
		model.setViewName("userProperty");
		} if (hasRole(EpropertyConstants.ROLE_ADMIN)) {
			System.out.println("adminRole");
			model.setViewName("adminProperty");
		}
		return model;

	}
	@Secured(value = { "ROLE_ADMIN" })
	@RequestMapping(value = {  "/adminProperty" }, method = RequestMethod.GET)
	public ModelAndView adminProperty(@ModelAttribute Authentication authentication) {
		ModelAndView model = new ModelAndView();
		
		return model;

	}
	@Secured(value = { "ROLE_USER"})
	@RequestMapping(value = {  "/userProperty" }, method = RequestMethod.GET)
	public ModelAndView userProperty(@ModelAttribute UserProperty UserProperty) {
		System.out.println("user can access it");
		ModelAndView model = new ModelAndView();
		
		return model;

	}
	
	@Secured(value = { "ROLE_BROKER" })
	@RequestMapping(value = {  "/userProperty" }, method = RequestMethod.GET)
	public ModelAndView brokerProperty(@ModelAttribute Authentication authenticate) {
		ModelAndView model = new ModelAndView();
		
		return model;

	}

	@RequestMapping(value="/page/{pagename}")
	public ModelAndView loadProductPage(ModelMap model, @PathVariable("pagename") String pagename) {
	    model.addAttribute("productname",pagename);
	    return new ModelAndView("/"+pagename);
	}
	
	@RequestMapping(value = "/sendEmailToRecipient.html", method = RequestMethod.POST)  
	  public ModelAndView sendEmailToRecipient( @ModelAttribute Registeration register,HttpServletRequest request) throws Exception {  
		ModelAndView model = new ModelAndView();
		System.out.println("email id is "+register.getUserName() );
	    String enkey = EncryptionUtil.Encode(register.getEnKey());
	    String recipient= register.getUserName(); 
	    String host = PropertiesReader.getPropertyValue(ApplicationConstants.EMAIL_SEND_HOST).trim();
	    String port = PropertiesReader.getPropertyValue(ApplicationConstants.EMAIL_SEND_PORT).trim();
	    String user = PropertiesReader.getPropertyValue(ApplicationConstants.EMAIL_SEND_USER).trim();
	    String pass =PropertiesReader.getPropertyValue(ApplicationConstants.EMAIL_SEND_PASS).trim();
	    
	    String subject = "EProperty Email Verification mail";
	    String content;
			//generate a 6 digit integer 1000 <10000
			int randomPIN = (int)(Math.random()*900000)+100000;
			//Store integer in a string
			content= String.valueOf(randomPIN);
			register.setEnKey(enkey);
			register.setType("User");
			register.setActive("N");
			register.setvTokenString(content);
			register.setCreatedDate(new Date().toString());
			register.setCreatedUser("appUser");
			register.setRole(EpropertyConstants.ROLE_USER);
			ePropertyUIService.addUser(register);
			
			content=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath()+"/"+"verifyEmail/"+content;

			System.out.println("Content for Email Addres "+ content);
			System.out.println("Content for Email Addres ");
			String resultMessage = "";
			try {
				System.out.println("Content for Email Addres ");
			request.setCharacterEncoding("UTF-8");
			EmailUtility.sendEmail(host, port, user, pass, recipient, subject,
						content);
				resultMessage = "The e-mail was sent successfully";
			} catch (Exception ex) {
				ex.printStackTrace();
				resultMessage = "There were an error: " + ex.getMessage();
			} finally {
				//request.setAttribute("message", resultMessage);
			}   model.addObject("emailSentMsg", "Email has been sucessfull sent.Kindly verify to activate the account.");
				model.setViewName("login");  
				return model;
	   }  
	
		@RequestMapping(value = "/verifyEmail/{token}", method = RequestMethod.GET)
		public ModelAndView verifyEmail(@PathVariable("token") String token) {
			ePropertyUIService.verifyToken(token);
			
		System.out.println("Email has been verified sucessfully "+ token);
		ModelAndView model = new ModelAndView();
		model.addObject("verifyMsg", "Email has been sucessfully verified." );
		model.setViewName("login");
		return model;

	}
	  

}