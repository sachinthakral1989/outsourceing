package com.epropertyui.util;
import java.io.InputStream;
import java.util.MissingResourceException;
import java.util.Properties;



import com.epropertyui.constants.ApplicationConstants;



public class PropertiesReader {

    private static Properties properties;

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
            }
        } catch (Exception e) {
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
            throw e;
        } catch (Exception e) {
            throw e;
        }
        return propertyValue;
    }
}