package com.property.ws;


import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.web.bind.annotation.RequestBody;



@Path("")
public interface PropertyServiceApi {
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	@Path("/authenticateUser")
	public void authenticateUser(String userName,String Password) throws Exception;
	
	@POST
	@Produces({MediaType.TEXT_PLAIN,MediaType.APPLICATION_JSON})
	@Path("/sendProperty")
	public void sendPropertyCall(@RequestBody Request properyInfo) throws Exception;

	
	
}

