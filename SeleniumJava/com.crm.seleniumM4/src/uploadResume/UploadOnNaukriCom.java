package uploadResume;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utilityClasses.BaseClassDWS;

public class UploadOnNaukriCom extends BaseClassDWS {
	public static void main(String[] args) {
		String naukri = "https://www.naukri.com/";
		useChromeHeadUblock(naukri);

		driver.findElement(By.id("register_Layer")).click();  sleep(1000);
		driver.findElement(By.className("textWrap")).click(); sleep(1000);
		Actions action = new Actions(driver);
		action.sendKeys(Keys.PAGE_DOWN).perform();

		WebElement sendFile =  driver.findElement(By.xpath("//input[@id='resumeUpload']"));

		String filepath = "C:\\GitHub\\Learning\\SeleniumJava\\test.docx";
		sendFile.sendKeys(filepath); sleep(3000);
		
		boolean isUploaded = driver.findElement(By.className("uploaded-resume")).isDisplayed();
		System.out.println("File Uploaded: " + isUploaded);
	}
}
