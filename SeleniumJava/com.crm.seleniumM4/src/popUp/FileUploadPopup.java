package popUp;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utilityClasses.BaseClassDWS;

public class FileUploadPopup extends BaseClassDWS {
	public static void main(String[] args) {
		String urlString = "https://www.ilovepdf.com/word_to_pdf";
		useChrome(urlString);
		//String filepath = "C:\\GitHub\\Learning\\SeleniumJava\\test.docx";
		String filepath2 = "testdata/test.docx";
		
		var file = new File(filepath2);
		System.out.println(file.getClass().getName());
		System.out.println(file.getAbsolutePath());
		WebElement sendFile = driver.findElement(By.xpath("//input[@type='file']"));
		sendFile.sendKeys(file.getAbsolutePath());
		
		sleep(3000);
		
		//Verify uploaded file. 
		boolean isDisplayed =  driver.findElement(By.xpath("//div[@data-extension='DOCX']")).isDisplayed();
		System.out.println("Is file uploaded : " + isDisplayed);
		
		postCondition2();
	}
}
