package iFrame;


import java.time.Duration;
import java.util.LinkedList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * Open the browser.  
 * Maximize();  
 * Enter into iframe pae.  
 * Verify the page by using webElement 
 * After verificateion, click fb link which is prensent at the bottom.  
 * Click create new account present in fb page.  
 * Afterwards, send some values inside the dws search field.  
 * Click the google link. 
 * Close the browser.  
 */

public class IframePage {
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver(); 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.manage().window().maximize();
		String url ;
		if (System.getProperty("os.name").equals("Linux"))
			url =  "file:///home/saurabh-singh/Documents/GitHub/Learning/SeleniumJava/com.crm.seleniumM4/testdata/iframe.html";
		else 
			url = "C:\\GitHub\\Learning\\SeleniumJava\\MultipleWindow-1.html";
		driver.get(url);
		String parentWindow = driver.getWindowHandle();
		driver.switchTo().frame("frame1");
		if (driver.findElement(By.className("header-logo")).isDisplayed())
			System.out.println("Inside DWS frame");
		else 
			System.out.println("Not inside dws");
		
		// Click on facebook
		driver.findElement(By.linkText("Facebook")).click();
		System.out.println("clicked fb");
		LinkedList<String> handle = new LinkedList<String>(driver.getWindowHandles());
		System.out.println(handle.size());
		driver.switchTo().window(handle.getLast());
		System.out.println(driver.getCurrentUrl());
		driver.findElement(By.xpath("//span[text()='Create new account']")).click();
		System.out.println("clicked registration");
		handle = new LinkedList<String>(driver.getWindowHandles());
		handle.stream()
			  .filter(window -> !window.equals(parentWindow))
			  .forEach(window->driver.switchTo().window(window).close());
		driver.switchTo().window(parentWindow);
		System.out.println(driver.getCurrentUrl());
		driver.switchTo().frame("frame1");
		driver.findElement(By.id("small-searchterms")).sendKeys("iPhone");
		driver.findElement(By.linkText("Google+")).click();
	}
}
