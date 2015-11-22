package com.property.util;


import java.io.InputStream;
import java.util.MissingResourceException;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.property.constants.ApplicationConstants;

public class PropertiesReader {

    private static Properties properties;
    private static Logger logger = Logger.getLogger(PropertiesReader.class);

    static {
        initializePropertiesReader(ApplicationConstants.APPLICATION_PROPERTIES_FILE_NAME);
    }

    private static void initializePropertiesReader(String fileName) {
        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
        try {
            if (inputStream != null) {
                properties = new Properties();
                properties.load(inputStream);
            } else {
                logger.error("Properties file :" + fileName + " not found.");
            }
        } catch (Exception e) {
            logger.error("Error occured while initializing properties file = " + fileName, e);
        }
    }

    public static String getPropertyValue(String propertyName) throws Exception {
        if (properties == null) {
            throw new Exception("Error occured in initializing properties file = " + ApplicationConstants.APPLICATION_PROPERTIES_FILE_NAME);
        }
        String propertyValue = null;
        try {
            propertyValue = properties.getProperty(propertyName);
        } catch (MissingResourceException e) {
            logger.error("No property found for key = " + propertyName, e);
            throw e;
        } catch (Exception e) {
            logger.error("Exception occured in fetching property having key = " + propertyName, e);
            throw e;
        }
        return propertyValue;
    }
}