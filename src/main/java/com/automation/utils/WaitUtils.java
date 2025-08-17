package com.automation.utils;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {
	
	
	public static void waitForPageLoad(WebDriver driver) {
		
		JavascriptExecutor js=	(JavascriptExecutor)driver;
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(2));
		//here passing driver instance so whene ver its returning false its checking the lment with pooling frquency defult 500 ms
		wait.until(d->js.executeScript("return document.readyState").equals("complete"));
		
	}
	

}
