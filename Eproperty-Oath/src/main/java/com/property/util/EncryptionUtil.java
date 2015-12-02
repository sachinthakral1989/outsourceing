package com.property.util;

import org.apache.commons.codec.binary.Base64;
public class EncryptionUtil {
	
	public static String Encode(String orig) {
		
		byte[] encoded = Base64.encodeBase64(orig.getBytes());     
        return new String(encoded);
	}
	
public static String Decode(String enkey) {
		
	byte[] decoded = Base64.decodeBase64(enkey);      
    return new String(decoded);

	}

}
