package com.automation.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	
	
	public static Object[][] getExcelData() {
	//below code cannot be used inside statis method	
	//InputStream inputStream=	getClass().getClassLoader().getResourceAsStream("testData\\PARABankTestData.xlsx");
		
		InputStream inputStream=	ExcelReader.class.getClassLoader().getResourceAsStream("PARABankTestData.xlsx");
		
	XSSFWorkbook workbook = null;
		
		try {
			 workbook = new XSSFWorkbook(inputStream);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	int sheetSize=	workbook.getNumberOfSheets();
	
	//System.out.println(sheetSize);
	Object[][] data=null;
	for(int i=0;i<sheetSize;i++) {
		
	    XSSFSheet sheet = workbook.getSheetAt(i);
	
	if(sheet.getSheetName().equalsIgnoreCase("sheet2")) {
		
	int row=	sheet.getPhysicalNumberOfRows();
	int col=sheet.getRow(0).getPhysicalNumberOfCells();
	
data= new Object[row-1][col];	
	for(int r=1;r<row;r++) {
		
		for(int c=0;c<col;c++) {
			Cell cell	=	sheet.getRow(r).getCell(c);
			
			 DataFormatter formatter = new DataFormatter();
	            String value = formatter.formatCellValue(cell);
	            System.out.println(value);
	            data[r-1][c]=value;
			}
		}
		
	}

	}
	
	return data;
	}
	
	}
	
	
	


