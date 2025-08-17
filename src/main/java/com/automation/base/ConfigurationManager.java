package com.automation.base;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.automation.enums.BrowserType;



public class ConfigurationManager {
	public static Properties  properties = new Properties();
	static String propertyFile = System.getProperty("user.dir")+"/config.properties";
	

	

	public ConfigurationManager() {
		System.out.println("path is"+propertyFile);
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFile));
			
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("configuration.properties not found at " + propertyFile);
		}
	}
	
	 public static String getProperty(String key) {
		 new ConfigurationManager(); 
	        return properties.getProperty(key);
	    }

	
	
	
	public static  BrowserType getBrowser(String xmlBrowser) {
		
	String browser=null;
	    if (xmlBrowser != null && !xmlBrowser.isEmpty()) {
	     browser=xmlBrowser;  
	    }

	    
	    else if (System.getProperty("browser") != null) {
	    	String sysPropBrowser = System.getProperty("browser");
	        browser= sysPropBrowser;  
	    }

	    else {
	    	
	   
	    	browser= ConfigurationManager.getProperty("browser"); 
	    }
	    try {
	        return BrowserType.valueOf(browser.toUpperCase());
	    } catch (IllegalArgumentException e) {
	        throw new RuntimeException("Please provide valid browser value from configuration.properties file, accepted browser are: chrome, firefox, IE:"+browser);
	    }
	}}


