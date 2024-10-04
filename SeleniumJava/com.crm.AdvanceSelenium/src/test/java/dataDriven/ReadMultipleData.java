package dataDriven;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadMultipleData {
	
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		//FileInputStream fis = new FileInputStream("C:\\GitHub\\Learning\\SeleniumJava\\login.xlsx");
		FileInputStream fis2 = new FileInputStream("../com.crm.AdvanceSelenium/src/test/resources/login2.xlsx");
		Workbook wb = WorkbookFactory.create(fis2);
		Sheet sheet = wb.getSheet("Sheet1");
		String email = sheet.getRow(0).getCell(0).toString();
		String password = sheet.getRow(0).getCell(1).toString();
		System.out.println(email + " " + password);
		
		int rows = sheet.getPhysicalNumberOfRows();
		int cols = sheet.getRow(0).getPhysicalNumberOfCells();
		
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				String data = sheet.getRow(i).getCell(j).toString();
				System.out.println(data);
			}
		}
		
	}
}
