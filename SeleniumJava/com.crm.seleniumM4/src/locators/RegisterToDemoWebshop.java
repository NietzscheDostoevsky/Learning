package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegisterToDemoWebshop {

	public static void main(String[] args) throws InterruptedException {

		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		String demoWebshopURL = "https://demowebshop.tricentis.com/";
		driver.get(demoWebshopURL);
		String webShopTitle = "Demo Web Shop";

		// verification and continue
		if (driver.getTitle().equals(webShopTitle)) {
			System.out.println("Demo Web Shop Opened");
			Thread.sleep(2000);

			// Clicking on register page.
			driver.findElement(By.linkText("Register")).click();

			String regURL = "https://demowebshop.tricentis.com/register";
			if (driver.getCurrentUrl().equals(regURL)) {
				System.out.println("On register Page");
				Thread.sleep(2000);
				fillRegistration(driver);
			} else {
				System.out.println("check URL");
				driver.close();
			}

		} else {
			System.out.println("Change your URL");
		}
		Thread.sleep(3000);
		driver.close();
	}

	public static void fillRegistration(ChromeDriver driver) throws InterruptedException {
		// Filling registration details.
		driver.findElement(By.id("gender-male")).click();
		driver.findElement(By.id("FirstName")).sendKeys("RandomFirstName");
		driver.findElement(By.id("LastName")).sendKeys("RandomLastName");
		driver.findElement(By.id("Email")).sendKeys("abc@xyz.com");
		driver.findElement(By.id("Password")).sendKeys("secretPass");
		driver.findElement(By.id("ConfirmPassword")).sendKeys("secretPass");

		// wait and click register button
		Thread.sleep(2000);
		driver.findElement(By.id("register-button")).click();
	}

}
