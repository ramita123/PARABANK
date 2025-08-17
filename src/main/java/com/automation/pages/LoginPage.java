package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	private WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//a[text()='Register']")
	 private WebElement registerLink;
	
	@FindBy(xpath="//a[contains(text(),'Forgot')]")
	private WebElement forgotLoginLink;
	
	@FindBy(name="username")
	private	WebElement userName;
	
	
	@FindBy(name="password")
	private WebElement userPassword;
	
	@FindBy(xpath="//input[@value='Log In']")
	private WebElement loginBtn;
	
	public void enterUsername(String username) {
		// TODO Auto-generated method stub
	
		userName.sendKeys(username);
	}

	public void enterPassword(String password) {
		// TODO Auto-generated method stub
		userPassword.sendKeys(password);
	}
	
	public void clickLogin() {
		loginBtn.click();
	
	}
	
	public RegistrationPage clickRegister() {
        registerLink.click();
        return new RegistrationPage(driver); 
    }

    public ForgotLoginPage clickForgotLogin() {
        forgotLoginLink.click();
        return new ForgotLoginPage(driver); 
    }

	public boolean isErrorMessageDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isUsernameFieldDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isPasswordFieldDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isLoginButtonDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}

	

}
