package com.automation.utils;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class CommonUtils {
	
	
	public static String getScreenshot(WebDriver driver, String testcaseName) {
		
		TakesScreenshot takesScreenshot=	(TakesScreenshot)driver;
		File scr=	takesScreenshot.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scr, new File(System.getProperty("user.dir")+"//screenshots//"+testcaseName+getTimeStamp()+".png"));
		} catch (IOException e) {

			e.printStackTrace();
		}

		return System.getProperty("user.dir")+"//screenshots//"+testcaseName+getTimeStamp()+".png";
		
		}
	
	
	public static String getTimeStamp() {
		DateTimeFormatter formatter= DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
		
		return LocalDateTime.now().format(formatter);
			
	}
	
	public static  void createFolder(String subFolderPath) {
		
		File file= new File(subFolderPath);
		
	if(!file.exists()) {
	boolean created=	file.mkdir();// Use mkdirs() to create parent folders if needed
     if (created) {
         System.out.println("Folder created: " + subFolderPath);
     } else {
         System.out.println("Failed to create folder: " + subFolderPath);
     }
 } else {
     System.out.println("Folder already exists: " + subFolderPath);
 }
	}
		
	}


