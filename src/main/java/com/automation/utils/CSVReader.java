package com.automation.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSVReader {
	
	
	public static List<Object[]> getCSVData()  {
		
		List<Object[]> data= new ArrayList<>();
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader("src/main/resources/loginData.csv"));
		
		String line;
	
			while((line=br.readLine())!=null) {
				
				String [] values=		line.split(",");
				data.add(values);
			}
		} 
		
	catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		return data;
		
	}

}
