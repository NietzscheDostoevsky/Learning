package selectClassAssignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

/**
 * Assignment 2 :  QSP demp website 
 * 	✅	Open the browser 
 * 	✅	Maximize 
 * 	✅	Enter into qsp demo site 
 * 	✅	Verify using url 
 * 	✅	Click UI testing concepts.  
 * 	✅  Click web Elements section  
 * 	✅	Click dropdown  
 * 	✅	Perform all the actions.  
 */

public class QSPDropdownSelect {

	public static void main(String[] args) throws InterruptedException {
		String qspURL = "https://demoapps.qspiders.com/";
		
		WebDriver driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		driver.get(qspURL);
		
		while(true) {
			try {
				driver.findElement(By.xpath("(//div[@title='Learn More'])[1]"));
				break;
			} catch (Exception e) {
				System.out.println("Can't find login button yet, sleeping for 5 seconds");
				Thread.sleep(5000);
			}
		}
		
		if(driver.getCurrentUrl().equals(qspURL)) {
			System.out.println("URL Verified ✔️");
			driver.findElement(By.xpath("(//div[@title='Learn More'])[1]")).click();
			Thread.sleep(10000);
			driver.findElement(By.xpath("//section[text()='Dropdown']")).click();
			Thread.sleep(5000);
			driver.findElement(By.id("phone")).sendKeys("9989089898");
			
			Select selectCountryCode = new Select(driver.findElement(By.xpath("(//select)[2]")));
			selectCountryCode.selectByIndex(0);
			Select selectGender = new Select(driver.findElement(By.xpath("(//select)[3]")));
			selectGender.selectByValue("male");
			Select selectCountry = new Select(driver.findElement(By.xpath("(//select)[4]")));
			selectCountry.selectByValue("India");
			Select selectState = new Select(driver.findElement(By.xpath("(//select)[5]")));
			selectState.selectByValue("Maharashtra");
			Select selectCity = new Select(driver.findElement(By.xpath("(//select)[6]")));
			selectCity.selectByValue("Pune");
			Select selectQuantity = new Select(driver.findElement(By.xpath("(//select)[7]")));
			selectQuantity.selectByValue("3");
			

		} else System.out.println("Wrong URL");
		
		Thread.sleep(5000);
		driver.quit();
	}

}
