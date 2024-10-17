package contacts;

import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import net.datafaker.Faker;

public class FillContactInformation {
	

	@SuppressWarnings({ "deprecation" })
	public static void fillContactInformation(WebDriver driver) throws InterruptedException {
		
		// Use datafaker to generate fake data. 
		Locale IND = new Locale("en", "IN");
		Faker faker = new Faker(IND); 
		
		new Select(driver.findElement(By.name("salutationtype")))
			.selectByValue(randomSalutation());
		
		driver.findElement(By.name("firstname")).sendKeys(faker.name().firstName());
		driver.findElement(By.name("lastname")).sendKeys(faker.name().lastName());
		
		fillOrganizationName(driver);
		
		driver.findElement(By.id("email")).sendKeys(faker.internet().emailAddress());
	}
	
	public static String randomSalutation() {
		String[] salutations = {
				"Mr.","Mrs.","Ms.","Dr.","Prof."
		};
		Random r = new Random(); 
		return salutations[r.nextInt(salutations.length)];
	}
	
	private static void fillOrganizationName(WebDriver driver) throws InterruptedException {
		String parentWindow = driver.getWindowHandle();
		driver.findElement(By.xpath("(//img[@title='Select'])[1]")).click();
		List<String> windows = new LinkedList<String>(driver.getWindowHandles());
		driver.switchTo().window(windows.getLast());
		driver.findElement(By.id("search_txt")).sendKeys("its working");
		driver.findElement(By.xpath("(//tbody/tr[@bgcolor='white'])[1]/td/a")).click();
		driver.switchTo().window(parentWindow);
	}
}
