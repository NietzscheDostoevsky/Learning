package DWSFollowLinks;

import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.dws.base.BaseClass;

public class ECommerceLinks extends BaseClass {

	@Test
	public void linksTest() {
		String parentHandle = driver.getWindowHandle();
		List<WebElement> linksElements = driver.findElements(By.xpath("//div[@class='column follow-us']/ul/li/a"));
		Actions actions = new Actions(driver);
		for (WebElement link : linksElements) {
			actions.keyDown(Keys.SHIFT).click(link).perform();
			LinkedList<String> windows = new LinkedList<>(driver.getWindowHandles());
			driver.switchTo().window(windows.getLast());
			String currentURL = driver.getCurrentUrl();
			System.out.println("Link Opened : " + currentURL);

			if (currentURL.contains("facebook")) {
				driver.findElement(By.xpath("//span[text()='Create new account']")).click();

				// Switch to the registration page and fill it.
				driver.getWindowHandles().forEach((win) -> {
					if (driver.switchTo().window(win).getTitle().contains("Sign up for Facebook"))
						fillFacebookRegistration(driver);
						try {
							Thread.sleep(5000);
						} catch (Exception e) {
							e.printStackTrace();
						}
				});

				for (var w : driver.getWindowHandles())
					if (!w.equals(parentHandle))
						driver.switchTo().window(w).close();
			}
			
			driver.switchTo().window(parentHandle);
			System.out.println("Switched to : " + driver.getCurrentUrl());
			System.out.println();
		}
	}

	private static void fillFacebookRegistration(WebDriver driver) {
		System.out.println("***Welcome to facebook registration***");
		System.out.println(driver.getCurrentUrl());
		driver.findElement(By.cssSelector("input[name='firstname']")).sendKeys("FakeFirstName");
		driver.findElement(By.cssSelector("input[name='lastname']")).sendKeys("FakeLastName");
		driver.findElement(By.cssSelector("input[name='reg_email__']")).sendKeys("abc@xyz.com");
		// driver.findElement(By.cssSelector("input[name='reg_email_confirmation__']")).sendKeys("abc@xyz.com");
		driver.findElement(By.cssSelector("input[name='reg_passwd__']")).sendKeys("fakePass");
		driver.findElement(By.xpath("(//input[@id='sex'])[2]")).click();

		Select day = new Select(driver.findElement(By.id("day")));
		day.selectByValue("3");
		Select month = new Select(driver.findElement(By.id("month")));
		month.selectByValue("3");
		Select year = new Select(driver.findElement(By.id("year")));
		year.selectByValue("1973");
		System.out.println("Facebook registraion filled. ");
	}
}
