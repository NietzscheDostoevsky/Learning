package com.crm.utility;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class LoginFunctionalityExcelFile {
	public static String dataString = null;
	
	// returns data value at the given row, cell index
	public static String excel( int row, int cell) {
		
		try {
			FileInputStream fis = new FileInputStream("./src/test/resources/VTigerLoginTestCase.xlsx");
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sheet = wb.getSheet("sheet1");
			dataString = sheet.getRow(row).getCell(cell).toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataString;
	}

	
}
