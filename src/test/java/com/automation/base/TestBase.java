package com.automation.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.automation.enums.BrowserType;
import com.automation.utils.CommonUtils;


public class TestBase {
	public WebDriver driver;
	protected DriverManager driverManager= new DriverManager();
	

@Parameters("browserName")
@BeforeMethod( alwaysRun=true)
	public void setup(@Optional("") String browserName) {
	
	BrowserType browser=		ConfigurationManager.getBrowser(browserName);
	driver=driverManager.getDriverInstance(browser);
	driverManager.setDriver(driver);
	driverManager.getDriver().get(ConfigurationManager.properties.getProperty("url"));
		
	}


@AfterMethod(alwaysRun=true)
public void quit() {
	driverManager.quit();
}




}
