package com.property.testcase;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.epropertyui.model.BrokerRequest;
import com.property.util.EncryptionUtil;

public class TestCase {

	
	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();

		//JSON from file to Object
		try {
			BrokerRequest user = mapper.readValue(new File("c:\\user.json"), BrokerRequest.class);
		System.out.println(user.getNetwork());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//JSON from String to Object
	}

}
