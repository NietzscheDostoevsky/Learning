package contacts;

import java.util.Locale;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import net.datafaker.Faker;

public class FillContactInformation {
	

	@SuppressWarnings({ "deprecation" })
	public static void fillContactInformation(WebDriver driver) {
		
		// Use datafaker to generate fake data. 
		Locale IND = new Locale("en", "IN");
		Faker faker = new Faker(IND); 
		
		Select select = new Select(driver.findElement(By.name("salutationtype")));
		select.selectByValue(randomSalutation());
		
		
		
	}
	
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		fillContactInformation(driver); 
		driver.quit();
	}
	
	public static String randomSalutation() {
		String[] salutations = {
				"Mr.","Mrs.","Ms.","Dr.","Prof."
		};
		Random r = new Random(); 
		return salutations[r.nextInt(salutations.length)];
	}
}
