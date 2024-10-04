package assignment;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DWSLoginPage {
	public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		String baseURL = "https://demowebshop.tricentis.com/";
		driver.get(baseURL);
		if (driver.getCurrentUrl().equals(baseURL))
			System.out.println("homepage verified");
		if (driver.findElement(By.className("ico-login")).isEnabled())
			System.out.println("Login enabled");
		driver.findElement(By.className("ico-login")).click();

		FileInputStream fis = new FileInputStream("..//com.crm.AdvanceSelenium/src/test/resources/login2.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet("Sheet1");
		int rows = sheet.getPhysicalNumberOfRows();

		for (int i = 0; i < rows; i++) {
			int j = 0;

			driver.findElement(By.id("Email")).sendKeys(sheet.getRow(i).getCell(j).toString());
			j++;
			driver.findElement(By.id("Password")).sendKeys(sheet.getRow(i).getCell(j).toString());
			Thread.sleep(2000);
			driver.navigate().refresh();

		}
		driver.quit();
		fis.close();

	}
}
