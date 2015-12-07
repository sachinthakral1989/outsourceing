package com.epropertyui.util;

import java.io.IOException;
import java.util.Map;

import org.apache.log4j.Logger;

import com.cloudinary.Singleton;
import com.cloudinary.utils.ObjectUtils;
import com.epropertyui.model.UploadForm;

public class CloudinayUtil {
	
	private static final Logger logger = Logger.getLogger(CloudinayUtil.class);
	
	public static boolean uploadImage(UploadForm uploadForm) throws Exception {
		
		boolean isUploaded;
		Map uploadResult=null;
		
        try {
			uploadResult = Singleton.getCloudinary().uploader().upload(uploadForm.getFile().getBytes(),
			         ObjectUtils.asMap("resource_type", "auto"));
		
        uploadForm.setPublicId((String) uploadResult.get("public_id"));
        Object version = uploadResult.get("version");
        if (version instanceof Integer) {
       	 uploadForm.setVersion(new Long((Integer) version));    
        } else {
       	 uploadForm.setVersion((Long) version);
        }
        
        uploadForm.setSignature((String) uploadResult.get("signature"));
        uploadForm.setFormat((String) uploadResult.get("format"));
        uploadForm.setResourceType((String) uploadResult.get("resource_type"));
        
        
        logger.info(uploadForm.getFormat());
        logger.info(uploadForm.getPublicId());
        logger.info(uploadForm.getSignature());
        logger.info(uploadForm.getResourceType());
        } catch (Exception ex) {
        	logger.error("Exception has occured while uplaoding image");
        	throw new Exception(ex);
			
		}
        isUploaded=true;
		
        return isUploaded;
	}

}
