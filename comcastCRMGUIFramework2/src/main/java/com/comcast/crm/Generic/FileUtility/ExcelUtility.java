package com.comcast.crm.Generic.FileUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {

	public String getDataFromExcelFile(String sheetName, int rowNum, int cellNum) throws Exception {
		FileInputStream fis = new FileInputStream("./resource/OrgTestCases.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
		wb.close();
		return data;
	}

	public int rowCount(String sheetName) throws Exception {
		FileInputStream fis = new FileInputStream("./resource/OrgTestCases.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		int rowCount = wb.getSheet(sheetName).getLastRowNum();
		wb.close();
		return rowCount;
	}


	public void setDataIntoExcelFile(String sheetName, int rowNum, int cellNum, String data) throws Exception {
		FileInputStream fis = new FileInputStream("./resource/OrgTestCases.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet(sheetName).getRow(rowNum).createCell(cellNum);
		
		FileOutputStream fos = new FileOutputStream("./resource/OrgTestCases.xlsx");
		wb.write(fos);
		wb.close();
	}
	
	public String getContactDataFromExcelFile(String sheetName, int rowNum, int cellNum) throws Exception {
		FileInputStream fis = new FileInputStream("./resource/ContactTest.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
		wb.close();
		return data;
	}

	public int ContactrowCount(String sheetName) throws Exception {
		FileInputStream fis = new FileInputStream("./resource/ContactTest.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		int rowCount = wb.getSheet(sheetName).getLastRowNum();
		wb.close();
		return rowCount;
	}


	public void setContactDataIntoExcelFile(String sheetName, int rowNum, int cellNum, String data) throws Exception {
		FileInputStream fis = new FileInputStream("./resource/ContactTest.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet(sheetName).getRow(rowNum).createCell(cellNum);
		
		FileOutputStream fos = new FileOutputStream("./resource/ContactTest.xlsx");
		wb.write(fos);
		wb.close();
	}
}
