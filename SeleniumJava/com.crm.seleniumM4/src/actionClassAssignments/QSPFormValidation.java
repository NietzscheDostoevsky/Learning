package actionClassAssignments;

import org.openqa.selenium.By;

import utilityClasses.BaseClassDWS;

public class QSPFormValidation extends BaseClassDWS {
	
	public static void main(String[] args) {
		String baseURLString = "https://demoapps.qspiders.com/ui/formValidation?sublist=0";
		useChrome(baseURLString); sleep(5000);
		
		driver.findElement(By.name("requiredfield")).sendKeys("Fake Text Data"); sleep(500);
		driver.findElement(By.name("password")).sendKeys("hahapass"); sleep(500);
		driver.findElement(By.name("confirmpass")).sendKeys("hahapass"); sleep(500);
		driver.findElement(By.name("email")).sendKeys("abc@xyz.com"); sleep(500);
		driver.findElement(By.name("url")).sendKeys("google.com"); sleep(500);
		driver.findElement(By.name("digits")).sendKeys("1234"); sleep(500);
		driver.findElement(By.name("number")).sendKeys("123478"); sleep(500);
		driver.findElement(By.name("alphanum")).sendKeys("1234abcd"); sleep(500);
		
		driver.findElement(By.name("minLength")).sendKeys("1234abcd"); sleep(500);
		driver.findElement(By.name("maxLength")).sendKeys("1234ab"); sleep(500);
		driver.findElement(By.name("rangeLength")).sendKeys("1234abcd"); sleep(500);
		driver.findElement(By.name("minValue")).sendKeys("234"); sleep(500);
		driver.findElement(By.name("maxValue")).sendKeys("6"); sleep(500);
		driver.findElement(By.name("rangeValue")).sendKeys("9"); sleep(500);
		
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		
	}
}
