package com.automation.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;

import com.automation.enums.BrowserType;

public class DriverManager {

	
	public static ThreadLocal<WebDriver> thdriver = new ThreadLocal<>();

	public static WebDriver getDriver() {
		return thdriver.get();
	}

	public static void setDriver(WebDriver driverInstance) {
		thdriver.set(driverInstance);
	}

	public static void unload() {
		thdriver.remove();
	}
	
	

	public  WebDriver createInstace(BrowserType browser) {
		  WebDriver driver;
	    	  switch (browser) {	    
	          case FIREFOX : 
	          	FirefoxOptions firefoxOptions=new FirefoxOptions();
	          	firefoxOptions.setAcceptInsecureCerts(true);
	          	firefoxOptions.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
	          	firefoxOptions.addArguments("use-fake-ui-for-media-stream");
	          	//firefoxOptions.addPreference("permissions.default.microphone", 1);
	          	//firefoxOptions.addPreference("permissions.default.camera", 1);
	          	firefoxOptions.addPreference("media.navigator.permission.disabled",true); 
	          
	          	driver = new FirefoxDriver(firefoxOptions);
	  	    	break;
	          case CHROME : 
	        
	          	ChromeOptions options = new ChromeOptions();
	          	options.setAcceptInsecureCerts(true);
	              options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
	           
	              
	              //// Automatically allow mic/camera
	              options.addArguments("use-fake-ui-for-media-stream");
//	              options.addArguments("test");
	              //below lines from 55 to 60 is for headless browser support 
//	              options.addArguments("--headless");
//	              options.addArguments("--disable-gpu");
//	              options.addArguments("--disable-extensions");
//	              options.addArguments("--no-sandbox");
//	              options.addArguments("--disable-dev-shm-usage");
//	              options.addArguments("--window-size=1580,1280");
	          	driver = new ChromeDriver(options);
	          	
	      		break;
	          case INTERNETEXPLORER : 
	          	
	          	driver = new InternetExplorerDriver();
	      		break;
	      		
	  		default:
	  		
	          	driver = new ChromeDriver();
	          	break;
	    }
	    	  return driver;
	}
	


public WebDriver getDriverInstance(BrowserType browser) {
	
	WebDriver	driver=		createInstace( browser);
	
	return driver;
}

public static void quit() {
	if(thdriver.get()!=null) {
		thdriver.get().quit();
		unload();
	}
}




}