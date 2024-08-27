package selectClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShoppersStackRegistration {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		String shopperURL = "https://shoppersstack.com/";
		driver.get(shopperURL);
		Thread.sleep(10000);
		
		// Verify homepage by title : 
		
		if(driver.getTitle().equals("ShoppersStack")) {
			System.out.println("Home page verified ✅");
			driver.findElement(By.id("loginBtn")).click();
			
			// Verify login page using webelement 
			WebElement uniqueLogin = driver.findElement(By.xpath("//strong"));
			if (uniqueLogin.isDisplayed()) {
							
			} else {
				System.out.println("Login page not gotten");
			}
			
			
			driver.findElement(By.xpath("(//span[@class='MuiButton-label'])[2]")).click();
			fillRegistrationForm(driver);
		
		} else {
			System.out.println("Wrong page");
		}
	

	}

	private static void fillRegistrationForm(ChromeDriver driver) {
		
		driver.findElement(By.id("First Name")).sendKeys("FakeFirstName");
		driver.findElement(By.id("Last Name")).sendKeys("FakeLastName");
		driver.findElement(By.id("Male")).click();
		driver.findElement(By.id("Phone Number")).sendKeys("9898989898");
		driver.findElement(By.id("Email Address")).sendKeys("fake@email.com");
		driver.findElement(By.id("Password")).sendKeys("funny@123HAHA");
		driver.findElement(By.id("Confirm Password")).sendKeys("funny@123HAHA");
		driver.findElement(By.id("Terms and Conditions")).click();
		driver.findElement(By.id("Register"));
		
	}

}
