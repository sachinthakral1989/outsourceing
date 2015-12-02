package com.epropertyui.service;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.epropertyui.model.Registeration;
import com.epropertyui.model.Token;
import com.epropertyui.model.User;
 

 
@Service
public class EpropertyUIService implements UserDetailsService {
 
   
    private EpropertyUIDao epropertyUIDao;
 
    public void setEpropertyUIDao(EpropertyUIDao epropertyUIDao) {
		this.epropertyUIDao = epropertyUIDao;
	}


	@Override
    public User loadUserByUsername(final String username) throws UsernameNotFoundException {
        return epropertyUIDao.loadUserByUsername(username);
    }
	
	public boolean addUser(Registeration register) {
		System.out.println("Inside addUser ");
		return epropertyUIDao.addUser(register);
		
	}
	
	public String sendUserProperty(String property) {
		return epropertyUIDao.sendUserProperty(property);
	}
	
	public Token getAuthenticatedToken() {
		 return epropertyUIDao.getAuthenticatedToken();
		
	}
	public HttpSession getSession() {
		return epropertyUIDao.getSession();
	}
}