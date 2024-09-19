package childBrowserPopUp;

import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import utilityClasses.BaseClassDWS;

public class DWSFollowLinksFillFacebook extends BaseClassDWS{
	public static void main(String[] args) {
		useChrome();
		String parentHandle = driver.getWindowHandle();
		List<WebElement> linksElements = driver.findElements(By.xpath("//div[@class='column follow-us']/ul/li/a"));
		Actions actions = new Actions(driver);	
		for (WebElement link : linksElements) {
			actions.keyDown(Keys.SHIFT).click(link).perform(); sleep(5000);
			LinkedList<String> windows = new LinkedList<>(driver.getWindowHandles()); 
			driver.switchTo().window(windows.getLast());
			String currentURL = driver.getCurrentUrl();
			System.out.println("Link Opened : " +  currentURL );
			
			try {
				if (currentURL.contains("facebook")) { 
					driver.findElement(By.xpath("//span[text()='Create new account']")).click(); sleep(3000);
					
					// Switch to the registration page and fill it. 
					driver.getWindowHandles().forEach((win) -> {
						if (driver.switchTo().window(win).getTitle().contains("Sign up for Facebook"))
							fillFacebookRegistration(driver);
					});
				
				} else if (currentURL.contains("twitter") || 
						 driver.getCurrentUrl().contains("x.com")) {
					sleep(3000);
					driver.findElement(By.xpath("//span[text()='Create account']")).click(); sleep(5000);
					driver.close();				
				} else if (currentURL.contains("rss")) {
					String webtextString = driver.findElement(By.xpath("/html/body/pre")).getText(); sleep(1000);
					System.out.println(webtextString.substring(0, 100));
					driver.close();
					
				} else if (currentURL.contains("youtube")) {
					driver.findElement(By.id("logo-icon")).click(); sleep(5000);
					driver.close();
					
				} else if (currentURL.contains("google")) {
					driver.findElement(By.id("mce-EMAIL")).sendKeys("fake@email.com"); sleep(5000);
					driver.close();				
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			// Closing unrequired windows. 
			for (var w: driver.getWindowHandles())
				if (!w.equals(parentHandle))
					driver.switchTo().window(w).close();
			
			driver.switchTo().window(parentHandle);
			System.out.println("Switched to : " + driver.getCurrentUrl());
			System.out.println(); sleep(1000);
		}			
		postCondition2();
		
	}
	
	private static void fillFacebookRegistration(WebDriver driver) {
		System.out.println("***Welcome to facebook registration***");
		System.out.println(driver.getCurrentUrl());
        driver.findElement(By.cssSelector("input[name='firstname']")).sendKeys("FakeFirstName");
        driver.findElement(By.cssSelector("input[name='lastname']")).sendKeys("FakeLastName");
        driver.findElement(By.cssSelector("input[name='reg_email__']")).sendKeys("abc@xyz.com");
        //driver.findElement(By.cssSelector("input[name='reg_email_confirmation__']")).sendKeys("abc@xyz.com");
        driver.findElement(By.cssSelector("input[name='reg_passwd__']")).sendKeys("fakePass");
        driver.findElement(By.xpath("(//input[@id='sex'])[2]")).click();
   
        Select day = new Select(driver.findElement(By.id("day")));
        day.selectByValue("3"); 
        Select month = new Select(driver.findElement(By.id("month")));
        month.selectByValue("3");
        Select year = new Select(driver.findElement(By.id("year")));
        year.selectByValue("1973");
        System.out.println("Facebook registraion filled. ");
        sleep(5000);
    }
}
