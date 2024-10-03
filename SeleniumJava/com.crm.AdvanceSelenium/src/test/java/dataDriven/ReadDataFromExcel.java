package dataDriven;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

@Test
public class ReadDataFromExcel {

	@Test
	public void login() throws InterruptedException, EncryptedDocumentException, IOException {
		
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://demowebshop.tricentis.com/");
		driver.findElement(By.linkText("Log in")).click();
		fillLoginPage(driver);

	}

	public static void fillLoginPage(WebDriver driver) throws InterruptedException, EncryptedDocumentException, IOException {
		//get the data from excel file
		FileInputStream fis = new FileInputStream("C:\\GitHub\\Learning\\SeleniumJava\\login.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		var sheet = wb.getSheet("Sheet1");
		
		String email = sheet.getRow(0).getCell(0).toString();
		String password = sheet.getRow(0).getCell(1).toString();
		
		
		// Fill login details.
		driver.findElement(By.id("Email")).sendKeys(email);
		driver.findElement(By.id("Password")).sendKeys(password);
		driver.findElement(By.id("RememberMe")).click();

	}

}
