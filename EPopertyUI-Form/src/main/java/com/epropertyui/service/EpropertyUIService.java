package com.epropertyui.service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.epropertyui.client.EpropertyClient;
import com.epropertyui.model.BrokerDto;
import com.epropertyui.model.Deal;
import com.epropertyui.model.Registeration;
import com.epropertyui.model.SearchProperty;
import com.epropertyui.model.Token;
import com.epropertyui.model.UpdateStatus;
import com.epropertyui.model.User;
import com.epropertyui.model.UserProperty;
import com.epropertyui.util.Status;

 
@Service
public class EpropertyUIService implements UserDetailsService {
 
	private static final Logger logger = Logger.getLogger(EpropertyUIService.class);
   
    private EpropertyClient epropertyClient;
 


	public void setEpropertyClient(EpropertyClient epropertyClient) {
		this.epropertyClient = epropertyClient;
	}

	@Override
    public User loadUserByUsername(final String username) throws UsernameNotFoundException {
		logger.info("Inside loadUserByUsername "+username);
        return epropertyClient.loadUserByUsername(username);
    }
	
	public boolean addUser(Registeration register) throws Exception {
		logger.info("Inside addUser "+ register.getFullName());
		return epropertyClient.addUser(register);
		
	}
	
	public String sendUserProperty(UserProperty userProperty) throws Exception {
		logger.info("Inside sendUserProperty "+userProperty.getPropertyForEx());
		if(userProperty.getPropertyForEx().equals("Rent")) {
			userProperty.setPropertyTypeEx("House");
		}
		return epropertyClient.sendUserProperty(userProperty);
	}
	
	//Share a Deal
	public String sendDeal(Deal deal) throws Exception {
		logger.info("Inside sendDeal "+deal.getTitle());
		
		return epropertyClient.sendDeal(deal);
	}
	
	
	
	
	public Token getAuthenticatedToken() throws Exception {
		logger.info("Inside getAuthenticatedToken ");
		 return epropertyClient.getAuthenticatedToken();
		
	}
	
	public String verifyToken(String token) throws Exception {
		logger.info("Inside verifyToken");
		return epropertyClient.verifyToken(token);
		
	}
	public HttpSession getSession() {
		return epropertyClient.getSession();
	}

	public List<UserProperty> searchProperty(SearchProperty searchProperty) throws Exception {
		logger.info("Inside searchProperty "+searchProperty.getPropertySearchFor());
		if(searchProperty.getPropertySearchFor().equals("Rent")) {
			searchProperty.setPropertySearchType("House");
		}
		return epropertyClient.searchProperty(searchProperty);
	}

	public boolean createBroker(BrokerDto brokerDto) throws Exception {
		return epropertyClient.createBroker(brokerDto);
	}

	public List<BrokerDto> viewBrokers() {
		logger.info("Inside viewBroker()...");
		return epropertyClient.viewBrokers();
	}
	
	public List<UserProperty> viewUsers() {
		return epropertyClient.viewUsersProperties();
	}
	
	/*public Map<String, UserProperty> viewPropertyByUser() {
		logger.info("Inside viewPropertyByUser()");
		List<UserProperty> userPropertyList = epropertyClient.viewPropertyByUser();
		Map<String, UserProperty> userPropertyMap = new HashMap<String, UserProperty>();
		for(UserProperty userProperty : userPropertyList){
			userPropertyMap.put(userProperty.getId(), userProperty);
		}
		return userPropertyMap;
	}*/
	public List<UserProperty> viewPropertyByUser() {
		logger.info("Inside viewPropertyByUser()");
		List<UserProperty> userPropertyList = epropertyClient.viewPropertyByUser();
		Map<String, UserProperty> userPropertyMap = new HashMap<String, UserProperty>();
		for(UserProperty userProperty : userPropertyList){
			userPropertyMap.put(userProperty.getId(), userProperty);
		}
		return userPropertyList;
	}
	
    public boolean updatePropertyStatus(String id,Status status) throws Exception {
		logger.info("Inside updatePropertyStatus "+ id);
		UpdateStatus updateStatus =new UpdateStatus();
		updateStatus.setDocumentId(id);
		updateStatus.setStatus(status.toString());
		//updateStatus.setReason("REJECTED By Admin");
        return epropertyClient.updatePropertyStatus(updateStatus);
    }
}