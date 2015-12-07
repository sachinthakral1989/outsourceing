package com.epropertyui.service;
import java.util.Collection;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;
import com.epropertyui.model.User;
import com.epropertyui.web.controller.EpropertyUIController;
 
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
 
	private static final Logger logger = Logger.getLogger(CustomAuthenticationProvider.class);
	
	private EpropertyUIService epropertyUIService;
 

	public void setEpropertyUIService(
			EpropertyUIService epropertyUIService) {
		this.epropertyUIService = epropertyUIService;
	}
	
	
	@Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		logger.info("<<<<<<<<<<<inside Authenticate>>>>>>>>>>>");
        String username = authentication.getName();
        String password = (String) authentication.getCredentials();
        String accessToken="";
        
        User user = epropertyUIService.loadUserByUsername(username);
 
        if (user == null) {
        	logger.info("Username not found.");
            throw new BadCredentialsException("Username not found.");
        }
 
        if (!password.equals(user.getPassword())) {
        	logger.info("Wrong password.");
            throw new BadCredentialsException("Wrong password.");
        }
        HttpSession session=epropertyUIService.getSession();
		try {
			accessToken = epropertyUIService.getAuthenticatedToken().getAccess_token();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        //Place the usernam eand access Token in session 
        session.setAttribute("username", user.getUsername());
        session.setAttribute("accessToken", accessToken);
        session.setMaxInactiveInterval(10*60);
        logger.info("username and Access Token is "+username + accessToken+user.getAuthorities());
        
        Collection<? extends GrantedAuthority> authorities = user.getAuthorities();
        /*authorities.add(new GrantedAuthorityImpl('ROLE_NEWROLE'));*/
        
        return new UsernamePasswordAuthenticationToken(user, password, authorities);
    }
 
    @Override
    public boolean supports(Class<?> arg0) {
        return true;
    }
}