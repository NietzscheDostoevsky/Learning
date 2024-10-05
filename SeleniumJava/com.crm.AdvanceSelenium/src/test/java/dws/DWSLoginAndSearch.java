package dws;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import utilityClasses.BaseClass;

@Test
public class DWSLoginAndSearch extends BaseClass {
	
	@Test
	public void login() throws IOException {
		
		String browserString = getDataFromProperties("browser");
		if (browserString.contains("chrome"))
			useChrome();
		else
			useFirefox();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(getDataFromProperties("url"));
		driver.findElement(By.className("ico-login")).click();
		driver.findElement(By.id("Email")).sendKeys(getDataFromProperties("email"));
		driver.findElement(By.id("Password")).sendKeys(getDataFromProperties("password"));
		driver.findElement(By.id("Password")).sendKeys(Keys.ENTER);
		
		FileInputStream excelStream = new FileInputStream("./src/test/resources/searchData.xlsx");
		Workbook wb = WorkbookFactory.create(excelStream);
		Sheet sheet = wb.getSheet("Sheet1");
		String search = sheet.getRow(0).getCell(0).toString();
		
		driver.findElement(By.id("small-searchterms")).sendKeys(search);
		postCondition2();
		
	}
}