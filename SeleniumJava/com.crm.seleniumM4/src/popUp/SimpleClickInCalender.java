package popUp;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import utilityClasses.BaseClassDWS;

public class SimpleClickInCalender extends BaseClassDWS {
	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions(); 
		options.addArguments("disable-notifications");
		options.addExtensions(new File("ublockOrigin.crx"));
		ChromeDriver driver = new ChromeDriver(options);
		
		driver.manage().window().maximize();
		driver.get("https://www.easemytrip.com");
		sleep(5000);
		
//		driver.findElement(By.xpath("//div[@id='dvfarecal']")).click(); sleep(2000);
//		driver.findElement(By.id("20/09/2024")).click(); sleep(2000);
//		driver.findElement(By.id("rdatelbl")).click(); sleep(2000);
//		driver.findElement(By.id("02/10/2024")).click(); sleep(2000);
		
		// Scenarion 2 , dept: 25 October, return : 25 jan. 
		driver.findElement(By.xpath("//div[@id='dvfarecal']")).click(); sleep(2000);
		driver.findElement(By.id("20/09/2024")).click(); sleep(2000);
		
		driver.findElement(By.id("rdatelbl")).click(); sleep(2000);
		System.out.println("opened return date");
		driver.findElement(By.xpath("//img[@id='img2Nex']")).click(); sleep(2000);
		driver.findElement(By.xpath("//img[@id='img2Nex']")).click(); sleep(2000);
		driver.findElement(By.xpath("//img[@id='img2Nex']")).click(); sleep(2000);
		
		driver.findElement(By.xpath("//li[@id='frth_6_25/01/2025']")).click(); 
		sleep(20000);
		driver.quit();
		sleep(2000);
	}
}
