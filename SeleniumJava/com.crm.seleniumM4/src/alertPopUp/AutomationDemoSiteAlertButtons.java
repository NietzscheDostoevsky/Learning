package alertPopUp;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utilityClasses.BaseClassDWS;

public class AutomationDemoSiteAlertButtons extends BaseClassDWS {
	public static void main(String[] args) {
		String url = "https://demo.automationtesting.in/Alerts.html";
		useChromeHeadUblock(url);
		
		int count = 1;
		
		List<WebElement> AlertButtons = driver.findElements(By.xpath("//div[@class='tabpane pullleft']/ul/li"));
		for (WebElement button : AlertButtons) {
			button.findElement(By.xpath("(//../../following-sibling::div/div)[" + count++ + "]")).click();
			System.out.println("Button clicked");
			sleep(2000);
			driver.switchTo().alert().dismiss();
			System.out.println("Alert handled.");
			sleep(2000);
			
		}
	}
}	
