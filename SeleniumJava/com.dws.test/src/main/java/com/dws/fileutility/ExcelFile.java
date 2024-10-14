package com.dws.fileutility;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFile {
	public static String excel(String s, int row, int cell) {
		
		String dataString = null;
		try {
			FileInputStream fis = new FileInputStream("./src/test/resources/login2.xlsx");
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sheet = wb.getSheet(s);
			dataString = sheet.getRow(row).getCell(cell).toString();
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return dataString;
	}
}
