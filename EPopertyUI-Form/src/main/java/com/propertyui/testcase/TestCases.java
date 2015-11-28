/*package com.propertyui.testcase;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.couchbase.client.CouchbaseClient;
import com.epropertyui.model.UserDTO;
import com.epropertyui.service.EpropertyUIDao;

public class TestCases {

	@Test
	public void authenticateUser() throws URISyntaxException {

		EpropertyUIDao getRetailServiceImpl = new EpropertyUIDao();

		try {
			List<URI> connectionURIs = new ArrayList<URI>();
			URI uri=new URI("http://127.0.0.1:8091/pools");
			connectionURIs.add(uri);
			CouchbaseClient couchbaseClient = new CouchbaseClient(connectionURIs, "default", null);
			System.out.println(couchbaseClient);
			
			UserDTO userDto = getRetailServiceImpl.authenticateUser(
					"sachinthakral1989@gmail.com".trim());
			System.out.println(userDto.getUsername());
			System.out.println(userDto.getPassword());
			System.out.println(userDto.getRole());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
*/