package com.automation.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportUtil {
	
	
	
	public static  ExtentReports initialize() {
		
	    String subFolderPath=  System.getProperty("user.dir") + "/reports/" + CommonUtils.getTimeStamp();
	     System.out.println("the sub folder path is" + subFolderPath);
	     CommonUtils.createFolder(subFolderPath);
		ExtentSparkReporter reporter=new		ExtentSparkReporter( subFolderPath+"/"+"WEB_execution_Automation.html");
		reporter.config().setCss("body { font-family: Arial; } "
                + ".pass { color: green; font-weight: bold; } "
                + ".fail { color: red; font-size: 14px; }");
		reporter.config().setDocumentTitle("Automation Project");
		reporter.config().setOfflineMode(true);
		reporter.config().setReportName("Regression Suite");
		reporter.config().setTheme(Theme.DARK);
		reporter.config().setTimeStampFormat("MMM d, yyyy hh:mm:ss");
		
		ExtentReports	extentReport	= new   ExtentReports();
		extentReport.attachReporter(reporter);
		extentReport.setSystemInfo("userName",System.getProperty("user.name"));
        extentReport.setSystemInfo("Environment","QA");
        extentReport.setSystemInfo("OS Name", System.getProperty("os.name"));
        extentReport.setSystemInfo("OS Version",System.getProperty("os.version"));
		return extentReport;
	}
	
	
}
