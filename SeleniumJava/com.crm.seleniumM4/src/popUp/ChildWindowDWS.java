package popUp;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import utilityClasses.BaseClassDWS;

public class ChildWindowDWS extends BaseClassDWS  {

	public static void main(String[] args) {
		useChrome();
		
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.PAGE_DOWN).perform(); sleep(500);
		
		driver.findElement(By.linkText("Facebook")).click(); sleep(1000);
		
//		List<String> windowList = new ArrayList<String>(driver.getWindowHandles()); 
//		driver.switchTo().window(windowList.get(1)); sleep(2000);
//		driver.findElement(By.xpath("//span[text()='Create new account']")).click(); sleep(3000);
//		
//		driver.switchTo().window(windowList.get(0));
//		driver.findElement(By.linkText("Twitter")).click(); sleep(2000);
//		
//		windowList = new ArrayList<String>(driver.getWindowHandles());
//		driver.switchTo().window(windowList.get(3)); sleep(4000);
//		driver.findElement(By.xpath("//span[text()='Create account']")).click(); sleep(5000);
		
//		Set<String> windowSet = driver.getWindowHandles();
//		int count = 0; 
//		for (String string : windowSet) { 
//			if(count == 1)
//				driver.switchTo().window(string);
//			count++;
//		}
//		driver.findElement(By.xpath("//span[text()='Create new account']")).click(); sleep(3000);
//		count = 0; 
//		for (String string : windowSet) {
//			if(count == 0)
//				driver.switchTo().window(string); sleep(1000);
//			count++; 
//		}
//		
//		driver.findElement(By.linkText("Twitter")).click(); sleep(5000);
//		windowSet = driver.getWindowHandles();
//		count = 0; 
//		for (String string : windowSet) {
//			if(count == 3 ) {
//				driver.switchTo().window(string);
//				System.out.println(driver.getCurrentUrl());
//			}
//			count++; 
//		}
//		System.out.println(driver.getCurrentUrl());
//		driver.findElement(By.xpath("//span[text()='Create account']")).click(); sleep(5000);
		
		
		Set<String> windowSet = driver.getWindowHandles();
		for (String string: windowSet) {
			driver.switchTo().window(string); 
			if (driver.getCurrentUrl().contains("facebook")) {
				driver.findElement(By.xpath("//span[text()='Create new account']")).click(); sleep(3000);
			}
		}
		
		windowSet = driver.getWindowHandles();
		for (String string: windowSet) {
			driver.switchTo().window(string); 
			if (driver.getCurrentUrl().contains("demo")) {
				driver.findElement(By.linkText("Twitter")).click(); sleep(5000);
			}
		}
		
		windowSet = driver.getWindowHandles();
		for (String string: windowSet) {
			driver.switchTo().window(string); 
			if (driver.getCurrentUrl().contains("twitter")) {
				driver.findElement(By.linkText("Twitter")).click(); sleep(5000);
			}
		}
		
		
		postCondition2();		
	}

}
