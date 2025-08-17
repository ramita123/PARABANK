package com.automation.test;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automation.base.ConfigurationManager;
import com.automation.base.TestBase;
import com.automation.pages.LoginPage;
import com.automation.utils.CSVReader;
import com.automation.utils.ExcelReader;

public class LoginPageTest extends TestBase{
	


	//@Test(invocationCount=3,threadPoolSize=2)
	@Test(enabled=true)
	public void testValidLogin()  {
	
		// Arrange
	LoginPage loginPage= new LoginPage(driverManager.getDriver());
	String username=ConfigurationManager.getProperty("userName");
	String password=ConfigurationManager.getProperty("password");
		

		// Act
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickLogin();

		// Assert
		//Assert.assertTrue(homePage.isWelcomeMessageDisplayed(), "Login was not successful.");
	}

//	@Test(enabled=true,priority=1,dependsOnMethods= {"testEmptyFields"})
	@Test(enabled=true)
	public void testInvalidPassword() {
		// Arrange
		LoginPage loginPage= new LoginPage(driverManager.getDriver());
		String username = "validUser";
		String password = "wrongPass";

		// Act
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickLogin();

		// Assert
		Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Error message not displayed for invalid password.");
	}

	@Test(enabled=false)
	public void testEmptyFields() {
		LoginPage loginPage= new LoginPage(driverManager.getDriver());
		// Act
		loginPage.enterUsername("");
		loginPage.enterPassword("");
		loginPage.clickLogin();
		
		System.out.println("test");

		// Assert
		Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Error message not displayed for empty credentials.");
	}

	@Test(enabled=false)
	public void testOnlyUsernameEntered() {
		LoginPage loginPage= new LoginPage(driverManager.getDriver());
		// Act
		loginPage.enterUsername("validUser");
		loginPage.enterPassword("");
		loginPage.clickLogin();

		// Assert
		Assert.assertTrue(loginPage.isErrorMessageDisplayed(),
				"Error message not shown when only username is entered.");
	}

	@Test(enabled=false)
	public void testLoginPageElementsVisible() {
		LoginPage loginPage= new LoginPage(driverManager.getDriver());
		// Assert
		Assert.assertTrue(loginPage.isUsernameFieldDisplayed(), "Username field is not visible.");
		Assert.assertTrue(loginPage.isPasswordFieldDisplayed(), "Password field is not visible.");
		Assert.assertTrue(loginPage.isLoginButtonDisplayed(), "Login button is not visible.");
	}
	
	
	@Test(dataProvider="loginData",enabled=false)
	public void getTestDataProvider(String id,String name,String rollNumber) {
		System.out.println(id+name+rollNumber);
	}
	
	
	@DataProvider(name="loginData")
	public Object[][] getExcelData() {
	Object[][] data=	ExcelReader.getExcelData();
	return data;
	}
	
	@DataProvider()
	public Object[][] getCSVData() {
	List<Object[]> data=	CSVReader.getCSVData();
	Object[][] object=	data.toArray(new Object[0][]);
	for (Object[] row : object) {
	    System.out.println(Arrays.toString(row));
	}
	return object;
	}
	
	

}
