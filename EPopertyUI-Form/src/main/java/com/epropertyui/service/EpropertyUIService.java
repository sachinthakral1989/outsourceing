package com.epropertyui.service;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.epropertyui.model.Registeration;
import com.epropertyui.model.Token;
import com.epropertyui.model.User;
import com.epropertyui.model.UserProperty;
 

 
@Service
public class EpropertyUIService implements UserDetailsService {
 
	private static final Logger logger = Logger.getLogger(EpropertyUIService.class);
   
    private EpropertyUIDao epropertyUIDao;
 
    public void setEpropertyUIDao(EpropertyUIDao epropertyUIDao) {
		this.epropertyUIDao = epropertyUIDao;
	}


	@Override
    public User loadUserByUsername(final String username) throws UsernameNotFoundException {
		logger.info("Inside loadUserByUsername "+username);
        return epropertyUIDao.loadUserByUsername(username);
    }
	
	public boolean addUser(Registeration register) throws Exception {
		logger.info("Inside addUser "+ register.getFullName());
		return epropertyUIDao.addUser(register);
		
	}
	
	public String sendUserProperty(UserProperty userProperty) throws Exception {
		logger.info("Inside sendUserProperty "+userProperty.getPropertyForEx());
		return epropertyUIDao.sendUserProperty(userProperty);
	}
	
	public Token getAuthenticatedToken() throws Exception {
		logger.info("Inside getAuthenticatedToken ");
		 return epropertyUIDao.getAuthenticatedToken();
		
	}
	
	public String verifyToken(String token) throws Exception {
		logger.info("Inside verifyToken");
		return epropertyUIDao.verifyToken(token);
		
	}
	public HttpSession getSession() {
		return epropertyUIDao.getSession();
	}
}