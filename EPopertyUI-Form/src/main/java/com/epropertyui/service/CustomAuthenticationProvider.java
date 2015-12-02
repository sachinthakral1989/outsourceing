package com.epropertyui.service;
import java.util.Collection;
import javax.servlet.http.HttpSession;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;
import com.epropertyui.model.User;
 
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
 
    
	private EpropertyUIService epropertyUIService;
 

	public void setEpropertyUIService(
			EpropertyUIService epropertyUIService) {
		this.epropertyUIService = epropertyUIService;
	}
	
	
	@Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = (String) authentication.getCredentials();
        
        User user = epropertyUIService.loadUserByUsername(username);
 
        if (user == null) {
            throw new BadCredentialsException("Username not found.");
        }
 
        if (!password.equals(user.getPassword())) {
            throw new BadCredentialsException("Wrong password.");
        }
        HttpSession session=epropertyUIService.getSession();
        String accessToken=epropertyUIService.getAuthenticatedToken().getAccess_token();
        //Place the usernam eand access Token in session 
        session.setAttribute("username", user.getUsername());
        session.setAttribute("accessToken", accessToken);
        session.setMaxInactiveInterval(10*60);
        System.out.println("username and Access Token is "+username + accessToken);
        
        Collection<? extends GrantedAuthority> authorities = user.getAuthorities();
        
        return new UsernamePasswordAuthenticationToken(user, password, authorities);
    }
 
    @Override
    public boolean supports(Class<?> arg0) {
        return true;
    }
}