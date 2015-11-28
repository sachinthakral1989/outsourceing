package com.epropertyui.service;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

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
}