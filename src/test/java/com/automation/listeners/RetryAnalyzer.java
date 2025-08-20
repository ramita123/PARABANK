package com.automation.listeners;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

public class RetryAnalyzer implements IAnnotationTransformer {
	
	 public  void transform(
		      ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		    // not implemented
		 System.out.println("Transformer applied on: " + testMethod.getName());
		 
		 
		 annotation.setRetryAnalyzer(FailRetry.class);
		  }

}
